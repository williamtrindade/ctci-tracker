package CTCI141MultipleApartments;

import common.Db;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    @Test
    void tenantsWithMoreThanOneApartment() throws Exception {
        try (Connection c = Db.open(Db.APARTMENTS_SCHEMA)) {
            List<List<String>> rows = Db.query(c, new Solution().query());
            Set<List<String>> result = new HashSet<>(rows);
            assertEquals(rows.size(), result.size(), "Sem linhas repetidas");
            assertEquals(Set.of(List.of("Ana"), List.of("Carla")), result);
        }
    }

    @Test
    void tenantsWithSameNameAreNotMerged() throws Exception {
        try (Connection c = Db.open(Db.APARTMENTS_SCHEMA
                + "; INSERT INTO Tenants VALUES (5, 'Bruno'); INSERT INTO AptTenants VALUES (5, 104)")) {
            // Há dois "Bruno", cada um com UM apartamento: nenhum deve aparecer
            List<List<String>> rows = Db.query(c, new Solution().query());
            assertEquals(Set.of(List.of("Ana"), List.of("Carla")), new HashSet<>(rows));
        }
    }
}
