package pharmacyapp.companyDetails;
//Test class

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CompanyImplementation implements CompanyDAO {


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
