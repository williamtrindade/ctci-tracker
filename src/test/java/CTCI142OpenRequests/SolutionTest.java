package CTCI142OpenRequests;

import common.Db;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void allBuildingsWithOpenRequestCount() throws Exception {
        try (Connection c = Db.open(Db.APARTMENTS_SCHEMA)) {
            List<List<String>> rows = Db.query(c, new Solution().query());
            assertEquals(3, rows.size());
            assertEquals(Set.of(List.of("Tower A", "2"), List.of("Tower B", "2"), List.of("Tower C", "0")),
                    new HashSet<>(rows));
        }
    }
}
