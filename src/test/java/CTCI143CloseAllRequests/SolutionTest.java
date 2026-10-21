package CTCI143CloseAllRequests;

import common.Db;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void closesOnlyRequestsOfBuilding11() throws Exception {
        try (Connection c = Db.open(Db.APARTMENTS_SCHEMA)) {
            Db.update(c, new Solution().query());
            List<List<String>> rows = Db.query(c, "SELECT RequestID, Status FROM Requests ORDER BY RequestID");
            assertEquals(List.of(
                    List.of("1", "Open"),    // prédio 10
                    List.of("2", "Closed"),
                    List.of("3", "Open"),    // prédio 10
                    List.of("4", "Closed"),  // prédio 11
                    List.of("5", "Closed"),  // prédio 11
                    List.of("6", "Closed")), rows);
        }
    }
}
