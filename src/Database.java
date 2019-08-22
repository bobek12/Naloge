import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import javax.sql.DataSource;
import java.sql.*;

public class Database {
    /* Hikari config */
    private static DataSource dataSource() {

        String url = "jdbc:sqlite:databaseNaloge.db";
        HikariConfig config = new HikariConfig();

        try {
            config.setPoolName("AuthMeSQLitePool");
            config.setDriverClassName("org.sqlite.JDBC");
            config.setJdbcUrl(url);
        }catch (Exception e){
                e.printStackTrace();
        }
        return new HikariDataSource(config);
    }
    /* Vstavi telefonsko številko v podatkovno bazo */
    public static void insertPhoneNumber(String phoneNumber, int type) {
        String sqlInsert = "INSERT INTO phone_numbers(phone_number, type) VALUES (?,?)";

        DataSource dataSource = Database.dataSource();

        try (Connection conn = dataSource.getConnection();
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
    /* Pridobi vsa števila iz podatkovne baze*/
    public static void selectAllPhoneNumbers() {
        String sqlSelectAll = "SELECT * FROM phone_numbers";
;
        DataSource dataSource = Database.dataSource();

        try (Connection conn = dataSource.getConnection();
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
    /* Pridobi številko iz podatkovne baze*/
    public static void selectPhoneNumber(String phoneNumber) {

        String sqlSelect = "SELECT * FROM phone_numbers WHERE phone_number= ?";

        DataSource dataSource = Database.dataSource();

        try (Connection conn = dataSource.getConnection();
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
    /* Izbris števila iz tabele */
    public static void deletePhoneNumber(String phoneNumber) {
        String sqlDelete = "DELETE FROM phone_numbers WHERE phone_number = ?";

        DataSource dataSource = Database.dataSource();

        try (Connection conn = dataSource.getConnection();
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
    /* Izbris vseh števil iz tabele */
    public static void deleteAllNumbers() {
        String sqlDelete = "DELETE FROM phone_numbers";

        DataSource dataSource = Database.dataSource();

        try (Connection conn = dataSource.getConnection();
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
