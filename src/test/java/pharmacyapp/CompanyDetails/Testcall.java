package pharmacyapp.CompanyDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import pharmacyapp.admin.AdminDAOImplementation;
import pharmacyapp.companyDetails.CompanyImplementation;
import pharmacyapp.companyDetails.CompanyModel;
import pharmacyapp.login.UserDAOImplementation;
import pharmacyapp.login.UserDetails;
import pharmacyapp.orderDetails.Order;
import pharmacyapp.orderDetails.orderDAOImplementation;
import pharmacyapp.productDetails.Product;
import pharmacyapp.productDetails.ProductImplementation;
import pharmacyapp.purchaseDetails.Purchase;
import pharmacyapp.purchaseDetails.PurchaseImplementation;
import pharmacyapp.salesDetails.Sales;
import pharmacyapp.salesDetails.SalesImplementation;
import pharmacyapp.stock1Details.Stock1;
import pharmacyapp.stock1Details.Stock1Implementation;


public class Testcall {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);

		System.out.println(" Enter 1 for AdminLogin \n Enter 2 for UserLogin");
		int num = sc.nextInt();
		if (num == 1) {
			AdminDAOImplementation obj = new AdminDAOImplementation();
			obj.admin();
			int nu = sc.nextInt();
			switch (nu) {
			case 1:

				orderDAOImplementation obj2 = new orderDAOImplementation();
				Order d = new Order();
				Scanner sc1 = new Scanner(System.in);
				System.out.println(
						">>>Order Details<<<   \n Enter 1 insert  order Details \n Enter 2 view order Details");
				int n = sc.nextInt();
				if (n == 1) {
					// System.out.println("Enter the orderId:");
					// d.setOrderId(sc1.nextInt());
					System.out.println("Enter the UserName:");
					d.setUserName(sc1.next());
					System.out.println("Enter the ProductName:");
					d.setProductName(sc1.next());
					System.out.println("Enter the productId:");
					d.setProductId(sc1.nextInt());
					System.out.println("Enter the Quantity:");
					d.setQuantity(sc1.nextInt());
					System.out.println("Enter the  EmailId:");
					d.setEmailId(sc1.next());
					System.out.println("Enter the Contact:");
					d.setContact(sc1.nextLong());
					// System.out.println("Enter the OrderStatus:");
					// d.setOrderStatus(sc1.next());
					obj2.addorderdetails(d);
					// System.out.println("Register Successfully");
					// int num41=sc.nextInt();
					break;
				} else if (n == 2) {
					orderDAOImplementation o = new orderDAOImplementation();
					o.displayOrderDetails();
					break;
				}

			case 2:

				System.out.println(">>> Company Details <<<  ");

				CompanyImplementation obj3 = new CompanyImplementation();
				CompanyModel p = new CompanyModel();
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Enter the CompanyId:");
				p.setCompanyId(sc2.nextInt());
				System.out.println("Enter the CompanyName:");
				p.setCompanyName(sc2.next());
				System.out.println("Enter the CompanyType:");
				p.setCompanyType(sc2.next());
				System.out.println("Enter the CompanyAddress:");
				p.setCompanyAddress(sc2.next());
				obj3.addCompanyDetails(p);

			case 3:
				System.out.println(
						">>> Product Details <<< \n Enter 1 for Add ProductDetails: \n Enter 2 for DisplayProduct: \n Enter 3 to UpdateProductType: \n Enter 4 to UpdateCost: \n Enter 5 to Select ProductId:");

				int num5 = sc.nextInt();
				switch (num5) {
				case 1:
					System.out.println("Insert ProductDetails");
					ProductImplementation a = new ProductImplementation();
					Product p1 = new Product();
					Scanner sc4 = new Scanner(System.in);
					System.out.println("Enter product id:");
					p1.setProductId(sc4.nextInt());
					System.out.println("Enter product Name:");
					p1.setProductName(sc4.next());
					System.out.println("Enter product Type");
					p1.setProductType(sc4.next());
					System.out.println("Enter cost:");
					p1.setCost(sc4.nextInt());
					System.out.println("Enter quantity:");
					p1.setQuantity(sc4.nextInt());
					System.out.println("Enter the ExpiryDate:");
					String date = sc4.next();
					LocalDate expiryDate = LocalDate.parse(date);
					a.addProductDetails(p1);

				case 2:
					System.out.println(">>>>>>>>>ProductDetails<<<<<<<<<");
					ProductImplementation pi = new ProductImplementation();
					pi.displayProduct();

				case 3:
					System.out.println("\n>>>>UpdateProductType<<<<\n");
					ProductImplementation P1 = new ProductImplementation();
					Scanner sck = new Scanner(System.in);
					System.out.println("Enter product type");
					String pt = sck.next();
					System.out.println("Enter product id");
					int c = sck.nextInt();
					P1.updateProductType(pt, c);

				case 4:
					System.out.println(">>>>>>>>>>UpdateProductCost<<<<<<<<<<");
					ProductImplementation pi1 = new ProductImplementation();
					System.out.println("Enter ProductId");
					int ProductId = sc.nextInt();
					System.out.println("Enter the Cost:");
					int cost = sc.nextInt();
					pi1.updateCost(cost, ProductId);

				case 5:
					System.out.println("Select ProductID");
					ProductImplementation pi2 = new ProductImplementation();
					System.out.println("Enter the ProductId");
					int productid = sc.nextInt();
					pi2.selectProductId(productid);

				}
				break;

			case 4:
				System.out.println(
						">>> Purchase Details <<< \n Enter 1 for insert Purchase Details \n Enter 2 for AmountCalculation  ");
				int num6 = sc.nextInt();

				switch (num6) {

				case 1:

					PurchaseImplementation p5 = new PurchaseImplementation();
					Scanner sc5 = new Scanner(System.in);
					Purchase p2 = new Purchase();

					System.out.println("Enter the ProductId:");
					p2.setProductId(sc5.nextInt());
					System.out.println("Enter the CompanyId:");
					p2.setCompanyId(sc5.nextInt());
					System.out.println("Enter the PurchaseQuantity:");
					p2.setPurchaseQuantity(sc5.nextInt());
					System.out.println("Enter the Amount:");
					p2.setAmount(sc5.nextInt());
					p5.addPurchaseDetails(p2);

				case 2:
					PurchaseImplementation obj1 = new PurchaseImplementation();
					System.out.println(">>>>>AmountCalculation<<<<<");
					Scanner sct = new Scanner(System.in);
					System.out.println("Enter purchase Id:");
					int purchaseId = sct.nextInt();
					System.out.println("Enter product Id:");
					int productId = sct.nextInt();
					obj1.amountCalculation(productId, purchaseId);
				}
				break;
			case 5:
				System.out.println(
						">>> Sales Details <<< \n Enter 1 for Add SalesDetails \n Enter 2 for Update Amount sales");
				int num7 = sc.nextInt();
				switch (num7) {
				case 1:
					SalesImplementation in = new SalesImplementation();
					// Sell s1=new Sell();
					Scanner scan = new Scanner(System.in);
					Sales s = new Sales();
					System.out.println("Enter the SalesId:");
					s.setSalesId(scan.nextInt());
					System.out.println("Enter the productId:");
					s.setProductId(scan.nextInt());
					System.out.println("Enter the SalesDate:");
					DateTimeFormatter SalesDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					LocalDateTime now = LocalDateTime.now();
					System.out.println(SalesDate.format(now));
					System.out.println("Enter the SalesQuantity:");
					s.setSalesQuantity(scan.next());
					System.out.println("Enter the amount:");
					s.setAmount(scan.nextInt());
					in.addSalesDetails(s);
				case 2:
					SalesImplementation obje = new SalesImplementation();
					Scanner sce = new Scanner(System.in);
					System.out.println("Enter the productId:");
					int productId = sce.nextInt();
					System.out.println("Enter the salesId:");
					int salesId = sce.nextInt();
					obje.amountCalAfterSales(productId, salesId);

				}
			case 6:
				System.out
						.println(">>> Stock Details <<< \n Enter 1 to insert StockDetails \n Enter 2 UpdateClosingstock \n Enter 3 UpdateOpeningstock ");
				int m = sc.nextInt();
				switch (m) {
				case 1:
					Stock1Implementation s=new Stock1Implementation();
					Stock1 s1=new Stock1();
//					System.out.println("Enter StockId:");
//					int stockId=sc.nextInt();
//					System.out.println("Enter StockDate:");
//                    int stockDate=sc.nextInt();
					System.out.println("Enter productId:");
					s1.setProductId(sc.nextInt());

                    System.out.println("Enter openingStock:");
                    s1.setOpeningStock(sc.nextInt());

					System.out.println("Enter purchaseQuantity:");
                    s1.setPurchaseQuantity(sc.nextInt());

					System.out.println("Enter salesQuantity:");
                    s1.setSalesQuantity(sc.nextInt());
                     s.addStockDetails(s1);
//					System.out.println("Enter closingStock:");
//                    int closingStock=sc.nextInt();
					break;
				case 2:
					System.out.println(">>>>>>>>Updation of ClosingStock<<<<<<<");
					Stock1Implementation S = new Stock1Implementation();
					Stock1 got=new Stock1();
					System.out.println("Enter the stockId");
					int stockId=sc.nextInt();
					//System.out.println(stockId);
					got.setStockId(stockId);
					
					//S.setStockId(stockId);
					S.updateClosingStock(got);
					break;
				case 3:
					System.out.println(">>>>>>>>Updation of OpeningStock<<<<<<<");
					Stock1Implementation SI = new Stock1Implementation();
					System.out.println("Enter the productId");
					int SId=sc.nextInt();
					SI.updateOpeningStock(SId);
					
					break;

				}
			}
		} 
		else if (num == 2) {
			System.out.println(">>>>User Portal<<<<<");
			System.out.println("Enter 1 for New User: \n Enter 2 for Existing User:");
			// Scanner sc2=new Scanner(System.in);
			int num2 = sc.nextInt();
			switch (num2) {
			case 1:
				UserDAOImplementation obj1 = new UserDAOImplementation();
				UserDetails u = new UserDetails();
				Scanner sc3 = new Scanner(System.in);
				System.out.println("Enter the UserName:");
				u.setName(sc3.next());
				System.out.println("Enter the EmailId:");
				u.setEmailId(sc3.next());
				System.out.println("Enter the Password:");
				u.setPassword(sc3.next());
				System.out.println("Enter the Contact:");
				u.setContact(sc3.nextLong());
				obj1.addUserDetails(u);
				break;

			case 2:
				UserDAOImplementation u1 = new UserDAOImplementation();
				// UserDetails s=new UserDetails();
				
					// TODO Auto-generated method stub
					System.out.println("Enter UserName:");
				//	Scanner sc = new Scanner(System.in);
					String name = sc.next();
					System.out.println("Enter Password:");
					String pass = sc.next();
					UserDAOImplementation com = new UserDAOImplementation();
					boolean res=com.user(name, pass);
					
					if (res) {
						System.out.println(">>>>LOGIN SUCESSFULL<<<<");
						// view order details
						System.out.println("Enter 1 To view  Product List");
						Scanner sc1 = new Scanner(System.in);
						int str = sc1.nextInt();
						switch (str) {
						case 1:
							System.out.println(">>>>>>>>>Product List<<<<<<<<<");
							ProductImplementation us = new ProductImplementation();
							// Product d=new Product();

							ArrayList<Product> out = new ArrayList<Product>();
							out = us.displayProduct();
							for (Product P : out) {
								System.out.print("ProductId:" + P.getProductId() + ", ProductName:" + P.getProductName() + ", ProductType:"
										+ P.getProductType() + ",Cost:" + P.getCost() + ",Quantity:"+P.getQuantity()+",ExpiryDate:" + P.getExpiryDate() + "\n");

							}

							//System.out.println(out);
							System.out.println("Enter 2 To place Order");
							Scanner scn = new Scanner(System.in);
							int str1 = scn.nextInt();
							switch (str1) {
							case 2:
								//// Again display productList to user
								ProductImplementation us1 = new ProductImplementation();

								ArrayList<Product> out1 = new ArrayList<Product>();
								out1 = us1.displayProduct();
								for (Product P1 : out1) {
									System.out.print(
											"ProductId: " + P1.getProductId() + ", ProductName: " + P1.getProductName() + ", ProductType: "
													+ P1.getProductType() + ",Cost: " + P1.getCost() +",Quantity:"+P1.getQuantity()+ ",ExpiryDate " + P1.getExpiryDate() + "\n");

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
											"ProductId: " + P3.getProductId() + ", ProductName: " + P3.getProductName() + ", ProductType: "
													+ P3.getProductType() + ",Cost: " + P3.getCost() +",Quantity:"+P3.getQuantity()+ ",ExpiryDate " + P3.getExpiryDate() + "\n");

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
//			                     if(Quantity>need)/////////////////////////////Add Quantity details  to check
//			                     {
//			                    	System.out.println("Do you like to place order ? \n Enter YES to place order \n Enter  NO to cancel  order \n Enter  H to back to Homepage");
//						             String o=sc.next();
//						                 switch (o)
//						               	 {
//						                 case "YES":
//						           		 break;
//						                    	
//						               	 }
			                     //}
						
							}

						}

					} 
					else {
						System.out.println(">>>>LOGIN FAILED<<<<");
						
					}
				}
				//u1.user();
			}
		

		else {
			System.out.println("Login Failed");
		}

	}
}
