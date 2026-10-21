package CTCI145Denormalization;

import common.Db;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTest {

    private static final String SCHEMA = """
            CREATE TABLE Teachers (TeacherID INT PRIMARY KEY, TeacherName VARCHAR(100));
            CREATE TABLE Courses (CourseID INT PRIMARY KEY, CourseName VARCHAR(100), TeacherID INT);
            INSERT INTO Teachers VALUES (1, 'Knuth'), (2, 'Dijkstra');
            INSERT INTO Courses VALUES (10, 'Algorithms', 1), (11, 'Compilers', 1), (12, 'Graphs', 2);
            """;

    private final Solution solution = new Solution();

    @Test
    void bothModelsReturnTheSameData() throws Exception {
        try (Connection c = Db.open(SCHEMA)) {
            Db.execute(c, solution.createDenormalizedTable());
            Db.update(c, solution.populateDenormalizedTable());
            Set<List<String>> normalized = new HashSet<>(Db.query(c, solution.coursesWithTeacherNormalized()));
            Set<List<String>> denormalized = new HashSet<>(Db.query(c, solution.coursesWithTeacherDenormalized()));
            assertEquals(Set.of(List.of("Algorithms", "Knuth"), List.of("Compilers", "Knuth"), List.of("Graphs", "Dijkstra")),
                    normalized);
            assertEquals(normalized, denormalized);
            assertFalse(solution.coursesWithTeacherDenormalized().toUpperCase().contains("JOIN"),
                    "A consulta desnormalizada não deve precisar de JOIN");
        }
    }

    @Test
    void denormalizedDataCanBecomeInconsistent() throws Exception {
        try (Connection c = Db.open(SCHEMA)) {
            Db.execute(c, solution.createDenormalizedTable());
            Db.update(c, solution.populateDenormalizedTable());
            Db.update(c, "UPDATE Teachers SET TeacherName = 'Donald Knuth' WHERE TeacherID = 1");
            Set<List<String>> normalized = new HashSet<>(Db.query(c, solution.coursesWithTeacherNormalized()));
            Set<List<String>> denormalized = new HashSet<>(Db.query(c, solution.coursesWithTeacherDenormalized()));
            assertEquals(true, normalized.contains(List.of("Algorithms", "Donald Knuth")));
            assertEquals(true, denormalized.contains(List.of("Algorithms", "Knuth")), "Cópia redundante ficou desatualizada");
        }
    }
}
