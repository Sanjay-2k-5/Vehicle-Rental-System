package Borrower;
import LoginAndDB.*;
import Admin.*;
import java.util.*;
public class borroweroptions {
	public static Database obj = new Database();
	
	public static void blogin(String un) {

	    int k = -1;
	    if (obj.username != null) {
	        for (int i = 0; i < obj.username.length; i++) {
	            if (obj.username[i] != null && obj.username[i].equals(un)) {
	                k = i;
	            }
	        }
	    }

	    Scanner sc = new Scanner(System.in);
	    System.out.println("\n\nBorrower Options :");
	    System.out.println("\n1. My Info");
	    System.out.println("2. View Available Vehicles");
	    System.out.println("3. Rent a Vehicle");
	    System.out.println("4. History of Rentals");
	    System.out.println("5. Add Deposit");
	    System.out.println("6. Return Request");
	    System.out.println("7. Log Out\n");
	    System.out.print("\nEnter Option : ");
	    int sel = sc.nextInt();
	    switch (sel) {
	        case 1 -> {
	            borroweroperations.view(k,un);  
	        }
	        case 2 -> {
	            borroweroperations.display(un);  
	        }
	        case 3 -> {
	            System.out.println("\nRent a Vehicle by :");
	            System.out.println("\n1. Vehicle ID ");
	            System.out.println("2. Vehicle Number Plate");
	            System.out.print("\nEnter Option : ");
	            int sel1 = sc.nextInt();
	            if (sel1 == 1) {
	                System.out.print("\nEnter Vehicle ID : ");
	                int rid = sc.nextInt();
	                borroweroperations.searchbyid(rid, k,un);  
	            } else if (sel1 == 2) {
	                System.out.print("\nEnter Vehicle Number Plate : ");
	                String rnp = sc.next();
	                borroweroperations.searchbynp(rnp, k,un);  
	            }

	        }
	        case 4 -> {
	            borroweroperations.hor(k,un);  
	        }
	        case 5 -> {
	            borroweroperations.adddep(k,un);  
	        }
	        case 6->{
	        	borroweroperations.rr(k,un);
	        }
	        case 7 -> {
                System.out.print("\nLogged Out Successfully !\n");
	            login.main(null);  
	        }
	    }
	}

}
