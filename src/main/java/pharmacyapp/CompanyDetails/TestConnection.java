package pharmacyapp.CompanyDetails;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {

	public static Connection getConnection() throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@192.168.56.206:1521:XE","system","oracle");
		return con;
	}
}

