package io.github.makmotrobin.practice.sql;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Executes the SQL artefacts in {@code sql/} against an in-memory H2 database
 * so the scripts cannot rot: if a column name changes, these assertions fail.
 */
class SqlScriptTest {

    private static final Path SQL_DIR = Path.of("sql");

    private static Connection connection;

    @BeforeAll
    static void loadSchemaAndSeed() throws SQLException, IOException {
        connection = DriverManager.getConnection("jdbc:h2:mem:practice;MODE=MySQL;DB_CLOSE_DELAY=-1");
        executeScript(SQL_DIR.resolve("schema.sql"));
        executeScript(SQL_DIR.resolve("seed.sql"));
    }

    @AfterAll
    static void closeConnection() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Test
    @DisplayName("schema.sql and seed.sql produce the documented row counts")
    void seedDataLoads() throws SQLException {
        assertEquals(5, count("SELECT * FROM ingredients"));
        assertEquals(6, count("SELECT * FROM meals"));
    }

    @Test
    @DisplayName("queries.sql contains the ten exercises and runs unchanged")
    void everyQueryRuns() throws SQLException, IOException {
        List<String> statements = splitStatements(Files.readString(SQL_DIR.resolve("queries.sql")));
        assertEquals(10, statements.size(), "queries.sql should hold ten statements");

        for (String statement : statements) {
            try (Statement s = connection.createStatement(); ResultSet rs = s.executeQuery(statement)) {
                assertTrue(rs.getMetaData().getColumnCount() > 0, "query returned columns: " + statement);
            }
        }
    }

    @Test
    @DisplayName("the WHERE clauses select the expected rows")
    void filtersSelectExpectedRows() throws SQLException, IOException {
        List<String> statements = splitStatements(Files.readString(SQL_DIR.resolve("queries.sql")));

        int[] expected = {3, 4, 4, 2, 3, 4, 5, 1, 4, 1};

        for (int i = 0; i < statements.size(); i++) {
            assertEquals(expected[i], count(statements.get(i)),
                    "unexpected row count for query #" + (i + 1) + ": " + statements.get(i));
        }
    }

    private static void executeScript(Path script) throws SQLException, IOException {
        try (Statement statement = connection.createStatement()) {
            for (String sql : splitStatements(Files.readString(script, StandardCharsets.UTF_8))) {
                statement.execute(sql);
            }
        }
    }

    private static int count(String sql) throws SQLException {
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(sql)) {
            int rows = 0;
            while (rs.next()) {
                rows++;
            }
            return rows;
        }
    }

    /** Strips {@code --} comments and splits the script on semicolons. */
    static List<String> splitStatements(String script) {
        String withoutComments = script.replaceAll("(?m)--.*$", "");
        List<String> statements = new ArrayList<>();
        for (String candidate : withoutComments.split(";")) {
            String trimmed = candidate.trim();
            if (!trimmed.isEmpty()) {
                statements.add(trimmed);
            }
        }
        return statements;
    }
}
