package pharmacyapp.CompanyDetails;
//Test class

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CompanyImplementation implements CompanyDAO {

	public void admin() throws Exception {

		System.out.println("Enter Admin_Name:");
		Scanner sc = new Scanner(System.in);
		String Admin = sc.next();
		System.out.println("Enter Password:");
		String pass = sc.next();
		CompanyImplementation com = new CompanyImplementation();
		if (com.AdminLogin(Admin, pass)) {
			System.out.println(">>>>LOGIN SUCESSFULL<<<<");
			// view order details
		

		} else {
			System.out.println(">>>>LOGIN FAILED<<<<");
		    
		}

	}

	public boolean AdminLogin(String Adminname, String pass) throws Exception {
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		if (stmt.executeUpdate("select Admin_name from AdminRegister where Admin_name='" + Adminname + "'") != 0) {
			ResultSet rs = stmt
					.executeQuery("select pass_word from AdminRegister where Admin_name ='" + Adminname + "'");
			rs.next();
			if (pass.equals(rs.getString("pass_word"))) {
				return true;
			}

			return false;
		}
		return false;
	}

	public void addCompanyDetails(CompanyModel p) throws Exception {
		// TODO Auto-generated method stub
		String sql = "Insert into company( company_id, company_name, company_type,company_address) values (?,?,?,?)";
		Connection con = TestConnection.getConnection();
		System.out.println(sql);
		System.out.println(con);
		PreparedStatement stmp = con.prepareStatement(sql);
		stmp.setInt(1, p.getCompanyId());
		stmp.setString(2, p.getCompanyName());
		stmp.setString(3, p.getCompanyType());
		stmp.setString(4, p.getCompanyAddress());
		stmp.executeUpdate();
		
	}


	
}
