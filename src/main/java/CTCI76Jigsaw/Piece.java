package CTCI76Jigsaw;

import java.util.EnumMap;
import java.util.Map;

/** Peça com 4 bordas. */
public class Piece {
    private final int id;
    private final Map<Orientation, Edge> edges = new EnumMap<>(Orientation.class);

    public Piece(int id, Edge left, Edge top, Edge right, Edge bottom) {
        this.id = id;
        edges.put(Orientation.LEFT, left);
        edges.put(Orientation.TOP, top);
        edges.put(Orientation.RIGHT, right);
        edges.put(Orientation.BOTTOM, bottom);
    }

    public int getId() {
        return id;
    }

    public Edge getEdge(Orientation orientation) {
        return edges.get(orientation);
    }

    /** Gira a peça no sentido horário numberRotations vezes (a borda LEFT vira TOP, etc.). */
    public void rotateEdgesBy(int numberRotations) {
        Orientation[] orientations = Orientation.values();
        Map<Orientation, Edge> rotated = new EnumMap<>(Orientation.class);
        int k = ((numberRotations % 4) + 4) % 4;
        for (int i = 0; i < orientations.length; i++) {
            Orientation from = orientations[i];
            Orientation to = orientations[(i + k) % 4];
            rotated.put(to, edges.get(from));
        }
        edges.putAll(rotated);
    }

    public int flatEdgeCount() {
        int count = 0;
        for (Edge e : edges.values()) {
            if (e.getShape() == Shape.FLAT) {
                count++;
            }
        }
        return count;
    }

    public boolean isCorner() {
        return flatEdgeCount() == 2;
    }

    public boolean isBorder() {
        return flatEdgeCount() == 1;
    }

    @Override
    public String toString() {
        return "Piece#" + id + edges;
    }
}
