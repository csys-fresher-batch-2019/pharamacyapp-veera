package pharmacyapp.OrderDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import pharmacyapp.CompanyDetails.TestConnection;
import pharmacyapp.ProductDetails.Product;



public class orderDAOImplementation implements orderDAO{

	public void addorderdetails(Order O) throws Exception 
	{
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
	public ArrayList<Order> displayOrderDetails() throws Exception {
		String sql = "select * from orderdetail";
		ResultSet rs;
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();

		ArrayList<Order> out = new ArrayList<Order>();
		while (rs.next()) {
			Order obj = new Order();
			obj.orderId = rs.getInt("order_id");
			obj.userName = rs.getString("user_name");
			obj.productName = rs.getString("product_name");
			obj.quantity = rs.getInt("quantity");
			obj.emailId=rs.getString("Email_id");
			obj.contact= rs.getLong("contact");
			out.add(obj);
		}
		for (Order O: out)
		{
			System.out.println("OrderId: " + O.orderId + ",UserName: " + O.userName+ ",ProductName: "+ O.productName + ",Quantity: "+ O.quantity + ",EmailId:"+ O.emailId+ ",Contact:"+ O.contact + "\n");
		}
		return out;
	}



}
