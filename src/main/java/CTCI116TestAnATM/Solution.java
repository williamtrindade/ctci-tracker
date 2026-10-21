package CTCI116TestAnATM;

import java.time.LocalDate;

public class Solution {

    public static class Bank {
        public void openAccount(String id, String pin, long balance) {
            // TODO: Implement CTCI 11.6 Test an ATM
            throw new UnsupportedOperationException("TODO: CTCI 11.6 Test an ATM");
        }

        public long getBalance(String id) {
            throw new UnsupportedOperationException("TODO: CTCI 11.6 Test an ATM");
        }
    }

    public static class Atm {
        public Atm(Bank bank, long cash) {
            // TODO: Implement CTCI 11.6 Test an ATM
        }

        public long getCash() {
            throw new UnsupportedOperationException("TODO: CTCI 11.6 Test an ATM");
        }

        public AtmResult withdraw(String id, String pin, long amount, LocalDate date) {
            throw new UnsupportedOperationException("TODO: CTCI 11.6 Test an ATM");
        }

        public AtmResult deposit(String id, String pin, long amount) {
            throw new UnsupportedOperationException("TODO: CTCI 11.6 Test an ATM");
        }
    }
}
