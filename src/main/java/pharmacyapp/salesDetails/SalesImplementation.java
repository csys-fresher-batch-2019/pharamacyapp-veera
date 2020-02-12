package pharmacyapp.salesDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;

import pharmacyapp.companyDetails.TestConnection;



public class SalesImplementation implements SalesDAO {
	public void addSalesDetails(Sales se)throws Exception
	{
		
		String sql="insert into sales(sales_id,product_id,sales_date,sales_quantity,amount) values (?,?,?,?,?)";
		Connection con = TestConnection.getConnection();

		//Statement stmt = con.createStatement();
		//int row = stmt.executeUpdate(sql);
		//System.out.println(row);
		PreparedStatement stmp=con.prepareStatement(sql);
		stmp.setInt(1,se.getSalesId());
		stmp.setInt(2,se.getProductId());	
		stmp.setDate(3,(Date) se.getSalesDate());
		stmp.setString(4,se.getSalesQuantity());
		stmp.setInt(5,se.getAmount());
		stmp.executeUpdate();
		System.out.println("Done");
		
	}

	public void amountCalAfterSales(int productId, int salesId) throws Exception {
		// TODO Auto-generated method stub
		String sql="Select cost from product where product_id="+productId+""; 
			ResultSet rs;
			Connection con = TestConnection.getConnection();
			Statement stmt = con.createStatement();
		    rs=stmt.executeQuery(sql);
		    rs.next();
		    
	    int p1=rs.getInt(1);
	    System.out.println(p1);
	    String sql1="select sales_quantity from sales where sales_id="+salesId+"";
	    System.out.println(sql1);
        //ResultSet rs1;
        int co =0;
        Connection con1 = TestConnection.getConnection();
		Statement stmt1 = con1.createStatement();
		ResultSet rs1 = stmt1.executeQuery(sql1);
		if(rs1.next()) {
		co = rs1.getInt(1);
		}
		System.out.println(co);
       int amount=p1*co;
       System.out.println(amount);
        String sql2="update sales set amount="+amount+" where sales_id= "+salesId+"";
        Connection con2 = TestConnection.getConnection();
		Statement stmt2 = con2.createStatement();
		int row = stmt2.executeUpdate(sql2);
	//System.out.println(sql2);
		//System.out.println(row);
	}

}
