package CTCI72CallCenter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    @Test
    void callsGoToRespondentsFirstThenEscalateByAvailability() {
        Solution.CallHandler handler = new Solution.CallHandler(2, 1, 1);
        assertEquals(Rank.RESPONDER, handler.dispatchCall(new Call("a")).getRank());
        assertEquals(Rank.RESPONDER, handler.dispatchCall(new Call("b")).getRank());
        assertEquals(Rank.MANAGER, handler.dispatchCall(new Call("c")).getRank());
        assertEquals(Rank.DIRECTOR, handler.dispatchCall(new Call("d")).getRank());
        assertNull(handler.dispatchCall(new Call("e")));
        assertEquals(1, handler.queuedCalls());
    }

    @Test
    void callWithMinimumRankSkipsLowerLevels() {
        Solution.CallHandler handler = new Solution.CallHandler(3, 1, 1);
        Employee e = handler.dispatchCall(new Call("vip", Rank.MANAGER));
        assertEquals(Rank.MANAGER, e.getRank());
        Employee d = handler.dispatchCall(new Call("vip2", Rank.MANAGER));
        assertEquals(Rank.DIRECTOR, d.getRank());
        assertNull(handler.dispatchCall(new Call("vip3", Rank.DIRECTOR)));
    }

    @Test
    void completedCallPullsNextFromQueue() {
        Solution.CallHandler handler = new Solution.CallHandler(1, 0, 0);
        Call first = new Call("first");
        Call second = new Call("second");
        Employee r = handler.dispatchCall(first);
        assertNull(handler.dispatchCall(second));
        handler.callCompleted(r);
        assertSame(second, r.getCurrentCall());
        assertEquals(0, handler.queuedCalls());
        handler.callCompleted(r);
        assertTrue(r.isFree());
    }

    @Test
    void escalateMovesCallToManager() {
        Solution.CallHandler handler = new Solution.CallHandler(1, 1, 1);
        Call call = new Call("hard");
        Employee respondent = handler.dispatchCall(call);
        assertEquals(Rank.RESPONDER, respondent.getRank());
        handler.escalate(respondent);
        assertTrue(respondent.isFree());
        assertEquals(Rank.MANAGER, call.getRank());
        assertEquals(Rank.MANAGER, call.getHandler().getRank());
        handler.escalate(call.getHandler());
        assertEquals(Rank.DIRECTOR, call.getHandler().getRank());
    }

    @Test
    void freedRespondentDoesNotTakeCallAboveItsLevel() {
        Solution.CallHandler handler = new Solution.CallHandler(1, 1, 0);
        Employee respondent = handler.dispatchCall(new Call("r"));
        Employee manager = handler.dispatchCall(new Call("m"));
        Call vip = new Call("vip", Rank.MANAGER);
        assertNull(handler.dispatchCall(vip));
        handler.callCompleted(respondent);
        assertTrue(respondent.isFree(), "O atendente não pode pegar uma ligação de nível gerente");
        handler.callCompleted(manager);
        assertSame(vip, manager.getCurrentCall());
    }
}
