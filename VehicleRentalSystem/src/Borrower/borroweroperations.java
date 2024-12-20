package Borrower;

import LoginAndDB.*;

import java.util.Scanner;

import Admin.*;
public class borroweroperations {
	public static Database obj=new Database();
	
	public static String toString(int i) {
		Database obj=new Database();
		return "Vehicle Id : " + obj.idi[i] + "\n" +
				"Vehicle Type : " + obj.vty[i] + "\n" +
				"Vehicle Brand : " + obj.br[i] + "\n" +
				"Vehicle Model : " + obj.mo[i] + "\n" +
				"Number Plate : " + obj.nop[i] + "\n" +
				"Vehicle Count : " + obj.count[i] + "\n" +
				"Rental Price : " + obj.rpi[i] + "\n" +
				"Travelled Distance : " + obj.tdi[i] + "\n" +
				"Availability : " + (obj.av[i] ? "Yes" : " No");
	}
public static void display(String un) {
		System.out.println("\nVehicle Details :");
		
		System.out.printf("\n");
		System.out.printf("\nCars :\n\n");
		System.out.printf("%-10s %-10s %-10s %-10s %-15s %-12s %-12s %-20s %-12s%n", 
		                      "ID", "Type", "Brand", "Model", "NoPlate","Count", "RPrice", "TDistance", "Availablility");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		
		for (int i = 0; i < obj.idi.length; i++) {
			if(obj.vty[i].equals("car") && obj.av[i]) {
	        System.out.printf("%-10d %-10s %-10s %-10s %-15s %-12d %-12d %-20d %-12s%n",
	        		obj.idi[i], obj.vty[i], obj.br[i], obj.mo[i], obj.nop[i], obj.count[i],
	        		obj.rpi[i],obj.tdi[i], obj.av[i] ? "Yes" : " No");}}
		System.out.printf("\n");
		System.out.printf("\nBikes :\n\n");
		System.out.printf("%-10s %-10s %-10s %-10s %-15s %-12s %-12s %-20s %-12s%n", 
		                      "ID", "Type", "Brand", "Model", "NoPlate","Count", "RPrice", "TDistance", "Availablility");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		
		for (int i = 0; i < obj.idi.length; i++) {
			if(obj.vty[i].equals("bike") && obj.av[i]) {
	        System.out.printf("%-10d %-10s %-10s %-10s %-15s %-12d %-12d %-20d %-12s%n",
	        		obj.idi[i], obj.vty[i], obj.br[i], obj.mo[i], obj.nop[i], obj.count[i],
	        		obj.rpi[i],obj.tdi[i], obj.av[i] ? "Yes" : " No");}}

        borroweroptions.blogin(un);}

public static void searchbyid(int rid,int un, String un2) {
    boolean found = false;  
    int k = -1;  

    for (int i = 0; i < obj.idi.length; i++) {
        if (obj.idi[i]==rid && obj.av[i]) {
            System.out.println("\nVehicle Found:\n");
            System.out.println(toString(i));
            found = true;  
            k = i;  
            break;  
        }
    }
    if (!found) {
        System.out.println("\nVehicle not available");
        borroweroptions.blogin(un2);  
    } else {
        System.out.println("\nProceed to Checkout ...");
        checkout(k,un,un2);
    }
}


public static void searchbynp(String rnp,int un, String un2) {
    boolean found = false;  
    int k = -1;  

    for (int i = 0; i < obj.idi.length; i++) {
        if (obj.nop[i].equals(rnp) && obj.av[i]) {
            System.out.println("\nVehicle Found:\n");
            System.out.println(toString(i));
            found = true;  
            k = i;  
            break;  
        }
    }
    if (!found) {
        System.out.println("\nVehicle not available");
        borroweroptions.blogin(un2);  
    } else {
    	 
        System.out.println("\nProceed to Checkout ...");
        checkout(k,un,un2);
    	
    	
    }
}

public static void checkout(int k,int un, String un2) {
	
	System.out.print("\nTotal Days : ");
	Scanner sc = new Scanner(System.in);
	int day = sc.nextInt();
	float tot=(((12/(float)100)*(obj.rpi[k]*day)*2)+obj.rpi[k]*day);
	System.out.println("\nBill Details :\n");
	System.out.println("Rental price ( "+day+" Days ) :"+obj.rpi[k]*day);
	System.out.println("CGST ( 12% )           :"+((12/(float)100)*(obj.rpi[k]*day)));
	System.out.println("SGST ( 12% )           :"+((12/(float)100)*(obj.rpi[k]*day)));
	System.out.println("-----------------------------");
	System.out.println("Total                 :"+tot);
	System.out.println("-----------------------------");
	
    payment(k,tot,un,day,un2);
}

public static void payment(int k,float tot,int un, int day, String un2) {
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
		obj.count[k]-=1;
		if(obj.count[k]==0) {
			obj.av[k]=false;
		}
		obj.lastrent[un]=obj.nop[k];
		obj.rcount[un]+=1;
		obj.renthistory=addto2dstr(obj.renthistory,un,obj.nop[k]);
		obj.days=addto2dint(obj.days,un,day);
		borroweroptions.blogin(un2);
	}else if(in==2){
		System.out.print("\nPayment Cancelled !\n");
		borroweroptions.blogin(un2);
	}}

