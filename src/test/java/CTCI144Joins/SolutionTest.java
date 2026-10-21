package CTCI144Joins;

import common.Db;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static final String SCHEMA = """
            CREATE TABLE RegularBeverages (Name VARCHAR(50), Code VARCHAR(20));
            CREATE TABLE CalorieFreeBeverages (Code VARCHAR(20), Name VARCHAR(50));
            INSERT INTO RegularBeverages VALUES ('Budweiser', 'BUDWEISER'), ('Coca-Cola', 'COCACOLA'), ('Pepsi', 'PEPSI');
            INSERT INTO CalorieFreeBeverages VALUES ('COCACOLA', 'Diet Coca-Cola'), ('FRESCA', 'Fresca'),
              ('PEPSI', 'Diet Pepsi'), ('PEPSI', 'Pepsi Light'), ('PURITY', 'Water');
            """;

    private final Solution solution = new Solution();

    private static List<String> run(String sql) throws Exception {
        try (Connection c = Db.open(SCHEMA)) {
            List<String> rows = new ArrayList<>();
            for (List<String> row : Db.query(c, sql)) {
                rows.add(row.get(0) + " | " + row.get(1));
            }
            Collections.sort(rows);
            return rows;
        }
    }

    @Test
    void innerJoin() throws Exception {
        assertEquals(List.of("Coca-Cola | Diet Coca-Cola", "Pepsi | Diet Pepsi", "Pepsi | Pepsi Light"),
                run(solution.innerJoin()));
    }

    @Test
    void leftOuterJoin() throws Exception {
        assertEquals(List.of("Budweiser | NULL", "Coca-Cola | Diet Coca-Cola", "Pepsi | Diet Pepsi", "Pepsi | Pepsi Light"),
                run(solution.leftOuterJoin()));
    }

    @Test
    void rightOuterJoin() throws Exception {
        assertEquals(List.of("Coca-Cola | Diet Coca-Cola", "NULL | Fresca", "NULL | Water", "Pepsi | Diet Pepsi",
                "Pepsi | Pepsi Light"), run(solution.rightOuterJoin()));
    }

    @Test
    void fullOuterJoin() throws Exception {
        assertEquals(List.of("Budweiser | NULL", "Coca-Cola | Diet Coca-Cola", "NULL | Fresca", "NULL | Water",
                "Pepsi | Diet Pepsi", "Pepsi | Pepsi Light"), run(solution.fullOuterJoin()));
    }
}
