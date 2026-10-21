package CTCI147DesignGradeDatabase;

import common.Db;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    /** 20 alunos, 2 matérias cada; GPA do aluno i = 50 + 2 * i (exceto ajustes para empate). */
    private static String schema(boolean tieAtCutoff) {
        StringBuilder sb = new StringBuilder("""
                CREATE TABLE Students (StudentID INT PRIMARY KEY, StudentName VARCHAR(100));
                CREATE TABLE Courses (CourseID INT PRIMARY KEY, CourseName VARCHAR(100), ProfessorID INT);
                CREATE TABLE CourseEnrollment (CourseID INT, StudentID INT, Grade DOUBLE, Term INT);
                INSERT INTO Courses VALUES (1, 'Math', 1), (2, 'Physics', 2);
                """);
        for (int i = 1; i <= 20; i++) {
            double gpa = 50 + 2 * i;
            if (tieAtCutoff && i == 18) {
                gpa = 50 + 2 * 19; // empata com o 2º melhor (aluno 19)
            }
            sb.append("INSERT INTO Students VALUES (").append(i).append(", 'S").append(i).append("');\n");
            sb.append("INSERT INTO CourseEnrollment VALUES (1, ").append(i).append(", ").append(gpa - 1).append(", 2026);\n");
            sb.append("INSERT INTO CourseEnrollment VALUES (2, ").append(i).append(", ").append(gpa + 1).append(", 2026);\n");
        }
        return sb.toString();
    }

    @Test
    void topTenPercentSortedByGpa() throws Exception {
        try (Connection c = Db.open(schema(false))) {
            assertEquals(List.of(List.of("S20", "90"), List.of("S19", "88")),
                    Db.query(c, new Solution().honorRollQuery()));
        }
    }

    @Test
    void tiesAtTheCutoffAreIncluded() throws Exception {
        try (Connection c = Db.open(schema(true))) {
            List<List<String>> rows = Db.query(c, new Solution().honorRollQuery());
            assertEquals(3, rows.size());
            assertEquals(List.of("S20", "90"), rows.get(0));
            assertEquals("88", rows.get(1).get(1));
            assertEquals("88", rows.get(2).get(1));
        }
    }
}
