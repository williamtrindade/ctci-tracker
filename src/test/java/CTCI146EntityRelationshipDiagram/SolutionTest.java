package CTCI146EntityRelationshipDiagram;

import common.Db;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SolutionTest {

    private Connection setUp() throws SQLException {
        Connection c = Db.open(new Solution().schema());
        Db.execute(c, """
                INSERT INTO People (PersonID, PersonName, Phone) VALUES (1, 'Ana', '555-1'), (2, 'Bruno', '555-2');
                INSERT INTO Professionals (PersonID, Degree, Experience) VALUES (1, 'CS', 5);
                INSERT INTO Companies (CompanyID, CompanyName, Address) VALUES (10, 'Acme', 'Street 1'), (11, 'Globex', 'Street 2')
                """);
        return c;
    }

    @Test
    void professionalCanWorkForManyCompanies() throws Exception {
        try (Connection c = setUp()) {
            Db.execute(c, """
                    INSERT INTO WorksFor (PersonID, CompanyID, Salary, DateOfJoining) VALUES (1, 10, 5000, DATE '2020-01-01');
                    INSERT INTO WorksFor (PersonID, CompanyID, Salary, DateOfJoining) VALUES (1, 11, 3000, DATE '2022-06-01')
                    """);
            assertEquals(List.of(List.of("2")), Db.query(c, "SELECT COUNT(*) FROM WorksFor WHERE PersonID = 1"));
        }
    }

    @Test
    void professionalMustBeAPerson() throws Exception {
        try (Connection c = setUp()) {
            assertThrows(SQLException.class, () ->
                    Db.update(c, "INSERT INTO Professionals (PersonID, Degree, Experience) VALUES (99, 'X', 1)"));
        }
    }

    @Test
    void onlyProfessionalsWorkForCompanies() throws Exception {
        try (Connection c = setUp()) {
            assertThrows(SQLException.class, () ->
                    Db.update(c, "INSERT INTO WorksFor (PersonID, CompanyID, Salary, DateOfJoining) VALUES (2, 10, 1, DATE '2020-01-01')"));
            assertThrows(SQLException.class, () ->
                    Db.update(c, "INSERT INTO WorksFor (PersonID, CompanyID, Salary, DateOfJoining) VALUES (1, 99, 1, DATE '2020-01-01')"));
        }
    }

    @Test
    void samePairOnlyOnce() throws Exception {
        try (Connection c = setUp()) {
            Db.update(c, "INSERT INTO WorksFor (PersonID, CompanyID, Salary, DateOfJoining) VALUES (1, 10, 1, DATE '2020-01-01')");
            assertThrows(SQLException.class, () ->
                    Db.update(c, "INSERT INTO WorksFor (PersonID, CompanyID, Salary, DateOfJoining) VALUES (1, 10, 2, DATE '2021-01-01')"));
        }
    }
}
