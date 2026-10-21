package CTCI178CircusTower;

public record HtWt(int height, int weight) {
    /** true se esta pessoa pode ficar em cima de {@code other}. */
    public boolean isBefore(HtWt other) {
        return height < other.height && weight < other.weight;
    }
}
