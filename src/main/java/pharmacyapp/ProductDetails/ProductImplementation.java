package pharmacyapp.ProductDetails;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import pharmacyapp.CompanyDetails.TestConnection;

import java.sql.SQLException;

public class ProductImplementation implements ProductDAO {

	public void addProductDetails(Product p) throws Exception {
		String sql = "insert into product(product_id,product_name,product_type,cost,quantity,expiry_date) " + "values("
				+ p.productId + ",'" + p.productName + "','" + p.productType + "','" + p.cost + "','"+p.quantity+"'," + p.expiryDate
				+ ")";
		Connection c1 = TestConnection.getConnection();
		Statement stmt = c1.createStatement();
		int row = stmt.executeUpdate(sql);
		System.out.println(row);
		 

	}

	public void updateProductType(String pT, int pId) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update product set product_type=? where product_id=?";
		Connection con = TestConnection.getConnection();
		PreparedStatement stmp = con.prepareStatement(sql);
		stmp.setString(1, pT);
		stmp.setInt(2, pId);
		System.out.println(sql);
		int row = stmp.executeUpdate();
		System.out.println(row);

	}

	public void updateCost(int cost, int proId) throws Exception {
		// TODO Auto-generated method stub
		String sql = "update product set cost=? where product_id=?";
		Connection con = TestConnection.getConnection();
		PreparedStatement stmp = con.prepareStatement(sql);
		stmp.setInt(1, cost);
		stmp.setInt(2, proId);
		System.out.println(sql);
		int pr = stmp.executeUpdate();
		System.out.println(pr);

	}

	public ArrayList<Product> displayProduct() throws Exception {
		// TODO Auto-generated method stub
		String sql = "select * from product";
		ResultSet rs;
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();

		ArrayList<Product> out = new ArrayList<Product>();
		while (rs.next()) {
			Product obj = new Product();
			obj.productId = rs.getInt("product_id");
			obj.productName = rs.getString("product_name");
			obj.productType = rs.getString("product_type");
			obj.cost = rs.getInt("cost");
			obj.quantity=rs.getInt("quantity");
			obj.expiryDate = rs.getDate("expiry_date");
			out.add(obj);
			
			
		}
		for (Product P1 : out) {
			System.out.print("ProductId: " + P1.productId + ", ProductName: " + P1.productName + ", ProductType: "
						+ P1.productType + ",Cost: " + P1.cost + ",ExpiryDate " + P1.expiryDate + "\n");

				}
		return out;
	}

	public ArrayList<Product> selectProductId(int numb) throws Exception {
		
		String sql = "select product_id, product_name,product_type,cost,quantity,expiry_date from product where product_id=?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Connection con =
		// DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "system",
		// "oracle");
		Connection con = TestConnection.getConnection();
		//System.out.println(con);
		Product obj = new Product();
		PreparedStatement stmp = con.prepareStatement(sql);
		stmp.setInt(1, numb);
		ResultSet rs = stmp.executeQuery();
		ArrayList<Product> out = new ArrayList<Product>();
		while (rs.next()) {

			obj.productId = rs.getInt("product_id");
			obj.productName = rs.getString("product_name");
			obj.productType = rs.getString("product_type");
			obj.cost = rs.getInt("cost");
			obj.quantity=rs.getInt("quantity");
			obj.expiryDate = rs.getDate("expiry_date");

			out.add(obj);	
		}	
		for (Product P1 : out) {
		System.out.print("ProductId: " + P1.productId + ", ProductName: " + P1.productName + ", ProductType: "
					+ P1.productType + ",Cost: " + P1.cost + ",ExpiryDate " + P1.expiryDate + "\n");

			}
		return out;
	}
}
