package Admin;

import java.util.*;

import Borrower.borroweroptions;
import LoginAndDB.*;


public class adminoptionoperations {
	
	public static int r=0;
	public static int nr=0;
	
	
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
	
	
	
	public static void display() {
		
		Database obj=new Database();
		
		System.out.println("\nVehicle Details :");
		
		System.out.printf("\n");
		System.out.printf("\nCars :\n\n");
		System.out.printf("%-10s %-10s %-10s %-10s %-15s %-12s %-12s %-20s %-12s%n", 
		                      "ID", "Type", "Brand", "Model", "NoPlate","Count", "RPrice", "TDistance", "Availablility");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		
		for (int i = 0; i < obj.idi.length; i++) {
			if(obj.vty[i].equals("car")) {
	        System.out.printf("%-10d %-10s %-10s %-10s %-15s %-12d %-12d %-20d %-12s%n",
	        		obj.idi[i], obj.vty[i], obj.br[i], obj.mo[i], obj.nop[i], obj.count[i],
	        		obj.rpi[i],obj.tdi[i], obj.av[i] ? "Yes" : " No");}}
		System.out.printf("\n");
		System.out.printf("\nBikes :\n\n");
		System.out.printf("%-10s %-10s %-10s %-10s %-15s %-12s %-12s %-20s %-12s%n", 
		                      "ID", "Type", "Brand", "Model", "NoPlate","Count", "RPrice", "TDistance", "Availablility");
		System.out.println("--------------------------------------------------------------------------------------------------------------------------");
		for (int i = 0; i < obj.idi.length; i++) {
			if(obj.vty[i].equals("bike")) {
	        System.out.printf("%-10d %-10s %-10s %-10s %-15s %-12d %-12d %-20d %-12s%n",
	        		obj.idi[i], obj.vty[i], obj.br[i], obj.mo[i], obj.nop[i], obj.count[i],
	        		obj.rpi[i],obj.tdi[i], obj.av[i] ? "Yes" : " No");}}}
	
	
	
	public static void searchnum(String numplate) {
		
		  Database obj=new Database();
	      
	      boolean found = false;
	      for (int i = 0; i < obj.idi.length; i++) {
	         if (obj.nop[i].equals(numplate)) {  
	        	 System.out.println("\n");
	             System.out.println(toString(i));
	             found = true;
	             break;
	        }}
	      if (!found) {
	            System.out.println("\nVehicle with Number plate  " + numplate + " is not found.\n");
	            adminoptions.main(null);
	        }adminoptions.main(null); }
	
	
	public static  void searchid(int k) {
		Database obj=new Database();
	      
	      boolean found = false;
	      for (int i = 0; i < obj.idi.length; i++) {
	         if (obj.idi[i]==k) {  
	        	 System.out.println("\n");
	             System.out.println(toString(i));
	             found = true;
	             break;
	        }}
	      if (!found) {
	            System.out.println("\nVehicle with ID  " + k + " is not found.\n");
	            adminoptions.main(null);
	        }adminoptions.main(null);}

