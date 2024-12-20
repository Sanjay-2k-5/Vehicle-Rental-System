package Admin;

import java.util.*;
import LoginAndDB.*;

public class adminoptions {
	
public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("\nAdmin Options :");
		System.out.println("\n1. View All Vehicles");
		System.out.println("2. Search Vehicle");
		System.out.println("3. View Customer Details");
		System.out.println("4. Vehicle on Due for Service");
		System.out.println("5. View Rented and Non Rented Vehicle");
		System.out.println("6. Add Vehicle");
		System.out.println("7. Delete Vehicle");
		System.out.println("8. Modify Vehicle Details");
		System.out.println("9. Return Request View");
		System.out.println("10. Return a Vehicle");
		System.out.println("11. Log Out\n");
		System.out.print("\nEnter Option : ");
		int sel = sc.nextInt();
		adminoptionoperations obj=new adminoptionoperations();
        if(0<sel && sel<=11){
            switch (sel) {
                case 1 -> {
                    obj.display();
                    main(null);
                }
                case 2 -> {
                	System.out.println("\nView Vehicle by :");
                	System.out.println("\n1. Vehicle ID ");
            		System.out.println("2. Vehicle Number Plate");
            		System.out.print("\nEnter Option : ");
            		int sel1 = sc.nextInt();
            		if (sel1==1) {
            			System.out.print("\nEnter Vehicle ID : ");
            			int rid = sc.nextInt();
            			obj.searchid(rid);
            		}else if(sel1==2) {
            			System.out.print("\nEnter Registration Number : ");
            			String rnp = sc.next();
            			obj.searchnum(rnp);	
                }}              
                case 3 -> {
                	obj.cus();
                }
                case 4 -> {
                	System.out.println("\n1. Car");
            		System.out.println("2. Bike");
            		System.out.print("\nEnter Option : ");
            		int sel2 = sc.nextInt();
            		if(sel2==1) {
                	    obj.duecar();
                	    main(null);
                	}else if(sel2==2) {
                 		obj.duebike();
                		main(null);
                	}}
                case 5 -> {
                	obj.rentedandnon();
                }
                case 6 ->{
                	obj.addvehicle();
                }
                case 7 ->{
                	obj.del();
                	main(null);
                }
                case 8 ->{
                    obj.modify();
                }
                case 10->{
                	obj.reve();
                }
                case 9 ->{
                	obj.rrv();
                }
                case 11 ->{
                    System.out.print("\nLogged Out Successfully !\n");
                	login.main(null);
                }}}
        else{
            System.out.println("\nSelect Correct Option !");
            main(null);
        }}
}
