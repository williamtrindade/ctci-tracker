package CTCI76Jigsaw;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    /** Gera um quebra-cabeça resolvido, embaralha e gira as peças aleatoriamente. */
    private static List<Piece> generate(int size, Random random) {
        Edge[][] rightEdges = new Edge[size][size];
        Edge[][] bottomEdges = new Edge[size][size];
        int code = 1;
        List<Piece> pieces = new ArrayList<>();
        int id = 0;
        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                Edge left = c == 0 ? new Edge(Shape.FLAT, 0) : opposite(rightEdges[r][c - 1]);
                Edge top = r == 0 ? new Edge(Shape.FLAT, 0) : opposite(bottomEdges[r - 1][c]);
                Edge right = c == size - 1 ? new Edge(Shape.FLAT, 0)
                        : new Edge(random.nextBoolean() ? Shape.INNER : Shape.OUTER, code++);
                Edge bottom = r == size - 1 ? new Edge(Shape.FLAT, 0)
                        : new Edge(random.nextBoolean() ? Shape.INNER : Shape.OUTER, code++);
                rightEdges[r][c] = right;
                bottomEdges[r][c] = bottom;
                Piece p = new Piece(id++, left, top, right, bottom);
                p.rotateEdgesBy(random.nextInt(4));
                pieces.add(p);
            }
        }
        Collections.shuffle(pieces, random);
        return pieces;
    }

    private static Edge opposite(Edge e) {
        return new Edge(e.getShape().getOpposite(), e.getCode());
    }

    private static void assertSolved(Piece[][] grid, int size, List<Piece> pieces) {
        assertNotNull(grid);
        assertEquals(size, grid.length);
        Set<Piece> used = new HashSet<>();
        for (int r = 0; r < size; r++) {
            assertEquals(size, grid[r].length);
            for (int c = 0; c < size; c++) {
                Piece p = grid[r][c];
                assertNotNull(p);
                used.add(p);
                if (c == 0) {
                    assertEquals(Shape.FLAT, p.getEdge(Orientation.LEFT).getShape());
                } else {
                    assertTrue(grid[r][c - 1].getEdge(Orientation.RIGHT).fitsWith(p.getEdge(Orientation.LEFT)),
                            "Peças (" + r + "," + (c - 1) + ") e (" + r + "," + c + ") não encaixam");
                }
                if (r == 0) {
                    assertEquals(Shape.FLAT, p.getEdge(Orientation.TOP).getShape());
                } else {
                    assertTrue(grid[r - 1][c].getEdge(Orientation.BOTTOM).fitsWith(p.getEdge(Orientation.TOP)),
                            "Peças (" + (r - 1) + "," + c + ") e (" + r + "," + c + ") não encaixam");
                }
                if (c == size - 1) {
                    assertEquals(Shape.FLAT, p.getEdge(Orientation.RIGHT).getShape());
                }
                if (r == size - 1) {
                    assertEquals(Shape.FLAT, p.getEdge(Orientation.BOTTOM).getShape());
                }
            }
        }
        assertEquals(new HashSet<>(pieces), used, "Todas as peças devem ser usadas uma vez");
    }

    @Test
    void solvesSmallPuzzles() {
        Random random = new Random(7);
        for (int size = 1; size <= 4; size++) {
            List<Piece> pieces = generate(size, random);
            assertSolved(solution.solve(new ArrayList<>(pieces), size), size, pieces);
        }
    }

    @Test
    void solvesBiggerPuzzles() {
        Random random = new Random(77);
        for (int t = 0; t < 5; t++) {
            List<Piece> pieces = generate(10, random);
            assertSolved(solution.solve(new ArrayList<>(pieces), 10), 10, pieces);
        }
    }
}
