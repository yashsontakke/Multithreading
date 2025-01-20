package locking.airlinebooking;

import java.sql.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AirlineBooking {
    // Database URL and credentials
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "myuser";
    private static final String PASSWORD = "mypassword";

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(120); // Create a thread pool
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 120; i++) {
            final int bookingId = i; // To distinguish transactions
            service.execute(() -> {
                try {
                    bookSeat(bookingId);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
        }


        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Query executed in: " + duration + " ms");

        service.shutdown(); // Shutdown the executor service
    }

    private static void bookSeat(int bookingId) throws SQLException {
        // Connection and transaction management
        Connection connection = null;
        PreparedStatement selectStatement = null;
        PreparedStatement updateStatement = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "myuser", "mypassword");
            connection.setAutoCommit(false); // Start a transaction

            // Step 1: Select and lock the row
            String selectSql = "SELECT id FROM Seat WHERE user_id IS NULL LIMIT 1 FOR UPDATE  ";
            selectStatement = connection.prepareStatement(selectSql);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                long seatId = resultSet.getLong("id");

                // Step 2: Update the user_id for the locked seat
                String updateSql = "UPDATE Seat SET user_id = ? WHERE id = ?";
                updateStatement = connection.prepareStatement(updateSql);
                updateStatement.setLong(1,bookingId);
                updateStatement.setLong(2, seatId);
                updateStatement.executeUpdate();

                System.out.println("Seat Booked for user " + bookingId + "seat Number " + seatId );
                connection.commit(); // Commit the transaction
            } else {
                System.out.println("No available seats found.");
                connection.rollback(); // Rollback if no available seats
            }

        } catch (SQLException e) {
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback(); // Rollback on error
                } catch (SQLException rollbackEx) {
                    rollbackEx.printStackTrace();
                }
            }
        } finally {
            try {
                if (selectStatement != null) selectStatement.close();
                if (updateStatement != null) updateStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException closeEx) {
                closeEx.printStackTrace();
            }
        }

    }
}
