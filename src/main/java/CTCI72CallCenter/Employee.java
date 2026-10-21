package CTCI72CallCenter;

/** Funcionário do call center. */
public class Employee {
    private final String name;
    private final Rank rank;
    private Call currentCall;

    public Employee(String name, Rank rank) {
        this.name = name;
        this.rank = rank;
    }

    public String getName() {
        return name;
    }

    public Rank getRank() {
        return rank;
    }

    public Call getCurrentCall() {
        return currentCall;
    }

    public void setCurrentCall(Call call) {
        this.currentCall = call;
    }

    public boolean isFree() {
        return currentCall == null;
    }

    @Override
    public String toString() {
        return name + "(" + rank + ")";
    }
}
