package CTCI1622LangtonsAnt;

import java.util.Set;

public record AntState(Set<Position> blackCells, Position ant, Orientation orientation) {
}
