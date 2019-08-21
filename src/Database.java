import java.sql.*;

public class Database {
    private static Connection connect() {
        Connection conn = null;
        String url = "jdbc:sqlite:databaseNaloge.db";
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public static void insertPhoneNumber(String phoneNumber, int type) {

        String sqlInsert = "INSERT INTO phone_numbers(phone_number, type) VALUES (?,?)";

        try (Connection conn = connect();
             PreparedStatement pstm = conn.prepareStatement(sqlInsert)) {
            pstm.setString(1, phoneNumber);
            pstm.setInt(2, type);

            int i = pstm.executeUpdate();

            if (i > 0)
                System.out.println("Uspešen vnos številke");
            else
                System.out.println("Neuspešen vnos");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void selectAllPhoneNumbers() {
        String sqlSelectAll = "SELECT * FROM phone_numbers";

        try (Connection conn = connect();
             Statement stmt = conn.createStatement()) {
            ResultSet result = stmt.executeQuery(sqlSelectAll);

            if (!result.isBeforeFirst()) {
                System.out.println("Ni nobenih telefonskih številk");
            } else {
                while (result.next()) {
                    System.out.println(
                            result.getString("phone_number") + "\t" +
                                    result.getInt("type") + "\t");
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void selectPhoneNumber(String phoneNumber) {
        String sqlSelect = "SELECT * FROM phone_numbers WHERE phone_number= ?";

        try (Connection conn = connect();
             PreparedStatement pstm = conn.prepareStatement(sqlSelect)) {
            pstm.setString(1, phoneNumber);

            ResultSet result = pstm.executeQuery();

            if (!result.isBeforeFirst()) {
                System.out.println("Ni telefonske številkes");
            } else {
                while (result.next()) {
                    System.out.println(
                            result.getString("phone_number") + "\t" +
                                    result.getInt("type") + "\t");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deletePhoneNumber(String phoneNumber) {
        String sqlDelete = "DELETE FROM phone_numbers WHERE phone_number = ?";

        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {

            pstmt.setString(1, phoneNumber);
            int i = pstmt.executeUpdate();

            if (i > 0)
                System.out.println("Uspešno ste odstranili telefonsko številko: " + phoneNumber);
            else
                System.out.println("Številka ne obstaja");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteAllNumbers() {
        String sqlDelete = "DELETE FROM phone_numbers";


        try (Connection conn = connect();
             PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
            int i = pstmt.executeUpdate();

            if (i > 0)
                System.out.println("Uspešno ste odstranili vse telefonske številke");
            else
                System.out.println("Podatkovna baza je že prazna!");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
