package CTCI82RobotInAGrid;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SolutionTest {

    private final Solution solution = new Solution();

    private static boolean[][] open(int rows, int cols) {
        boolean[][] maze = new boolean[rows][cols];
        for (boolean[] row : maze) {
            Arrays.fill(row, true);
        }
        return maze;
    }

    private static void assertValidPath(boolean[][] maze, List<Point> path) {
        assertNotNull(path, "Existe um caminho");
        int rows = maze.length;
        int cols = maze[0].length;
        assertEquals(new Point(0, 0), path.get(0));
        assertEquals(new Point(rows - 1, cols - 1), path.get(path.size() - 1));
        assertEquals(rows + cols - 1, path.size());
        for (int i = 0; i < path.size(); i++) {
            Point p = path.get(i);
            assertTrue(maze[p.row()][p.col()], "Célula proibida no caminho: " + p);
            if (i > 0) {
                Point prev = path.get(i - 1);
                boolean right = p.row() == prev.row() && p.col() == prev.col() + 1;
                boolean down = p.col() == prev.col() && p.row() == prev.row() + 1;
                assertTrue(right || down, "Movimento inválido de " + prev + " para " + p);
            }
        }
    }

    @Test
    void openGrid() {
        boolean[][] maze = open(3, 4);
        assertValidPath(maze, solution.getPath(maze));
    }

    @Test
    void gridWithObstacles() {
        boolean[][] maze = {
                {true, true, false, true},
                {false, true, true, false},
                {true, false, true, true},
                {true, true, false, true}
        };
        assertValidPath(maze, solution.getPath(maze));
    }

    @Test
    void noPath() {
        boolean[][] maze = {
                {true, false},
                {false, true}
        };
        assertNull(solution.getPath(maze));
        boolean[][] blockedStart = open(2, 2);
        blockedStart[0][0] = false;
        assertNull(solution.getPath(blockedStart));
    }

    @Test
    void singleCell() {
        assertEquals(List.of(new Point(0, 0)), solution.getPath(new boolean[][]{{true}}));
    }

    @Test
    @Timeout(3)
    void largeGridWithoutExitMustUseMemoization() {
        boolean[][] maze = open(40, 40);
        maze[39][38] = false;
        maze[38][39] = false;
        assertNull(solution.getPath(maze));
    }

    @Test
    @Timeout(3)
    void largeGridWithPath() {
        boolean[][] maze = open(60, 60);
        for (int i = 1; i < 59; i++) {
            maze[i][30] = false; // parede com uma brecha na linha 0
        }
        assertValidPath(maze, solution.getPath(maze));
    }
}
