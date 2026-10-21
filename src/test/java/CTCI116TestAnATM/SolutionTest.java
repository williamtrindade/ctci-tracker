package CTCI116TestAnATM;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private final LocalDate today = LocalDate.of(2026, 10, 18);
    private Solution.Bank bank;
    private Solution.Atm atm;

    @BeforeEach
    void setUp() {
        bank = new Solution.Bank();
        bank.openAccount("ana", "1234", 2000);
        atm = new Solution.Atm(bank, 5000);
    }

    @Test
    void successfulWithdrawAndDeposit() {
        assertEquals(AtmResult.OK, atm.withdraw("ana", "1234", 300, today));
        assertEquals(1700, bank.getBalance("ana"));
        assertEquals(4700, atm.getCash());
        assertEquals(AtmResult.OK, atm.deposit("ana", "1234", 50));
        assertEquals(1750, bank.getBalance("ana"));
        assertEquals(4750, atm.getCash());
    }

    @Test
    void authentication() {
        assertEquals(AtmResult.UNKNOWN_ACCOUNT, atm.withdraw("bob", "1234", 10, today));
        assertEquals(AtmResult.WRONG_PIN, atm.withdraw("ana", "0000", 10, today));
        assertEquals(AtmResult.OK, atm.withdraw("ana", "1234", 10, today)); // acerto zera o contador
        assertEquals(AtmResult.WRONG_PIN, atm.withdraw("ana", "0000", 10, today));
        assertEquals(AtmResult.WRONG_PIN, atm.withdraw("ana", "0000", 10, today));
        assertEquals(AtmResult.WRONG_PIN, atm.withdraw("ana", "0000", 10, today)); // 3º erro: bloqueia
        assertEquals(AtmResult.ACCOUNT_LOCKED, atm.withdraw("ana", "1234", 10, today));
        assertEquals(AtmResult.ACCOUNT_LOCKED, atm.deposit("ana", "1234", 10));
    }

    @Test
    void invalidAmounts() {
        assertEquals(AtmResult.INVALID_AMOUNT, atm.withdraw("ana", "1234", 0, today));
        assertEquals(AtmResult.INVALID_AMOUNT, atm.withdraw("ana", "1234", -10, today));
        assertEquals(AtmResult.INVALID_AMOUNT, atm.withdraw("ana", "1234", 15, today));
        assertEquals(AtmResult.INVALID_AMOUNT, atm.deposit("ana", "1234", 0));
        assertEquals(2000, bank.getBalance("ana"));
    }

    @Test
    void limitsFundsAndCash() {
        assertEquals(AtmResult.DAILY_LIMIT_EXCEEDED, atm.withdraw("ana", "1234", 1010, today));
        assertEquals(AtmResult.OK, atm.withdraw("ana", "1234", 1000, today));
        assertEquals(AtmResult.DAILY_LIMIT_EXCEEDED, atm.withdraw("ana", "1234", 10, today));
        assertEquals(AtmResult.OK, atm.withdraw("ana", "1234", 1000, today.plusDays(1)));
        assertEquals(AtmResult.INSUFFICIENT_FUNDS, atm.withdraw("ana", "1234", 10, today.plusDays(2)));

        bank.openAccount("rich", "9999", 1_000_000);
        Solution.Atm poorAtm = new Solution.Atm(bank, 100);
        assertEquals(AtmResult.ATM_OUT_OF_CASH, poorAtm.withdraw("rich", "9999", 200, today));
        assertEquals(1_000_000, bank.getBalance("rich"));
    }

    @Test
    @Timeout(10)
    void concurrentWithdrawalsOnTwoAtmsNeverOverdraw() throws Exception {
        bank.openAccount("shared", "1111", 500);
        Solution.Atm atm1 = new Solution.Atm(bank, 100_000);
        Solution.Atm atm2 = new Solution.Atm(bank, 100_000);
        AtomicInteger ok = new AtomicInteger();
        CountDownLatch start = new CountDownLatch(1);
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Solution.Atm target = i % 2 == 0 ? atm1 : atm2;
            Thread t = new Thread(() -> {
                try {
                    start.await();
                } catch (InterruptedException e) {
                    return;
                }
                if (target.withdraw("shared", "1111", 10, today) == AtmResult.OK) {
                    ok.incrementAndGet();
                }
            });
            threads.add(t);
            t.start();
        }
        start.countDown();
        for (Thread t : threads) {
            t.join();
        }
        assertEquals(50, ok.get());
        assertEquals(0, bank.getBalance("shared"));
        assertEquals(200_000 - 500, atm1.getCash() + atm2.getCash());
    }
}
