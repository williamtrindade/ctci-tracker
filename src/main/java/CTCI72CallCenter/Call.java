package CTCI72CallCenter;

/** Uma ligação: guarda o nível mínimo necessário para atendê-la. */
public class Call {
    private final String caller;
    private Rank rank = Rank.RESPONDER;
    private Employee handler;

    public Call(String caller) {
        this.caller = caller;
    }

    public Call(String caller, Rank minimumRank) {
        this.caller = caller;
        this.rank = minimumRank;
    }

    public String getCaller() {
        return caller;
    }

    public Rank getRank() {
        return rank;
    }

    public void incrementRank() {
        if (rank == Rank.RESPONDER) {
            rank = Rank.MANAGER;
        } else if (rank == Rank.MANAGER) {
            rank = Rank.DIRECTOR;
        }
    }

    public Employee getHandler() {
        return handler;
    }

    public void setHandler(Employee handler) {
        this.handler = handler;
    }

    @Override
    public String toString() {
        return "Call(" + caller + ", " + rank + ")";
    }
}
