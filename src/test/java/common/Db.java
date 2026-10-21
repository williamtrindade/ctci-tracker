package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/** Utilitário de testes: banco H2 em memória (usado no capítulo 14). */
public final class Db {
    private static final AtomicInteger COUNTER = new AtomicInteger();

    private Db() {
    }

    /** Abre um banco novo e executa os comandos (separados por ';'). */
    public static Connection open(String script) throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:h2:mem:ctci" + COUNTER.incrementAndGet() + ";DB_CLOSE_DELAY=-1");
        execute(c, script);
        return c;
    }

    public static void execute(Connection c, String script) throws SQLException {
        try (Statement st = c.createStatement()) {
            for (String sql : script.split(";")) {
                if (!sql.isBlank()) {
                    st.execute(sql);
                }
            }
        }
    }

    /** Executa uma consulta e retorna as linhas como listas de String (null vira "NULL"). */
    public static List<List<String>> query(Connection c, String sql) throws SQLException {
        List<List<String>> rows = new ArrayList<>();
        try (Statement st = c.createStatement(); ResultSet rs = st.executeQuery(stripSemicolon(sql))) {
            ResultSetMetaData md = rs.getMetaData();
            while (rs.next()) {
                List<String> row = new ArrayList<>();
                for (int i = 1; i <= md.getColumnCount(); i++) {
                    Object v = rs.getObject(i);
                    row.add(v == null ? "NULL" : normalizeNumber(v));
                }
                rows.add(row);
            }
        }
        return rows;
    }

    public static int update(Connection c, String sql) throws SQLException {
        try (Statement st = c.createStatement()) {
            return st.executeUpdate(stripSemicolon(sql));
        }
    }

    private static String normalizeNumber(Object v) {
        if (v instanceof Number n && !(v instanceof Integer) && !(v instanceof Long)) {
            double d = n.doubleValue();
            if (d == Math.rint(d)) {
                return Long.toString((long) d);
            }
            return String.format(java.util.Locale.ROOT, "%.2f", d);
        }
        return v.toString();
    }

    private static String stripSemicolon(String sql) {
        String s = sql.trim();
        return s.endsWith(";") ? s.substring(0, s.length() - 1) : s;
    }

    /** Schema e dados de exemplo das questões 14.1 a 14.3 (como no livro). */
    public static final String APARTMENTS_SCHEMA = """
            CREATE TABLE Complexes (ComplexID INT PRIMARY KEY, ComplexName VARCHAR(100));
            CREATE TABLE Buildings (BuildingID INT PRIMARY KEY, ComplexID INT, BuildingName VARCHAR(100), Address VARCHAR(500));
            CREATE TABLE Apartments (AptID INT PRIMARY KEY, UnitNumber VARCHAR(10), BuildingID INT);
            CREATE TABLE Tenants (TenantID INT PRIMARY KEY, TenantName VARCHAR(100));
            CREATE TABLE AptTenants (TenantID INT, AptID INT);
            CREATE TABLE Requests (RequestID INT PRIMARY KEY, Status VARCHAR(100), AptID INT, Description VARCHAR(500));
            INSERT INTO Complexes VALUES (1, 'Sunset Complex');
            INSERT INTO Buildings VALUES (10, 1, 'Tower A', 'Street 1'), (11, 1, 'Tower B', 'Street 2'), (12, 1, 'Tower C', 'Street 3');
            INSERT INTO Apartments VALUES (100, '101', 10), (101, '102', 10), (102, '201', 11), (103, '202', 11), (104, '301', 12);
            INSERT INTO Tenants VALUES (1, 'Ana'), (2, 'Bruno'), (3, 'Carla'), (4, 'Diego');
            INSERT INTO AptTenants VALUES (1, 100), (1, 102), (2, 101), (3, 103), (3, 104), (3, 100), (4, 101);
            INSERT INTO Requests VALUES
              (1, 'Open', 100, 'Leak'), (2, 'Closed', 100, 'Paint'), (3, 'Open', 101, 'Door'),
              (4, 'Open', 102, 'Window'), (5, 'Open', 103, 'Heater'), (6, 'Closed', 103, 'Light');
            """;
}
