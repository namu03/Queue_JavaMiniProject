package com.from5;

import java.util.*;

public class PizzaParlor {
	Scanner sc=new Scanner(System.in);

	int front=0,rear=0,size;
	int max_size=50;
	Customer queue[];

	public  PizzaParlor(int size)
	{
		front=rear=0;
		queue=new Customer[size];
	}

	public boolean isFull(int size)
	{
		if(rear==size-1)
			return true;
		else
			return false;
	}

	public boolean isEmpty(int size)
	{
		if(front<0 || front>rear)
			return true;
		else
			return false;
	}

	public void placeOrder(Customer c,int size)
	{
		if(isEmpty(size)==false && isFull(size)==false)
		{
			//			System.out.println("Enter customer name : ");
			//			String name=sc.next();
			//			System.out.println("How many varieties of pizzas you want to buy : ");
			//			int psize=sc.nextInt();
			//			Customer c=new Customer(name,psize);
			Pizza p[]=new Pizza[c.getP().length];
			for(int i=0;i<c.getP().length;i++)
			{
				System.out.println("\tEnter name of pizz, it's size(s/S,m/M,l/L), quantity and price : ");
				p[i]=new Pizza(sc.next(),sc.next().charAt(0),sc.nextInt(),sc.nextDouble());

			}
			c.setP(p);
			queue[rear]=c;
			//			queue[rear]=p;
			System.out.println("\t\t--$$--Congratulations!!....Order has been placed successfully..--$$--");
			rear++;
		}
		if(isFull(size)==true)
			System.out.println("\t\t\t**Sorry we have enough order for the day...please try later :))**");
	}

	public void displayOrder(int size)
	{
		if(isFull(size)==false && isEmpty(size)==false)
		{
			if(front!=rear)
			{
				System.out.println("\t\t\t--^_^--Orders are--^_^-- ");
				for(int i=front;i<rear;i++)
				{
					System.out.println("\t\t\tCustomer name : "+queue[i].getCustName());
					System.out.println("\t\tOrders are as follows : ");
					for(int j=0;j<queue[i].getP().length;j++)
					{
						System.out.println("\t\tPizza Name\t : "+queue[i].getP()[j].getName());
						System.out.println("\t\tSize\t\t : "+queue[i].getP()[j].getSize());
						System.out.println("\t\tQuantity\t : "+queue[i].getP()[j].getQty());
						System.out.println("\t\tPrice\t\t : "+queue[i].getP()[j].getPrice());
						System.out.println("\t\t-------------------------------------------");
					}
				}
			}
			//			
		}
		if(front==rear)
			System.out.println("\t\t\tThere are no orders :)");
	}

	public void deleverOrder(int size)
	{
		int i=-1;
		if(front==rear)
			System.out.println("\t\t\tNo orders to deliver :)");
		//			
		//		
		else
		{
			i=front;
			System.out.println("\t\t\tCustomer name : "+queue[i].getCustName());
			System.out.println("\t\t---***---Order Details---***---");
			for(int j=0;j<queue[i].getP().length;j++)
			{
				System.out.println("\t\tPizza name\t : "+queue[i].getP()[j].getName());
				System.out.println("\t\tSize\t\t : "+queue[i].getP()[j].getSize());
				System.out.println("\t\tQuantity\t : "+queue[i].getP()[j].getQty());
				System.out.println("\t\tPrice\t\t : "+queue[i].getP()[j].getPrice());
				System.out.println("\t\t---------------------------------------------");
			}
			
			calc();
			System.out.println("\t\t--$$--Bill Details--$$--");
			System.out.println("\t\t-----------------------------------------");
			System.out.println("\t\tTotal\t\t : "+queue[front].getBill().getTotal());
			System.out.println("\t\tCgst\t\t : "+queue[front].getBill().getCgst());
			System.out.println("\t\tSgst\t\t : "+queue[front].getBill().getSgst());
			System.out.println("\t\tFinal total\t : "+queue[front].getBill().getFinalTotal());
			System.out.println("\t\t---------------------------------------------");
			System.out.println("\t\tOrders will be at your place very soon @_@");
			front++;
		}
	}
	
	public void calc()
	{
		int i=front;
		double total=0,cgst=0,sgst=0,finaltotal=0;
		for(Pizza j:queue[i].getP())
		{
			total=(total+j.getPrice())*j.getQty();
		}
		
		cgst=total*0.03;
		sgst=total*0.03;
		finaltotal=total+cgst+sgst;
		
		Bill b=new Bill(total, cgst, sgst, finaltotal);
		queue[front].setBill(b);
	}

}


