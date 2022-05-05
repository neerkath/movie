package com.movie;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
public class movieticket {
     protected static Connection con=null;
     protected static Scanner sc= new Scanner(System.in);
     public static void details() throws Exception{
    	 System.out.println("Enter the username:");
    	 final String user=sc.next();
    	 System.out.println("Enter the password:");
    	 final String password=sc.next();
    	 class.forName("com.mysql.cj.jdbc.Driver");
    	 String url="jdbc::mysql://localhost:3306/neerkath";
    	 con=DriverManager.getConnection(url,user,password);
     }
     public static void InsertRecord()  throws Exeption{
    	 System.out.println("Enter the number of records to insert:");
    	 int n=sc.nextInt();
    	 int i=1;
    	 while(i<=n){
        	 System.out.println("Enter the booking  for movie ticket details");
        	 String s1="insert into ticket values";
        	 PreparedStatement pre=con.prepareStatement(s1);
        	 System.out.println("Enter city name");
        	 String city=sc.next();
        	 System.out.println("Enter theatre name");
        	 String theatre=sc.next();
        	 System.out.println("Enter movie name");
        	 String movie=sc.next();
        	 System.out.println("Enter movie date");
        	 int date=sc.nextInt();
        	 System.out.println("Enter show timing");
        	 int showtiming=sc.nextInt();
        	 System.out.println("Enter the class");
        	 String Class=sc.next();
        	 System.out.println("Enter no of tickets");
        	 int tickets=sc.nextInt();
        	 System.out.println("Enter seat number");
        	 int seat=sc.nextInt();
        	 System.out.println("Enter the ticket amount");
        	 int amount=sc.nextInt();
        	 pre.setString(1,city);
        	 pre.setString(2,theatre);
        	 pre.setString(3,movie);
        	 pre.setInt(4,date);
        	 pre.setInt(5,showtiming);
        	 pre.setString(6,Class);
        	 pre.setInt(7,tickets);
        	 pre.setInt(8,seat);
        	 pre.setInt(9,amount);
        	 int rows=pre.executeUpdate();
        	 if(rows>0) {
        		 System.out.println("Record insert successfully");
        		 System.out.println();
        	 }
        	 i++;
    	 }
     }
     public static void ShowRecord() throws Exception{
    	 System.out.println("Fetching the movie ticket details:");
    	 System.out.println();
    	 String nk="select *,(ticket*amount_per_ticket )as total_amount from movie";
    	 Statement nl=con.createStatement();
    	 Result rt=nl.executeQuery(nk);
    	 while(rt.next()) {
    		 System.out.println(rt.getString(1)+" || " + rt.getString(2)+ " || " + rt.getString(3)+" || "+ rt.getString(4)+" ||" + rt.getString(5)+" || " + rt.getString(6)+ " || " + rt.getString(7)+" || "+ rt.getString(8)+ "||" +rt.getString(9));
    		 
    	 }
     }
     public static void UpdateRecord() throws Exception{
    	 String name=sc.next();
    	 String name=sc.next();
    	 String sq="update movie set city name=? where theatre name=?";
    	 PreparedStatement pr=con.prepareStatement(sq);
         pr.setString(1,name);
         pr.setString(2,name);
         int rows=pr.executeUpdate(sq);
    	 if(rows>0) {
    		 System.out.println("Record update successfully");
    	 }
    	 String nq="select *,(ticket*amount_per_ticket )as total_amount from movie";
    	 Statement nt=con.createStatement();
    	 Result rt=nt.executeQuery(nq);
    	 while(rt.next()) {

    		 System.out.println(rt.getString(1)+" || " + rt.getString(2)+ " || " + rt.getString(3)+" || "+ rt.getString(4)+" ||" + rt.getString(5)+" || " + rt.getString(6)+ " || " + rt.getString(7)+" || "+ rt.getString(8)+ "||" +rt.getString(9));

    	 }
     }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		movieticket.details();
		movieticket.InsertRecord();
		movieticket.ShowRecord();
		movieticket.UpdateRecord();
		user obj=new user();
		obj.ExitRecord();
	}
     }