	public static void cus() {
		Database obj=new Database();
		System.out.printf("\n");
		System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s", 
		                      "S.NO", "Username", "RCount", "Deposit","LastRented","Contact Num");
		System.out.printf("\n");
		System.out.println("--------------------------------------------------------------------------------------------");
		for (int i = 0; i < obj.username.length; i++) {
			System.out.printf("%-15d %-15s %-15d %-15d %-15s %-15s",
					i+1,obj.username[i],obj.rcount[i],obj.dep[i],obj.lastrent[i],obj.contact[i] );
			System.out.printf("\n");
		}
		adminoptions.main(null);}
	
	
	
	public static void duebike() {
		Database obj=new Database();

		int k =0;
		for (int i = 0; i < obj.idi.length; i++) {
		if (obj.tdi[i]>1500 && obj.vty[i].equals("bike")) {
			System.out.println("\nBike with ID \""+obj.idi[i]+"\" and Number Plate : "+obj.nop[i]+" need to get Serviced.");
			k++;
		}}
		for(int j=0;j<obj.serviced.length;j++) {
			for (int l = 0; l < obj.idi.length; l++) {
				if(obj.serviced[j].equals(obj.nop[l]) && obj.vty[l].equals("bike")) {
					System.out.println("\nBike with ID \""+obj.idi[l]+"\" and Number Plate : "+obj.nop[l]+" need to get Serviced.");
					k++;
				}
				
			}
		}
			
		if (k==0) {
			System.out.println("\nAll Bikes are in Good Condition !");
		}
		System.out.println("\nThank You !");}
	
	
	public static void duecar() {
		Database obj=new Database();

		int k =0;
		for (int i = 0; i < obj.idi.length; i++) {
		if (obj.tdi[i]>3000 && obj.vty[i].equals("car")) {
			System.out.println("\nCar with ID \""+obj.idi[i]+"\" and Number Plate : "+obj.nop[i]+" need to get Serviced.");
			k++;
		}
		for(int j=0;j<obj.serviced.length;j++) {
			for (int l = 0; l < obj.idi.length; l++) {
				if(obj.serviced[j].equals(obj.nop[l]) && obj.vty[l].equals("car")) {
					System.out.println("\nCar with ID \""+obj.idi[l]+"\" and Number Plate : "+obj.nop[l]+" need to get Serviced.");
					k++;
				}
				
			}
		}
			
		}if (k==0) {
			System.out.println("\nAll Cars are in Good Condition !");
		}
		System.out.println("\nThank You !");}
	
	
	public static void rentedandnon(){
		
        Database obj=new Database();
        
        System.out.printf("\nRented Vehicles :\n");
		System.out.printf("\n");
		System.out.printf("%-10s %-10s %-10s %-10s %-15s %-12s %-12s %-20s %-12s%n", 
		                      "ID", "Type", "Brand", "Model", "NoPlate","Count", "RPrice", "TDistance", "Availablility");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		
		for (int i = 0; i < obj.idi.length; i++) {
			if(!obj.av[i]) {
				r++;
	        System.out.printf("%-10d %-10s %-10s %-10s %-15s %-12d %-12d %-20d %-12s%n",
	        		obj.idi[i], obj.vty[i], obj.br[i], obj.mo[i], obj.nop[i], obj.count[i],
	        		obj.rpi[i],obj.tdi[i], obj.av[i] ? "Yes" : " No");}}
		System.out.printf("\nNon Rented Vehicles :\n");
		System.out.printf("\n");
		System.out.printf("%-10s %-10s %-10s %-10s %-15s %-12s %-12s %-20s %-12s%n", 
		                      "ID", "Type", "Brand", "Model", "NoPlate","Count", "RPrice", "TDistance", "Availablility");
		System.out.println("-----------------------------------------------------------------------------------------------------------------------");
		
		for (int i = 0; i < obj.idi.length; i++) {
			if(obj.av[i]) {
				nr++;
	        System.out.printf("%-10d %-10s %-10s %-10s %-15s %-12d %-12d %-20d %-12s%n",
	        		obj.idi[i], obj.vty[i], obj.br[i], obj.mo[i], obj.nop[i], obj.count[i],
	        		obj.rpi[i],obj.tdi[i], obj.av[i] ? "Yes" : " No");}}
		System.out.println("\nTotal Rented Vehicle\'s : "+r);
		System.out.println("\nTotal Non Rented Vehicle\'s : "+nr);
		adminoptions.main(null);}
	
	
	public static String[] addstr(int length, String[] arr, String add) {
		String newarr[]=new String[length+1];
		for (int i = 0; i < length; i++) 
	    newarr[i] = arr[i]; 
	    newarr[length] = add; 
	    return newarr;}
	
	public static int[] addint(int length, int[] arr, int add) {
		int newarr[]=new int[length+1];
		for (int i = 0; i < length; i++) 
	    newarr[i] = arr[i]; 
	    newarr[length] = add; 
	    return newarr;}
	
	public static boolean[] addbol(int length, boolean[] arr, String add) {
		boolean n;
		boolean newarr[]=new boolean[length+1];
		n=add.equals("yes")?true:false;
		for (int i = 0; i < length; i++) 
	    newarr[i] = arr[i]; 
	    newarr[length] = n; 
	    return newarr;}

	
	public static void addvehicle() {
		
		Database obj=new Database();
		Scanner sc = new Scanner(System.in);
		String addvtype;
		String addbrand;
		String addmodel;
		String addnopl;
		String addavail;
		int addrprice;
		int addtradis;
		int addcount;
		
		
		System.out.println("\nEnter Vehicle Type :");
		addvtype = sc.next();
		System.out.println("Enter Vehicle Brand :");
		addbrand = sc.next();
		System.out.println("Enter Number Plate :");
		addnopl = sc.next();
		System.out.println("Enter Vehicle Model :");
		addmodel = sc.next();
		System.out.println("Enter Available Count :");
		addcount=sc.nextInt();
		System.out.println("Enter Rental Price :");
		addrprice = sc.nextInt();
		System.out.println("Enter Travelled Distance :");
		addtradis = sc.nextInt();
		System.out.println("Enter Availability :");
		addavail = sc.next();
		
		int n=obj.idi.length;
		obj.idi=addint(obj.idi.length,obj.idi,n+1);
		obj.vty=addstr(obj.vty.length,obj.vty,addvtype);
		obj.br=addstr(obj.br.length,obj.br,addbrand);
		obj.mo=addstr(obj.mo.length,obj.mo,addmodel);
		obj.nop=addstr(obj.nop.length,obj.nop,addnopl);
		obj.count=addint(obj.count.length,obj.count,addcount);
		obj.rpi=addint(obj.rpi.length,obj.rpi,addrprice);
		obj.tdi=addint(obj.tdi.length,obj.tdi,addtradis);
		obj.av=addbol(obj.av.length,obj.av,addavail);
	    
	    System.out.println("\nVehicle added successfully!");
	    System.out.println("\nUpdated Vehicle list :\n");
	    display();
	    adminoptions.main(null); }
	
	
	public static String[] delstr(int length, String[] arr, int del) {
		String newarr[]=new String[length-1];
		for (int i = 0,k=0; i < length; i++) {
			if (i!=del) {
				newarr[k]=arr[i];
				k++;
		}}
		return newarr;}
	
	public static int[] delint(int length, int[] arr, int del) {
		int newarr[]=new int[length-1];
		for (int i = 0,k=0; i < length; i++) {
			if (i!=del) {
				newarr[k]=arr[i];
				k++;
			}}
		return newarr;}
	
	public static boolean[] delbol(int length, boolean[] arr, int del) {
		boolean newarr[]=new boolean[length-1];
		for (int i = 0,k=0; i < length; i++) {
			if (i!=del) {
				newarr[k]=arr[i];
				k++;
			}}
	    return newarr;}
	
	
	
	public static void del() {
		Database obj=new Database();
		Scanner sc = new Scanner(System.in);
		String denop;
		System.out.print("\nEnter Registration Number : ");
		denop = sc.next();
		int in=-1;
		int k=0;
		for (int i=0;i<obj.idi.length;i++) {
			if(obj.nop[i].equals(denop)) {
				k=k+1;
				in=i;
			}}
		if(k>=1) {
			String ty=obj.vty[in];
			obj.idi=delint(obj.idi.length,obj.idi,in);
			obj.vty=delstr(obj.vty.length,obj.vty,in);
			obj.br=delstr(obj.br.length,obj.br,in);
			obj.mo=delstr(obj.mo.length,obj.mo,in);
			obj.nop=delstr(obj.nop.length,obj.nop,in);
			obj.count=delint(obj.count.length,obj.count,in);
			obj.rpi=delint(obj.rpi.length,obj.rpi,in);
			obj.tdi=delint(obj.tdi.length,obj.tdi,in);
			obj.av=delbol(obj.av.length,obj.av,in);
			System.out.println("\n"+ty+ " with Registration Number "+denop+" has been Deleted Successfully!");
        }else {
			System.out.println("\nWrong Registration Number !");
			adminoptions.main(null);
			}}
	
	
	public static void modify() {
		Database obj=new Database();
		Scanner sc = new Scanner(System.in);
		String modnop;
		System.out.print("\nEnter Registration Number : ");
		modnop = sc.next();
		int in=-1;
		int k=0;
		for (int i=0;i<obj.idi.length;i++) {
			if(obj.nop[i].equals(modnop)) {
				k=k+1;
				in=i;
			}}
		if(k>=1) {
			System.out.println("\nVehicle Id: "+obj.idi[in]);
			System.out.println("Vehicle Brand : "+obj.br[in]);
			System.out.println("Vehicle Model : "+obj.mo[in]);
			System.out.println("Vehicle Reg Number : "+obj.nop[in]);
			System.out.println("Vehicle Count : "+obj.count[in]);
			System.out.println("Vehicle Rental price: "+obj.rpi[in]);
			System.out.println("Travelled Distance : "+obj.tdi[in]);
			System.out.println("Vehicle Availability : "+(obj.av[in] ? "Yes" : " No"));
			modopt(in);
		}else{
			System.out.println("\nWrong Registration Number !");
			adminoptions.main(null);
			}}
	
	
  public static void modopt(int i) {
	 Database obj=new Database();
	 Scanner sc = new Scanner(System.in);
	 System.out.println("\nWhat Details you want to Modify ?");
     System.out.println("\n1. Model");
     System.out.println("2. Rental Price");
     System.out.println("3. Count");
     System.out.println("4. Due for Service");
     System.out.println("\nEnter Option : ");
     int sel=sc.nextInt();
     switch(sel) {
     case 1 ->{
    	 System.out.println("\nVehicle Model (Old): "+obj.mo[i]);
         System.out.println("Enter New Model : ");
         String mod=sc.next();
         obj.mo[i]=mod;
         System.out.println("\nDetail Modified Successfully ");

         System.out.println("Modify Another Detail (Yes/No) : ");
         String op=sc.next();
         if(op.equals("yes")) {
        	 modopt(i);
         }else {
        	 adminoptions.main(null);
         }}
     case 2 ->{
    	 System.out.println("\nRental Price (Old): "+obj.rpi[i]);
         System.out.println("Enter Rental Price : ");
         int mod=sc.nextInt();
         obj.rpi[i]=mod;
         System.out.println("\nDetail Modified Successfully ");
         System.out.println("Modify Another Detail (Yes/No) : ");
         String op=sc.next();
         if(op.equals("yes")) {
        	 modopt(i);
         }else {
        	 adminoptions.main(null);
         }}
     case 3 ->{
    	 System.out.println("\nCount (Old): "+obj.count[i]);
         System.out.println("Enter Count : ");
         int mod=sc.nextInt();
         if (obj.count[i]==0) {
        	 obj.av[i]=true;
             obj.count[i]=mod;}
         else
        	 obj.count[i]=mod;
         System.out.println("\nDetail Modified Successfully ");
         System.out.println("Modify Another Detail (Yes/No) : ");
         String op=sc.next();
         if(op.equals("yes")) {
        	 modopt(i);
         }else {
        	 adminoptions.main(null);
         }}
     case 4 ->{
    	 System.out.println("\nTravelled Distance : "+obj.tdi[i]);
         System.out.println("Have you Serviced The Vehicle (Yes/No):");
         String opt=sc.next();
         if(opt.equals("yes")) {
        	 obj.tdi[i]=0;
        	 System.out.println("\nDetail Modified Successfully ");
         }else {
        	 modopt(i);
         }
         System.out.println("Modify Another Detail (Yes/No) : ");
         String op=sc.next();
         if(op.equals("yes")) {
        	 modopt(i);
         }else {
        	 adminoptions.main(null);
         }
     }
     }}
  
  
  public static void reve() {
	    Database obj = new Database();
	    Scanner sc = new Scanner(System.in);
	    System.out.println("\nEnter Username :");
	    String un = sc.next();
	    int k = getUserIndex(obj, un);
	    if (k == -1) {
	        System.out.println("Username not found.");
	        return;
	    }
	    displayUserInfo(obj, k);
	    System.out.println("\nEnter Registration Number :");
	    String reg = sc.next();
	    int[] rentInfo = getRentInfo(obj, k, reg);
	    if (rentInfo[0] == -1) {
	        System.out.println("\nWrong Registration Number!");
	        adminoptions.main(null);
	        return;
	    }
	    int t = rentInfo[0];
	    int n = rentInfo[1];
	    displayVehicleInfo(obj, t, k, n);
	    System.out.println("\nEnter the Day of Return :");
	    int dr = sc.nextInt();
	    System.out.println("Enter KM's Travelled :");
	    int km = sc.nextInt();
	    System.out.println("Enter Damage Level :");
	    String dmg = sc.next();
	    float refida = calculateDaysExceededFine(dr, obj.days[k][n], obj.rpi[t]);
	    float refikm = calculateKmsExceededFine(km, obj.days[k][n], obj.rpi[t], obj.vty[t]);
	    float refidmg = calculateDamageFine(dmg, obj.rpi[t],obj.days[k][n]);
	    updateVehicleInfo(obj, t, km);
	    displayBillDetails(refida, refikm, refidmg,k,n,km,t);
	}

	
	public static int getUserIndex(Database obj, String un) {
	    for (int i = 0; i < obj.username.length; i++) {
	        if (un.equals(obj.username[i])) {
	            return i;
	        }
	    }
	    return -1;
	}

	
	public static void displayUserInfo(Database obj, int k) {
	    System.out.println("\nUser Info :");
	    System.out.println("\nUsername : " + obj.username[k]);
	    System.out.println("Rented Vehicle Count : " + obj.rcount[k]);
	    System.out.println("Last Rented Vehicle : " + obj.lastrent[k]);
	    System.out.println("Deposit Amount : " + obj.dep[k]);
	}

	
	public static int[] getRentInfo(Database obj, int k, String reg) {
	    int[] result = {-1, -1}; 
	    for (int j = 0; j < obj.renthistory[k].length; j++) {
	        if (reg.equals(obj.renthistory[k][j])) {
	            result[0] = getVehicleIndex(obj, reg);
	            result[1] = j;
	            break;
	        }
	    }
	    return result;
	}

	
	public static int getVehicleIndex(Database obj, String reg) {
	    for (int i = 0; i < obj.nop.length; i++) {
	        if (reg.equals(obj.nop[i])) {
	            return i;
	        }
	    }
	    return -1;
	}

	
	public static void displayVehicleInfo(Database obj, int t, int k, int n) {
	    System.out.println("\nVehicle Info :");
	    System.out.println("\nVehicle Id : " + obj.idi[t]);
	    System.out.println("Vehicle Type : " + obj.vty[t]);
	    System.out.println("Vehicle Registration Number : " + obj.nop[t]);
	    System.out.println("Vehicle Brand : " + obj.br[t]);
	    System.out.println("Vehicle Model : " + obj.mo[t]);
	    System.out.println("Rental Price : " + obj.rpi[t]);
	    System.out.println("Travelled Distance : " + obj.tdi[t]);
	    System.out.println("Rented Days : " + obj.days[k][n]);
	}

	
	public static float calculateDaysExceededFine(int dr, int q, float rentalPrice) {
	    if (dr > q) {
	        System.out.printf("\nYou have returned your vehicle %d days late", dr - q);
	        System.out.println("\nSo 10% of rental price will be charged!");
	        return (10 / 100.0f) * (rentalPrice*q);
	    }
	    return 0;
	}

	
	public static float calculateKmsExceededFine(int km, int q, float rentalPrice, String vehicleType) {
	    float kmPerDay = km / (float) q;
	    if (kmPerDay > 500.00) {
	        System.out.printf("\nYou have travelled %.2f KM's per day, which is out of limit", kmPerDay);
	        System.out.println("\nSo 15% of rental price will be charged!");
	        return (15 / 100.0f) * (rentalPrice*q);
	    }
	    return 0;
	}

	
	public static float calculateDamageFine(String dmg, float rentalPrice,int q) {
	    float fine = 0;
	    switch (dmg.toLowerCase()) {
	        case "high":
	            fine = (75 / 100.0f) * (rentalPrice*q);
	            break;
	        case "medium":
	            fine = (50 / 100.0f) * (rentalPrice*q);
	            break;
	        case "low":
	            fine = (25 / 100.0f) * (rentalPrice*q);
	            break;
	        case "no":
	            fine = 0;
	            break;
	        default:
	            System.out.println("Invalid damage level.");
	    }
	    if (fine > 0) {
	        System.out.printf("Vehicle damages are %s. So %.2f%% of rental price will be charged!\n", dmg, fine / (rentalPrice*q) * 100);
	    }
	    return fine;
	}

	
	public static void updateVehicleInfo(Database obj, int t, int km) {
	    if ((obj.vty[t].equals("car") && km > 3000) || (obj.vty[t].equals("bike") && km > 1500)) {
	        obj.tdi[t] += km;
	        obj.av[t] = false;
	    }
	}

	
	public static void displayBillDetails(float refida, float refikm, float refidmg, int k, int n, int km, int t) {
		float tot=refida + refikm + refidmg;
	    System.out.println("\nBill Details :");
	    System.out.println("\nDays Exceeded Fine   : " + refida);
	    System.out.println("KM Exceeded Fine : " + refikm);
	    System.out.println("Damage Fine       : " + refidmg);
	    System.out.println("-----------------------------");
	    System.out.println("Total             : " + tot);
	    System.out.println("-----------------------------");
	    payment(tot,k,n,km,t);
	    
	}
	public static int[][] deleteElementInRowint(int[][] array, int row, int col) {
	    if (row < 0 || row >= array.length || col < 0 || col >= array[row].length) {
	        System.out.println("Invalid row or column index");
	        return array; 
	    }
	    int[][] newArray = new int[array.length][];
	    for (int i = 0; i < array.length; i++) {
	        if (i != row) {
	            newArray[i] = array[i];  
	        } else {
	            newArray[i] = new int[array[i].length - 1];
	            for (int j = 0; j < col; j++) {
	                newArray[i][j] = array[i][j];
	            }
	            for (int j = col; j < newArray[i].length; j++) {
	                newArray[i][j] = array[i][j + 1];
	            }
	        }
	    }
	    return newArray;
	}
	
	public static String[][] deleteElementInRowstr(String[][] array, int row, int col) {
	    if (row < 0 || row >= array.length || col < 0 || col >= array[row].length) {
	        System.out.println("Invalid row or column index");
	        return array;  
	    }
	    String[][] newArray = new String[array.length][];
	    for (int i = 0; i < array.length; i++) {
	        if (i != row) {
	            newArray[i] = array[i]; 
	        } else {
	        	newArray[i] = new String[array[i].length - 1];
	            for (int j = 0; j < col; j++) {
	                newArray[i][j] = array[i][j];
	            }
	            for (int j = col; j < newArray[i].length; j++) {
	                newArray[i][j] = array[i][j + 1];
	            }
	        }
	    }
	    return newArray;
	}
	public static String[] addp(int length, String[] pass2, String pas) {
		String newarr[]=new String[length+1];
		for (int i = 0; i < length; i++) 
	    newarr[i] = pass2[i]; 
	    newarr[length] = pas; 
	    return newarr;
	}
