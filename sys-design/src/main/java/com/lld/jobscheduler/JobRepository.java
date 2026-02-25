package com.lld.jobscheduler;

import java.sql.*;
import java.time.LocalDateTime;

public class JobRepository {

    private static final String INSERT_JOB_SQL =
            "INSERT INTO jobs (" +
                    "job_name, job_type, payload, schedule_type, cron_expression, " +
                    "fixed_delay_ms, next_run_at, status, retry_count, max_retries, " +
                    "locked_by, lock_expiry" +
                    ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public static long insertCronJob(Connection conn) throws SQLException {

        for (int i = 1; i <= 100; i++) {
            try (PreparedStatement ps =
                         conn.prepareStatement(INSERT_JOB_SQL, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, "daily-report-job-" + i);
                ps.setString(2, "REPORT");

                // JSON payload
                ps.setString(3, """
                        {
                          "reportType": "DAILY",
                          "email": "ops@test.com"
                        }
                        """);

                ps.setString(4, "CRON");                 // schedule_type
                ps.setString(5, "*/5 * * * *");          // cron_expression
                ps.setObject(6, null);                   // fixed_delay_ms

                // next_run_at = first execution time
                ps.setTimestamp(7,
                        Timestamp.valueOf(LocalDateTime.now().plusMinutes(5)));

                ps.setString(8, "SCHEDULED");
                ps.setInt(9, 0);
                ps.setInt(10, 5);

                ps.setString(11, null);                  // locked_by
                ps.setTimestamp(12, null);               // lock_expiry

                ps.executeUpdate();

                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        rs.getLong(1);
                    }
                }
            }
        }
        return 1;
    }

    public static long insertJob(Connection conn) throws SQLException {

        for(int i =1; i<= 100;i++) {
            try (PreparedStatement ps =
                         conn.prepareStatement(INSERT_JOB_SQL, Statement.RETURN_GENERATED_KEYS)) {

                ps.setString(1, "email-job-" + i);
                ps.setString(2, "EMAIL");

                // JSON column – pass as String
                ps.setString(3, "{\"to\":\"user@test.com\",\"template\":\"welcome\"}");

                ps.setString(4, "ONE_TIME");      // ENUM
                ps.setString(5, null);            // cron_expression
                ps.setObject(6, null);            // fixed_delay_ms

                ps.setTimestamp(7, Timestamp.valueOf(LocalDateTime.now().plusMinutes(5)));
                ps.setString(8, "SCHEDULED");     // status ENUM
                ps.setInt(9, 0);                  // retry_count
                ps.setInt(10, 3);                 // max_retries

                ps.setString(11, null);            // locked_by
                ps.setTimestamp(12, null);         // lock_expiry

                ps.executeUpdate();

                // Get auto-generated job_id
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                         rs.getLong(1);
                    }
                }
            }
        }
        return 1;
    }

    private static final String JDBC_URL =
            "jdbc:mysql://localhost:3306/scheduler" +
                    "?useSSL=false&serverTimezone=Asia/Kolkata&allowPublicKeyRetrieval=true";

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "SaiMaster@30";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(
                JDBC_URL, DB_USER, DB_PASSWORD)) {

            System.out.println("Connected to MySQL successfully.");

            JobRepository.insertCronJob(conn);

            // JobRepository.insertJob(conn);





        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

