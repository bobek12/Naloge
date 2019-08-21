import java.sql.*;

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
            pstm.setString(1, "38641313395" );
            pstm.setInt(2, 1 );
            pstm.executeUpdate();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    public void selectAllPhoneNumbers(){
        String sqlSelectAll = "SELECT * FROM phone_numbers";

        try(Connection conn = this.connect();
            Statement stmt = conn.createStatement()){
            ResultSet result =  stmt.executeQuery(sqlSelectAll);

            while(result.next()){
                System.out.println(
                        result.getString("phone_number") +  "\t" +
                        result.getInt("type") + "\t" );
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }


    public void selectPhoneNumber(){
        String sqlSelect = "SELECT * FROM phone_numbers WHERE phone_number= ?";

        try(Connection conn = this.connect();
            PreparedStatement pstm = conn.prepareStatement(sqlSelect)){
            pstm.setString(1, "38631313395");

            ResultSet result = pstm.executeQuery();

            while(result.next()){
                System.out.println(
                        result.getString("phone_number") +  "\t" +
                                result.getInt("type") + "\t" );
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void deletePhoneNumber(){
        String sqlDelete = "DELETE FROM phone_numbers WHERE phone_number = ?";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {

            pstmt.setString(1, "38641313395");

            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void deleteAllPhoneNumbers(){
        String sqlDelete = "DELETE FROM phone_numbers";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sqlDelete)) {
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
