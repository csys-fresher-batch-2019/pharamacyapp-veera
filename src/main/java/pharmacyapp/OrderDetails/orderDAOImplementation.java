package pharmacyapp.OrderDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

import pharmacyapp.CompanyDetails.TestConnection;



public class orderDAOImplementation implements orderDAO{

	public void addorderdetails(Order O) throws Exception {
		// TODO Auto-generated method stub
		
		String sql = "insert into orderdetail(order_id,user_name,product_name,product_id,quantity,Email_id,contact)  values(order_id.nextval,?,?,?,?,?,?)";
		Connection con = TestConnection.getConnection();

		
		System.out.println(con);
		
		
        //orderDAOImplementation o=new orderDAOImplementation();
		//o.addorderdetails(d);
		PreparedStatement stmp = con.prepareStatement(sql);
		//stmp.setInt(1, O.getOrderId());
		stmp.setString(1, O.getUserName());
		stmp.setString(2, O.getProductName());
		stmp.setInt(3, O.getProductId());
		stmp.setInt(4, O.getQuantity());
		stmp.setString(5, O.getEmailId());
		stmp.setLong(6, O.getContact());
//		stmp.setString(7, O.getOrderStatus());
		stmp.executeUpdate();
	
	}



}
