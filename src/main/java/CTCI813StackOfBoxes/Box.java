package CTCI813StackOfBoxes;

public record Box(int width, int height, int depth) {
    /** Esta caixa pode ficar embaixo de {@code top}? */
    public boolean canBeUnder(Box top) {
        return width > top.width && height > top.height && depth > top.depth;
    }
}
