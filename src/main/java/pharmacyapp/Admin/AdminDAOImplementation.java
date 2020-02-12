package pharmacyapp.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import pharmacyapp.companyDetails.TestConnection;

public class AdminDAOImplementation {
	public void admin() throws Exception {

		System.out.println("Enter Admin_Name:");
		Scanner sc = new Scanner(System.in);
		String Admin = sc.next();
		System.out.println("Enter Password:");
		String pass = sc.next();
		AdminDAOImplementation com = new AdminDAOImplementation();
		boolean res=com.AdminLogin(Admin, pass);
		if (res) 
		{
			System.out.println(">>>>LOGIN SUCESSFULL<<<<");
			// view order details
			System.out.println(" Enter 1 for insert Order Details: \n Enter 2 for insert CompanyDetails: \n Enter 3 for insert ProductDetails: \n Enter 4 for insert PurchaseDetails: \n Enter 5 for insert SalesDetails:  \n Enter 6 for  insert StockDetails:");

		

		} else {
			throw new Exception(">>>>LOGIN FAILED<<<<");
		    
		}

	}

	public boolean AdminLogin(String Adminname, String pass) throws Exception {
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		String sql="select pass_word from AdminRegister where Admin_name=(select Admin_name from AdminRegister where Admin_name='"+Adminname+"')";
		ResultSet rs1 = stmt.executeQuery(sql);
        if(rs1.next())
        {
        	String password=rs1.getString("pass_word");
        
        if (pass.equals(password))
        {
				return true;
			}
        }
		
		return false;
}

}
