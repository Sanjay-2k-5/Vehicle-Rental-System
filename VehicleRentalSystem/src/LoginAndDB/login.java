package LoginAndDB;
import java.util.*;
import Admin.*;
public class login {
	
public static void main(String[] args) {
		
		int sel,c;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\n\n------------------------------  Vechicle Rental System   ------------------------------\n\n");
        System.out.println("Welcome :-)\n\n");
        System.out.println("Select Option :\n");
        System.out.println("1.Admin");
        System.out.println("2.Borrower\n");
        System.out.print("Enter Option : ");
        
        sel=sc.nextInt();
        
        if(0<sel && sel<=2){
            switch (sel) {
                case 1 -> {
                   adminlogin();
                }
                case 2 -> {
                   borrowerloginoption();
                }}}
        else{
            System.out.println("\nSelect Correct Option !");
            main(null);
        }}

public static int adminlogin()
{
	
    Scanner sc = new Scanner(System.in);
    final String UserName ="admin@vrs";
    final String pass="admin12";

    String un;
    String pa;
    
    System.out.println("\n\n--------------------Admin Login Page--------------------\n");
    System.out.print("\nEnter Username : ");
    un=sc.next();
    System.out.print("Enter Password : ");
    pa=sc.next();

    if (UserName.equals(un)) {
        if (pass.equals(pa)) {
            System.out.println("\nWelcome Admin : \n");
            Admin.adminoptions.main(null);}
        else {
            System.out.println("\nWrong Password !");
            adminlogin();
        }
    } else {
        System.out.println("\nWrong Username !");
        adminlogin();
    }

    return 0;

}


public static void borrowerloginoption(){
	Scanner sc = new Scanner(System.in);
    System.out.println("\nSelect Option :\n");
    System.out.println("1. Sign In");
    System.out.println("2. Sign Up\n");
    System.out.print("Enter Option : ");
    int sel=sc.nextInt();
    if(0<sel && sel<=2){
        switch (sel) {
            case 1 -> {
                borrowerlogin();
            }
            case 2 -> {
                borrowernewlogin();
            }
        }}
    else{
            System.out.println("\nSelect Correct Option !");
            borrowerloginoption();
        }}



public static int borrowerlogin() {
	Database obj=new Database();
    Scanner sc = new Scanner(System.in);
    String un;
    String pas;
    System.out.print("\nEnter Username: ");
    un = sc.next();
    System.out.print("Enter Password: ");
    pas = sc.next();
    boolean loginSuccess = false;
    for (int i = 0; i < obj.username.length; i++) {
        if (un.equals(obj.username[i])) {
            if (pas.equals(obj.pass[i])) {
                System.out.println("\nWelcome! " + obj.username[i]);
                Borrower.borroweroptions.blogin(obj.username[i]);  
                loginSuccess = true;
                break;  
            } else {
                System.out.println("Wrong Password!");
                borrowerlogin();
                return 0;
            }}}
    if (!loginSuccess) {
        System.out.println("Wrong Username!");
        borrowerlogin();
    }
    return 0;}



public static void borrowernewlogin() {
	
   Scanner sc=new Scanner(System.in);
   System.out.print("\nCreate Username : ");
   String un=sc.next();
   System.out.print("Create Password : ");
   String pas=sc.next();
   System.out.print("Confirm Password : ");
   String pas1=sc.next();
   System.out.print("Enter Contact Number : ");
   String con=sc.next();
   
   if(pas1.equals(pas)) {
	   System.out.println("\n1. Pay Initial deposit amount Rs.30000 to Create Account ");
	   System.out.println("2. Exit");
	   System.out.print("\nEnter Option : ");
	   int sel=sc.nextInt();
       if(0<sel && sel<=2){
           switch (sel) {
               case 1 -> {
                   loginpayment(un,pas,con);
               }
               case 2 -> {
                   main(null);
               }
           }}else{
               borrowerloginoption();
           }
   }
   else {
	   System.out.println("\nPassword does not Match !");
	   borrowernewlogin();
   }}



public static int[] addd(int length, int[] dep2, int i) {
	int newarr[]=new int[length+1];
	for (int k = 0; k < length; k++) 
    newarr[k] = dep2[k]; 
    newarr[length] = i; 
    return newarr;
}

public static String[] addp(int length, String[] pass2, String pas) {
	String newarr[]=new String[length+1];
	for (int i = 0; i < length; i++) 
    newarr[i] = pass2[i]; 
    newarr[length] = pas; 
    return newarr;
}

public static String[] addX(int length, String[] username2, String un) {
	String newarr[]=new String[length+1];
	for (int i = 0; i < length; i++) 
    newarr[i] = username2[i]; 
    newarr[length] = un; 
    return newarr;
}

public static String[][] add2dstr(String[][] arr) {
    String[][] newRentHistory = new String[arr.length + 1][];
    for (int i = 0; i < arr.length; i++) {
        newRentHistory[i] = arr[i];
    }
        newRentHistory[arr.length] = new String[]{};
    return newRentHistory;
}


public static int[][] add2dint(int[][] arr) {
    int[][] newRentHistory = new int[arr.length + 1][];
    for (int i = 0; i < arr.length; i++) {
        newRentHistory[i] = arr[i];
    }
        newRentHistory[arr.length] = new int[]{};
    return newRentHistory;
}


public static void loginpayment(String un, String pas, String con) {
	    Database obj=new Database();
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\nSelect Option :");
		System.out.println("\n1. Card Payment");
		System.out.println("2. Cancel Payment");
		System.out.print("\nEnter Option :");
		int in=sc.nextInt();
		
		if(in==1) {
			System.out.print("\nEnter Card Number :");
			long cardnum=sc.nextLong();
			System.out.print("Enter Pin Number :");
			int pinnum=sc.nextInt();
			System.out.print("\nPayment Successful !\n");
			String[] ar= {};
			obj.username=addX(obj.username.length,obj.username,un);
			obj.pass=addp(obj.pass.length,obj.pass,pas);
			obj.dep=addd(obj.dep.length,obj.dep,30000);
			obj.rcount=addd(obj.rcount.length,obj.rcount,0);
			obj.contact=addX(obj.contact.length,obj.contact,con);
			obj.lastrent=addX(obj.lastrent.length,obj.lastrent,"No one");
			obj.renthistory=add2dstr(obj.renthistory);
			obj.days=add2dint(obj.days);
			obj.Returnrequest=add2dstr(obj.Returnrequest);
//			for(int i =0;i<obj.username.length;i++) {
//				System.out.println(obj.username[i]);
//			}
			System.out.println("\nWelcome! " + un);
			Borrower.borroweroptions.blogin(un);
}
		else if (in==2) {
  	borrowerloginoption();
  }}

	
}