public static void view(int k, String un) {
	
	System.out.println("\nMy Info :");
	System.out.println("\nUsername : "+obj.username[k]);
	System.out.println("Rented Vehicle Count : "+obj.rcount[k]);
	System.out.println("Last Rented Vehicle : "+obj.lastrent[k]);
	System.out.println("Deposit Amount : "+obj.dep[k]);
	System.out.println("Contact Number : "+obj.contact[k]);
    borroweroptions.blogin(un);
    }


public static int[][] addto2dint(int[][] arr, int index, int newElement) {
   
    if (index >= arr.length || index < 0) {
        System.out.println("Invalid index.");
        return arr;
    }
    int[] selectedRow = arr[index];
    int[] newSelectedRow = new int[selectedRow.length + 1];
    for (int i = 0; i < selectedRow.length; i++) {
        newSelectedRow[i] = selectedRow[i];
    }
    newSelectedRow[selectedRow.length] = newElement;
    arr[index] = newSelectedRow;

    return arr;
}


public static String[][] addto2dstr(String[][] arr, int index, String newElement) {
	   
    if (index >= arr.length || index < 0) {
        System.out.println("Invalid index.");
        return arr;
    }
    String[] selectedRow = arr[index];
    String[] newSelectedRow = new String[selectedRow.length + 1];
    for (int i = 0; i < selectedRow.length; i++) {
        newSelectedRow[i] = selectedRow[i];
    }
    newSelectedRow[selectedRow.length] = newElement;
    arr[index] = newSelectedRow;

    return arr;
}

public static void hor(int k, String un) {
	System.out.printf("\n");
	System.out.printf("%-15s %-15s %-15s %-15s %-15s"
			,"ID", "Type", "Brand", "Model", "NoPlate");
	System.out.printf("\n----------------------------------------------------------------------------");
	int m=0;
	for(int i=0;i<obj.idi.length;i++) {
		for(int j=0;j<obj.renthistory[k].length;j++) {
			if(obj.nop[i].equals(obj.renthistory[k][j])) {
				m++;
				System.out.printf("\n%-15d %-15s %-15s %-15s %-15s",obj.idi[i], obj.vty[i], obj.br[i], obj.mo[i], obj.nop[i]);
			}
		}
	}
	if(m==0) {
		System.out.println("\n\nNo Rented Vehicles Available !");
		borroweroptions.blogin(un);
	}else {
		borroweroptions.blogin(un);
	}
	
}

public static void adddep(int k,String un) {
	Scanner sc=new Scanner(System.in);
	System.out.println("\nOld Security Deposit : "+obj.dep[k]);
	System.out.println("Enter the Amount to be Added : ");
    int amt=sc.nextInt();
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
		obj.dep[k]+=amt;
		borroweroptions.blogin(un);
} else if(in==2) {
	borroweroptions.blogin(un);
}
	}

public static void rr(int un,String un2) {
	Scanner sc=new Scanner(System.in);
	String reg;
	String dr;
	String km;
	String cn;
	String dmg;
	System.out.println("\nEnter Vehicle Registration Number :");
	reg = sc .next();
	System.out.println("Enter the Day of Return :");
    dr = sc.next();
    System.out.println("Enter KM's Travelled :");
    km = sc.next();
    System.out.println("Enter Damage Level :");
    dmg = sc.next();
    System.out.println("Enter Contact No :");
    cn = sc.next();
    System.out.println("Request Submitted Successfully !\n");
    obj.Returnrequest=addto2dstr(obj.Returnrequest,un,reg);
    obj.Returnrequest=addto2dstr(obj.Returnrequest,un,dr);
    obj.Returnrequest=addto2dstr(obj.Returnrequest,un,km);
    obj.Returnrequest=addto2dstr(obj.Returnrequest,un,dmg);
    obj.Returnrequest=addto2dstr(obj.Returnrequest,un,cn);
    borroweroptions.blogin(un2);
	
}


}
