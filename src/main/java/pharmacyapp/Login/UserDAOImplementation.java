package pharmacyapp.Login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import pharmacyapp.CompanyDetails.CompanyImplementation;
import pharmacyapp.CompanyDetails.TestConnection;
import pharmacyapp.ProductDetails.Product;
import pharmacyapp.ProductDetails.ProductImplementation;


public class UserDAOImplementation implements UserDAO {
	static 	Scanner sc = new Scanner(System.in);

	public void addUserDetails(UserDetails p) throws Exception {
		// TODO Auto-generated method stub
		String sql = "insert into UserRegister(name,Email_id,password,contact) values (?,?,?,?)";
		Connection con = TestConnection.getConnection();

		System.out.println(sql);
		System.out.println(con);
		PreparedStatement stmp = con.prepareStatement(sql);
		stmp.setString(1, p.getName());
		stmp.setString(2, p.getEmailId());
		stmp.setString(3, p.getPassword());
		
		stmp.setLong(4, p.getContact());
		stmp.executeUpdate();
		System.out.println("Done");
		int num=sc.nextInt();
	}

	public void user() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter UserName:");
		Scanner sc = new Scanner(System.in);
		String name = sc.next();
		System.out.println("Enter Password:");
		String pass = sc.next();
		UserDAOImplementation com = new UserDAOImplementation();
		if (com.user(name, pass)) {
			System.out.println(">>>>LOGIN SUCESSFULL<<<<");
			// view order details
			System.out.println("Enter 21 To view  Product List");
			Scanner sc1 = new Scanner(System.in);
			int str = sc1.nextInt();
			switch (str) {
			case 21:
				System.out.println(">>>>>>>>>Product List<<<<<<<<<");
				ProductImplementation us = new ProductImplementation();
				// Product d=new Product();

				ArrayList<Product> out = new ArrayList<Product>();
				out = us.displayProduct();
				for (Product P : out) {
					System.out.print("ProductId:" + P.productId + ", ProductName:" + P.productName + ", ProductType:"
							+ P.productType + ",Cost:" + P.cost + ",ExpiryDate" + P.expiryDate + "\n");

				}

				System.out.println(out);
				System.out.println("Enter 22 To place Order");
				Scanner scn = new Scanner(System.in);
				int str1 = scn.nextInt();
				switch (str1) {
				case 22:
					//// Again display productList to user
					ProductImplementation us1 = new ProductImplementation();

					ArrayList<Product> out1 = new ArrayList<Product>();
					out1 = us1.displayProduct();
					for (Product P1 : out1) {
						System.out.print(
								"ProductId: " + P1.productId + ", ProductName: " + P1.productName + ", ProductType: "
										+ P1.productType + ",Cost: " + P1.cost + ",ExpiryDate " + P1.expiryDate + "\n");

					}
				//	System.out.println(out1);

					System.out.println("Enter ProductId:  ");
					Scanner scn1 = new Scanner(System.in);

					int numb = scn1.nextInt();
					
					ProductImplementation us3 = new ProductImplementation();
					//Product d2= new Product();
			         
					ArrayList<Product> out2 = new ArrayList<Product>();
					
					out2=us3.selectProductId(numb);

					for (Product P3: out2) {
						System.out.print(
								"ProductId: " + P3.productId + ", ProductName: " + P3.productName + ", ProductType: "
										+ P3.productType + ",Cost: " + P3.cost + ",ExpiryDate " + P3.expiryDate + "\n");

					}
					//System.out.println(out2);
					System.out.println("Enter the product quantity needed");
                     int need=sc.nextInt();
                     switch(need)
                     {
                     case 1:
                    	 System.out.println("Done");
                    	 break;
                     }
//                     if(Quantity>need)/////////////////////////////Add Quantity details  to check
//                     {
//                    	System.out.println("Do you like to place order ? \n Enter YES to place order \n Enter  NO to cancel  order \n Enter  H to back to Homepage");
//			             String o=sc.next();
//			                 switch (o)
//			               	 {
//			                 case "YES":
//			           		 break;
//			                    	
//			               	 }
                     //}
			
				}

			}

		} else {
			System.out.println(">>>>LOGIN FAILED<<<<");
		}
	}

	public boolean user(String name, String pass) throws Exception {
		// TODO Auto-generated method stub

		Connection con = TestConnection.getConnection();

		Statement stmt = con.createStatement();
		if (stmt.executeUpdate("select name from UserRegister where name='" + name + "'") != 0) {
			ResultSet rs1 = stmt.executeQuery("select password from UserRegister where name='" + name + "'");
			rs1.next();
			if (pass.equals(rs1.getString("password"))) {
				return true;
			}
		}
		return false;

	}

}
