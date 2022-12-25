package Helper;
import java.sql.*;
public class DBConnection {
//Connection c = null;


public DBConnection() {
	}
static final String DB="jdbc:mysql://localhost:3306/arabakiralama";
static final String USER="root";
static final String PASS="";
private static java.sql.Connection conn ;
//public static Connection con = null;

     public Connection connDb() {
    	 try {
			Connection con=DriverManager.getConnection(DB,USER,PASS);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	
	}
	public static void main(String[] args)  throws SQLException{
	Connection con=DriverManager.getConnection(DB,USER,PASS);
	
	Statement st=con.createStatement();

	
	 ResultSet rs = st.executeQuery("SELECT * FROM kullanicilar ");
System.out.println("Veri Tabanina Baglandi");


}
}