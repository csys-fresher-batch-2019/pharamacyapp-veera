package pharmacyapp.CompanyDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
	switch(num)
	{ 
	case 1:
		CompanyImplementation obj=new CompanyImplementation();
		obj.admin();
		System.out.println(" Enter 1 for insert Order Details: \n Enter 2 for insert CompanyDetails: \n Enter 5 for insert ProductDetails: \n Enter 6 for insert PurchaseDetails: \n Enter 7 for insert SalesDetails:  \n Enter 8 for  insert StockDetails:");
		int nu=sc.nextInt();

		switch(nu) 
		{
		case 1:
			
			orderDAOImplementation obj2=new orderDAOImplementation();
			Order d=new Order();
			Scanner sc1=new Scanner(System.in);
			System.out.println(">>>Enter Order Details<<<");
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
			
		case 2:
			
			System.out.println(">>> Company Details <<< \n Enter 1 for Add Company Details \n Enter 2 for UpdateCost");
		int num1=sc.nextInt();
			if(num1==1)
			{
			
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
			    num1=sc.nextInt();
			}
			
			    else if (num1==2)
			{
		
				ProductImplementation im=new ProductImplementation();
				Scanner scq=new Scanner(System.in);
				System.out.println("Enter the UpdateCost:");
				int cost=scq.nextInt();
				System.out.println("Enter the ProductId:");
				int proId=scq.nextInt();
				im.updateCost(cost,proId);
			
			break;
			}
		
			
		    
		
		case 5:
			System.out.println(">>> Product Details <<< \n Enter 1 for Add ProductDetails: \n Enter 2 for DispalyProduct: \n  Enter 3 to UpdateProductType: \n Enter 4 to UpdateCost: \n Enter 5 to Select ProductId:");
		  
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
			
			break;
				
				case 2:
					System.out.println("DisplayProductDetails");
			ProductImplementation pi=new ProductImplementation();	
		         pi.displayProduct();
			
			case 3:
					System.out.println("UpdateProductType");
					   ProductImplementation p=new ProductImplementation();
				       Scanner sck=new Scanner(System.in);
				       System.out.println("Enter product type");
				       String pt=sck.next();
				       System.out.println("Enter product id");
				       int c=sck.nextInt();
				       p.updateProductType(pt, c);
					break;
				case 4:
					System.out.println("UpdateProductCost");
					ProductImplementation pi1=new ProductImplementation();	
					System.out.println("Enter ProductId");
					int ProductId=sc.nextInt();
					System.out.println("Enter th Cost:");
					int cost=sc.nextInt();
					pi1.updateCost(cost, ProductId);
					
				case 5:
	                 System.out.println("Select ProductID");
	                 ProductImplementation pi2=new ProductImplementation();
	                 System.out.println("Enter the ProductId");
	                 int productid=sc.nextInt();
	                 pi2.selectProductId(productid);
			}
			
	   case 6:
		   System.out.println(">>> Purchase Details <<< \n Enter 61 for insert Purchase Details \n Enter 62 for AmountCalculation  ");
		   int num6=sc.nextInt();
		   
		   
	   switch(num6)
	   {
	   
	   case 61:
			
			PurchaseImplementation p5=new PurchaseImplementation();
			Scanner sc5=new Scanner(System.in);
			Purchase p2=new Purchase();
			System.out.println("Enter the PurchaseId:");
			p2.purchaseId=sc5.nextInt();
			System.out.println("Enter the ProductId:");
			p2.productId=sc5.nextInt();
			   System.out.println("Enter the CompanyId:");
				p2.companyId=sc5.nextInt();
				System.out.println("Enter the PurchaseQuantity:");
				p2.purchaseQuantity=sc5.nextInt();
				System.out.println("Enter the Amount:");
			    p2.amount=sc5.nextInt();
			    p5.addPurchaseDetails(p2);
			    break;
	   case 62:
			PurchaseImplementation obj1 = new PurchaseImplementation();
				Scanner sct = new Scanner(System.in);
				System.out.println("Enter purchase Id:");
				int purchaseId = sct.nextInt();
				System.out.println("Enter product Id:");
				int productId = sct.nextInt();
				obj1.amountCalculation(productId, purchaseId);
				break;
	   }
		case 7:
			System.out.println(">>> Sales Details <<< \n Enter 71 for Add SalesDetails \n Enter 72 for Update Amount sales");
	int num7=sc.nextInt();
			switch (num7)
			{
				case 71:
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
		case 72:
			SalesImplementation obje=new SalesImplementation();
			Scanner sce=new Scanner(System.in);
			System.out.println("Enter the productId:");
			int productId=sce.nextInt();
			System.out.println("Enter the salesId:");
			int salesId=sce.nextInt();
			obje. amountCalAfterSales( productId, salesId);
			}
		case 8:
			System.out.println(">>> Stock Details <<< ");
			Stock1Implementation S=new Stock1Implementation();
			Stock1 st=new Stock1();
			System.out.println("Enter the StockId");
			break;
		
		}
	case 2:
		
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
		
}
}


