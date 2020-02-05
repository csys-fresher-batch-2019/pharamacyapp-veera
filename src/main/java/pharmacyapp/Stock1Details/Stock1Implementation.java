package pharmacyapp.Stock1Details;

import java.sql.Connection;
import java.sql.Statement;

import pharmacyapp.CompanyDetails.TestConnection;

import java.sql.SQLException;


public class Stock1Implementation implements Stock1DAO{
	
	public void addStockDetails(Stock1 s)throws Exception
	{
		String sql="insert into stock1(stock1_id,product_id, stock1_name,stock1_number,stock1_type,stock1_status ) values ("+s.stock1Id+","+s.productId+",'"
				+ ""+s.stock1Name+"',"+s.stock1Number+",'"+s.stock1Type+"','"+s.stock1Status+"')";
		Connection c1 = TestConnection.getConnection();
		Statement stmt = c1.createStatement();
		int row = stmt.executeUpdate(sql);
					
		System.out.println(row);
	}
}
