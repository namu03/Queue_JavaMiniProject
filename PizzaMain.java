package com.from5;

import java.util.Scanner;

public class PizzaMain {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		int size=100;
		Pizza p=null;
		PizzaParlor obj=new PizzaParlor(size);
		int ch=0,i=0;
		do
		{
			System.out.println("\t\t\t----#_#----Welcome to Pizza n cafe----#_#----");
			System.out.println("\t\t\t\t---___---MENU---___---");
			System.out.println("\t\tName\t\t\t\t\t\t\tPrice");
			System.out.println("\t\t\t\t\t\t\t\t-------------------");
			System.out.println("\t\t\t\t\t\t\t\tS\tM\tL");
			System.out.println("\t\t-------------------------------------------------------------------");
			System.out.println("\t\t1-CheeseNCornPizza\t\t\t\t150\t170\t230");
			System.out.println("\t\t2-CheesBurst\t\t\t\t\t175\t215\t290");
			System.out.println("\t\t3-PeppyPaneer\t\t\t\t\t200\t250\t300");
			System.out.println("\t\t4-Margherita\t\t\t\t\t120\t165\t200");
			System.out.println("\t\t5-DeluxeVeggie\t\t\t\t\t170\t240\t305");
			System.out.println("\t\t6-PaneerMakhani\t\t\t\t\t170\t240\t350");
			System.out.println();
			System.out.println("\t\t1-Place order\n\t\t2-Confirm Order\n\t\t3-Display Order/s");
			System.out.println("\t\tPlease enter your choice : ");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
//				System.out.println("\tEnter name of pizz, it's size(s/S,m/M,l/L), quantity and price : ");
//				p=new Pizza(sc.next(),sc.next().charAt(0),sc.nextInt(),sc.nextDouble());
				System.out.println("Enter customer name : ");
				String name=sc.next();
				System.out.println("How many varieties of pizzas you want to buy : ");
				int psize=sc.nextInt();
				Customer c=new Customer(name,psize);
				obj.placeOrder(c, size);
				break;
			case 2:
				obj.deleverOrder(size);
				break;
			case 3:
				obj.displayOrder(size);
				break;
			default:
				System.out.println("\t\t*_*_*Invalid choice..*_*_*");
			}
			System.out.println("\t\t**To continue press 1 : ");
			ch=sc.nextInt();
		}while(ch==1);
		System.out.println("\t\t\t***___***Thank you :)***___***");
	}

}