public static void payment(float tot, int k, int n, int km, int t) {
	Database obj=new Database();
    Scanner sc = new Scanner(System.in);
	System.out.println("\nSelect Option :");
	System.out.println("\n1. Card Payment");
	System.out.println("2. Cash Payment");
	System.out.println("3. Reduce from Security Deposit");
	System.out.println("4. Cancel Payment");
	System.out.print("\nEnter Option :");
	int in=sc.nextInt();
	if(in==1) {
		System.out.print("\nEnter Card Number :");
		long cardnum=sc.nextLong();
		System.out.print("Enter Pin Number :");
		int pinnum=sc.nextInt();
		System.out.print("\nPayment Successful !\n");
		obj.days=deleteElementInRowint(obj.days,k,n);
		obj.renthistory=deleteElementInRowstr(obj.renthistory,k,n);
		obj.rcount[k]=obj.rcount[k]-1;
		if(obj.lastrent[k].equals(obj.nop[t])) {
			obj.lastrent[k]="No One";
		}
		if(obj.vty[t].equals("bike")) {
			if(km>=1500 || (obj.tdi[t]+km)>=1500) {
				obj.serviced=addp(obj.serviced.length,obj.serviced,obj.nop[t]);
				if(obj.count[t]>=1) {
					obj.av[t]=true;
				}
			}else if (km<1500 && (obj.tdi[t]+km)<1500){
				if (obj.count[t]==0) {
					obj.count[t]++;
					obj.av[t]=true;
				}else {
					obj.count[t]++;
				}
			}
		}
		if(obj.vty[t].equals("car")) {
			if(km>=3000 || (obj.tdi[t]+km)>=3000) {
				obj.serviced=addp(obj.serviced.length,obj.serviced,obj.nop[t]);
			}else if (km<3000){
				if (obj.count[t]==0) {
					obj.count[t]++;
					obj.av[t]=true;
				}else {
					obj.count[t]++;
				}
			}
		}
		adminoptions.main(null);
}else if(in==2) {
	System.out.print("\nThe cash to be paid :"+tot);
	System.out.print("Paid ? (Yes/No) :");
	String pa=sc.next();
	if (pa.equals("yes")){
		System.out.print("\nPayment Successful !\n");
		obj.days=deleteElementInRowint(obj.days,k,n);
		obj.renthistory=deleteElementInRowstr(obj.renthistory,k,n);
		obj.rcount[k]=obj.rcount[k]-1;
		if(obj.lastrent[k].equals(obj.nop[t])) {
			obj.lastrent[k]="No One";
		}
		if(obj.vty[t].equals("bike")) {
			if(km>=1500 || (obj.tdi[t]+km)>=1500) {
				obj.serviced=addp(obj.serviced.length,obj.serviced,obj.nop[t]);
				if(obj.count[t]>=1) {
					obj.av[t]=true;
				}
			}else if (km<1500 && (obj.tdi[t]+km)<1500){
				if (obj.count[t]==0) {
					obj.count[t]++;
					obj.av[t]=true;
				}else {
					obj.count[t]++;
				}
			}
		}
		if(obj.vty[t].equals("car")) {
			if(km>=3000 || (obj.tdi[t]+km)>=3000) {
				obj.serviced=addp(obj.serviced.length,obj.serviced,obj.nop[t]);
			}else if (km<3000){
				if (obj.count[t]==0) {
					obj.count[t]++;
					obj.av[t]=true;
				}else {
					obj.count[t]++;
				}
			}
		}
		
		adminoptions.main(null);
	}else {
		System.out.print("\nPayment Cancelled !\n");
		adminoptions.main(null);
	}
	}else if(in==3) {
		System.out.print("\nThe Amount to be Reduced :"+tot);
		System.out.println("\nConfirm (Yes/No) :");
		String pa=sc.next();
		if (pa.equals("yes")){
			if (obj.dep[k]>=tot) {
			System.out.print("\nPayment Successful !\n");
			obj.dep[k]-=tot;
			obj.days=deleteElementInRowint(obj.days,k,n);
			obj.renthistory=deleteElementInRowstr(obj.renthistory,k,n);
			obj.rcount[k]=obj.rcount[k]-1;
			if(obj.lastrent[k].equals(obj.nop[t])) {
				obj.lastrent[k]="No One";
			}
			if(obj.vty[t].equals("bike")) {
				if(km>=1500 || (obj.tdi[t]+km)>=1500) {
					obj.serviced=addp(obj.serviced.length,obj.serviced,obj.nop[t]);
					if(obj.count[t]>=1) {
						obj.av[t]=true;
					}
				}else if (km<1500 && (obj.tdi[t]+km)<1500){
					if (obj.count[t]==0) {
						obj.count[t]++;
						obj.av[t]=true;
					}else {
						obj.count[t]++;
					}
				}
			}
			if(obj.vty[t].equals("car")) {
				if(km>=3000 || (obj.tdi[t]+km)>=3000) {
					obj.serviced=addp(obj.serviced.length,obj.serviced,obj.nop[t]);
				}else if (km<3000){
					if (obj.count[t]==0) {
						obj.count[t]++;
						obj.av[t]=true;
					}else {
						obj.count[t]++;
					}
				}
			}
			adminoptions.main(null);
			}
			else {
				System.out.printf("\nInsufficient Balance ! %s\n",obj.username[k]);
				adminoptions.main(null);
			}
		}else {
			System.out.print("\nPayment Cancelled !\n");
			adminoptions.main(null);
		}

	}
else if(in==4) {
	System.out.print("\nPayment Cancelled !\n");
	adminoptions.main(null);
}
	
}

public static void rrv() {
	Database obj=new Database();
	System.out.print("\nReturn Request's :\n\n");
	System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s ", 
            "S.NO", "UserName", "RegNo", "DOR", "KM's","Dmg Lvl", "Contact no");
    System.out.println("\n-------------------------------------------------------------------------------------------------------------");
    for (int i =0 ;i<obj.Returnrequest.length;i++) {
    	if(obj.Returnrequest.length!=0 && obj.Returnrequest[i].length!=0) {
    	
    		System.out.printf("%-15s %-15s %-15s %-15s %-15s %-15s %-15s "
    				,i+1,obj.username[i], obj.Returnrequest[i][0],obj.Returnrequest[i][1],obj.Returnrequest[i][2],obj.Returnrequest[i][3],obj.Returnrequest[i][4]);
    	}
    }
    adminoptions.main(null);
    


}

}
