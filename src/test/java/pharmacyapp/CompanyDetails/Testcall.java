package pharmacyapp.CompanyDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import pharmacyapp.Admin.AdminDAOImplementation;
import pharmacyapp.Login.UserDAOImplementation;
import pharmacyapp.Login.UserDetails;
import pharmacyapp.OrderDetails.Order;
import pharmacyapp.OrderDetails.orderDAOImplementation;
import pharmacyapp.ProductDetails.Product;
import pharmacyapp.ProductDetails.ProductImplementation;
import pharmacyapp.PurchaseDetails.Purchase;
import pharmacyapp.PurchaseDetails.PurchaseImplementation;
import pharmacyapp.SalesDetails.Sales;
import pharmacyapp.SalesDetails.SalesImplementation;
import pharmacyapp.Stock1Details.Stock1;
import pharmacyapp.Stock1Details.Stock1Implementation;

public class Testcall {
public static void main(String[] args) throws Exception {
	Scanner sc=new Scanner(System.in);
	
	System.out.println(" Enter 1 for AdminLogin \n Enter 2 for UserLogin");
	int num=sc.nextInt();
	if(num==1)
	{
		AdminDAOImplementation obj=new AdminDAOImplementation();
		obj.admin();
		int nu=sc.nextInt();
		switch(nu)
		{
		case 1:
			
			orderDAOImplementation obj2=new orderDAOImplementation();
			Order d=new Order();
			Scanner sc1=new Scanner(System.in);
			System.out.println(">>>Order Details<<<   \n Enter 1 insert  order Details \n Enter 2 view order Details");
	        int n=sc.nextInt();
	        if(n==1)
	        {
			//System.out.println("Enter the orderId:");
	       //d.setOrderId(sc1.nextInt());
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
//	        System.out.println("Enter the OrderStatus:");
//          d.setOrderStatus(sc1.next());
			obj2.addorderdetails(d);
		//	System.out.println("Register Successfully");
			//int num41=sc.nextInt();
			break;
	        }
	        else if(n==2)
	        {
	        	orderDAOImplementation o=new orderDAOImplementation();
	        	o.displayOrderDetails();
	        	break;
	        }
			
		case 2:
			
			System.out.println(">>> Company Details <<<  ");
		
				CompanyImplementation obj3=new CompanyImplementation();
				CompanyModel p = new CompanyModel();
				Scanner sc2=new Scanner(System.in);
				System.out.println("Enter the CompanyId:");
				p.setCompanyId(sc2.nextInt());
				System.out.println("Enter the CompanyName:");
				p.setCompanyName(sc2.next());
				System.out.println("Enter the CompanyType:");
				p.setCompanyType(sc2.next());
				System.out.println("Enter the CompanyAddress:");
				p.setCompanyAddress(sc2.next());
		        obj3.addCompanyDetails(p);
			    
			
		
		
			
		    
		
		case 3 :
			System.out.println(">>> Product Details <<< \n Enter 1 for Add ProductDetails: \n Enter 2 for DisplayProduct: \n Enter 3 to UpdateProductType: \n Enter 4 to UpdateCost: \n Enter 5 to Select ProductId:");
		  
			int num5=sc.nextInt();
			switch (num5)
			{
				case 1:
					System.out.println("Insert ProductDetails");
			ProductImplementation a = new ProductImplementation();
			Product p1 = new Product();
			Scanner sc4 = new Scanner(System.in);
			System.out.println("Enter product id:");
			p1.productId = sc4.nextInt();
			System.out.println("Enter product Name:");
			p1.productName = sc4.next();
			System.out.println("Enter product Type");
			p1.productType = sc4.next();
			System.out.println("Enter cost:");
			p1.cost = sc4.nextInt();
			System.out.println("Enter quantity:");
			p1.quantity = sc4.nextInt();
			System.out.println("Enter the ExpiryDate:");
			String date=sc4.next();
			LocalDate expiryDate=LocalDate.parse(date);
			a.addProductDetails(p1);
			
			
				
			case 2:
					System.out.println(">>>>>>>>>ProductDetails<<<<<<<<<");
			ProductImplementation pi=new ProductImplementation();	
		         pi.displayProduct();
			
			case 3:
					System.out.println("\n>>>>UpdateProductType<<<<\n");
					   ProductImplementation P1=new ProductImplementation();
				       Scanner sck=new Scanner(System.in);
				       System.out.println("Enter product type");
				       String pt=sck.next();
				       System.out.println("Enter product id");
				       int c=sck.nextInt();
				       P1.updateProductType(pt, c);
					
		   case 4:
					System.out.println(">>>>>>>>>>UpdateProductCost<<<<<<<<<<");
					ProductImplementation pi1=new ProductImplementation();	
					System.out.println("Enter ProductId");
					int ProductId=sc.nextInt();
					System.out.println("Enter the Cost:");
					int cost=sc.nextInt();
					pi1.updateCost(cost, ProductId);
					
	                	
		  case 5:
	                 System.out.println("Select ProductID");
	                 ProductImplementation pi2=new ProductImplementation();
	                 System.out.println("Enter the ProductId");
	                 int productid=sc.nextInt();
	                 pi2.selectProductId(productid);
	                 
	                
			}
			 break;
			
	   case 4:
		   System.out.println(">>> Purchase Details <<< \n Enter 1 for insert Purchase Details \n Enter 2 for AmountCalculation  ");
		   int num6=sc.nextInt();
		   
		   
	   switch(num6)
	   {
	   
	   case 1:
			
			PurchaseImplementation p5=new PurchaseImplementation();
			Scanner sc5=new Scanner(System.in);
			Purchase p2=new Purchase();
			
			System.out.println("Enter the ProductId:");
			p2.productId=sc5.nextInt();
			   System.out.println("Enter the CompanyId:");
				p2.companyId=sc5.nextInt();
				System.out.println("Enter the PurchaseQuantity:");
				p2.purchaseQuantity=sc5.nextInt();
				System.out.println("Enter the Amount:");
			    p2.amount=sc5.nextInt();
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
			System.out.println(">>> Sales Details <<< \n Enter 1 for Add SalesDetails \n Enter 2 for Update Amount sales");
	int num7=sc.nextInt();
			switch (num7)
			{
				case 1:
			SalesImplementation in=new SalesImplementation();
			//Sell s1=new Sell();
			Scanner scan = new Scanner(System.in);
			Sales s=new Sales();
			System.out.println("Enter the SalesId:");
			s.salesId=scan.nextInt();
			System.out.println("Enter the productId:");
			s.productId=scan.nextInt();
			System.out.println("Enter the SalesDate:");
			   DateTimeFormatter SalesDate = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			   LocalDateTime now = LocalDateTime.now();
			   System.out.println(SalesDate.format(now));
			System.out.println("Enter the SalesQuantity:");
			s.salesQuantity=scan.next();
			System.out.println("Enter the amount:");
			s.amount=scan.nextInt();
		     in.addSalesDetails(s);
		case 2:
			SalesImplementation obje=new SalesImplementation();
			Scanner sce=new Scanner(System.in);
			System.out.println("Enter the productId:");
			int productId=sce.nextInt();
			System.out.println("Enter the salesId:");
			int salesId=sce.nextInt();
			obje. amountCalAfterSales( productId, salesId);
			
			}
		case 6:
			System.out.println(">>> Stock Details <<< ");
			Stock1Implementation S=new Stock1Implementation();
			Stock1 st=new Stock1();
			System.out.println("Enter the StockId");
			break;
		}
	}
	
		else if(num==2)
		{
		System.out.println(">>>>User Portal<<<<<");
		System.out.println("Enter 1 for New User: \n Enter 2 for Existing User:");
		Scanner sc2=new Scanner(System.in);
		int num2=sc2.nextInt();
		switch(num2)
		{
		case 1:
		UserDAOImplementation obj1=new UserDAOImplementation();
		UserDetails u=new UserDetails();
		Scanner sc3=new Scanner(System.in);
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
			UserDAOImplementation u1=new UserDAOImplementation();
	//    UserDetails s=new UserDetails();
				u1.user();
		}
		}
		else
		{
			System.out.println("Login Failed");
		}
	
		}
		
}

