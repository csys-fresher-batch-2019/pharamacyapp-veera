package pharmacyapp.stock1Details;

import java.sql.Connection;
import java.sql.Statement;

import pharmacyapp.companyDetails.TestConnection;

import java.sql.SQLException;


public class Stock1Implementation implements Stock1DAO{
	
	public void addStockDetails(Stock1 s)throws Exception
	{
		String sql="insert into stock1(stock1_id,product_id, stock1_name,stock1_number,stock1_type,stock1_status ) values ("+s.getStock1Id()+","+s.getProductId()+",'"
				+ ""+s.getStock1Name()+"',"+s.getStock1Number()+",'"+s.getStock1Type()+"','"+s.getStock1Status()+"')";
		Connection c1 = TestConnection.getConnection();
		Statement stmt = c1.createStatement();
		int row = stmt.executeUpdate(sql);
					
		System.out.println(row);
	}
}
