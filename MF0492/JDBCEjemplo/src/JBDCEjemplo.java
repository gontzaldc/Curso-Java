import java.sql.*;

public class JBDCEjemplo {
	private static final String URL="jdbc:mysql://localhost:3306/uf1846m";
	private static final String USER="root";
	private static final String PASS="admin";
	
	private static final String SQL_SELECT="SELECT id, email, password FROM usuarios";
	
	public static void main(String[] args) throws SQLException {
		
		//conexión
		Connection con = DriverManager.getConnection(URL, USER, PASS);
		
		//Crear sentencia
		Statement st= con.createStatement();
		ResultSet rs= st.executeQuery(SQL_SELECT);
		
		while(rs.next()) {

			System.out.println(rs.getLong("id"));
		}
		
	}
}
