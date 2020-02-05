package pharmacyapp.PurchaseDetails;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import pharmacyapp.CompanyDetails.TestConnection;
import pharmacyapp.ProductDetails.Product;


public class PurchaseImplementation {
	public void addPurchaseDetails(Purchase p) throws Exception {
		String sql = "insert into purchase(purchase_id,product_id,purchase_date,company_id,purchase_quantity,amount) values("+p.purchaseId+","+p.productId+",sysdate,"+p.companyId+","+p.purchaseQuantity+","+p.amount+")";
		System.out.println(sql);	
		Connection con = TestConnection.getConnection();

		Statement stmt = con.createStatement();
		int row = stmt.executeUpdate(sql);
		System.out.println(row);
		
}
	public void amountCalculation(int productId,int purchaseId) throws Exception {
		String sql = "select purchase_quantity from purchase where purchase_id = "+purchaseId+"";
		ResultSet rs;
		Connection con = TestConnection.getConnection();
		Statement stmt = con.createStatement();
		rs = stmt.executeQuery(sql);
		rs.next();
		int quantity = rs.getInt(1);//coloumn number
		String sql1 = "select cost from product where product_id = "+productId+"";
		ResultSet rs1;
		Connection con1 = TestConnection.getConnection();
		Statement stmt1 = con1.createStatement();
		rs1 = stmt1.executeQuery(sql);
		rs1.next();
		int cost = rs1.getInt(1);
		int amount = cost*quantity;
		String sql2 = "update purchase set amount = "+amount+" where purchase_id = "+purchaseId+"";
		Connection con2 = TestConnection.getConnection();
		Statement stmt2 = con2.createStatement();
		int row = stmt.executeUpdate(sql2);
		System.out.println(sql2);
		System.out.println(row);
		
	}
}
