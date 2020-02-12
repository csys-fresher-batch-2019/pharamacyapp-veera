package pharmacyapp.Stock1Details;

import java.util.Scanner;

import pharmacyapp.stock1Details.Stock1;
import pharmacyapp.stock1Details.Stock1Implementation;

public class TestStock1 {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		Stock1Implementation b=new Stock1Implementation();
		Stock1 s1=new Stock1();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the stock1Id:");
		s1.setStock1Id(sc.nextInt());
		System.out.println("Enter the productId:");
		s1.setProductId(sc.nextInt());
		System.out.println("Enter the stock1Name:");
		s1.setStock1Name(sc.next());
		System.out.println("Enter the stock1Number:");
		s1.setStock1Number(sc.nextInt());
		System.out.println("Enter the stock1Type:");
		s1.setStock1Type(sc.next());
		System.out.println("Enter the stock1Status:");
		s1.setStock1Status(sc.next());
		b.addStockDetails(s1);
		
		
	}

}
