package CTCI36AnimalShelter;

public abstract class Animal {
    private int order;
    protected final String name;

    protected Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    /** Compara a ordem de chegada dos animais. */
    public boolean isOlderThan(Animal other) {
        return this.order < other.getOrder();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + name + ")";
    }
}
