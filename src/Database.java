import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
    private Connection connect() {
        Connection conn = null;
        String url = "jdbc:sqlite:databaseNaloge.db";
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void insertPhoneNumber(){

        String sqlInsert = "INSERT INTO phone_numbers(phone_number, type) VALUES (?,?)";

        try(Connection conn = this.connect();
                PreparedStatement pstm = conn.prepareStatement(sqlInsert)){
            pstm.setString(1, "38631313395" );
            pstm.setInt(2, 1 );
            pstm.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void selectAllPhoneNumbers(){
        String sqlSelectAll = "SELECT * FROM phone_numbers";
    }

    public void selectPhoneNumber(){
    }

    public void deletePhoneNumber(){
    }

    public void deleteAllPhoneNumbers(){
    }

}
