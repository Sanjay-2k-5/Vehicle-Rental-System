Vehicle Rental System

Overview

The Vehicle Rental System is a console-based Java application designed for vehicle rental management. It includes separate functionality for two types of users: Admin and Borrower. Admins can manage the vehicle inventory and rental operations, while borrowers can sign up, rent vehicles, and manage their rentals.

Features

Admin Features

	1. View All Vehicles: Display all registered vehicles in the system.
	2. Search Vehicle: Search for a specific vehicle using filters or IDs.
	3. View Customer Details: Display details of registered borrowers.
	4. Vehicles Due for Service: Identify vehicles that need servicing.
	5. View Rented and Non-Rented Vehicles: Distinguish between rented and available vehicles.
	6. Add Vehicle: Add a new vehicle to the system.
	7. Delete Vehicle: Remove an existing vehicle from the system.
	8. Modify Vehicle Details: Update the details of any vehicle.
	9. Return Request View: View pending requests from borrowers to return vehicles.
	10. Return a Vehicle: Process a vehicle return request.
	11. Log Out: Exit the admin session.

Borrower Features

    Sign Up:
	• Create a new account with an initial deposit of 30,000.
     	• Gain access to all Sign-In Features.

    Sign In:
    	1. My Info: View the borrower’s personal and account information.
    	2. View Available Vehicles: Browse through vehicles available for rent.
        3. Rent a Vehicle: Rent a vehicle by selecting from the available options.
	4. History of Rentals: View the history of rented vehicles.
    	5. Add Deposit: Add funds to the borrower’s account.
    	6. Return Request: Request to return a rented vehicle.
    	7. Log Out: Exit the borrower session.

Technologies Used

	• Java: Core programming language for business logic and application flow.
	• File Handling or Database (optional): Used for persistent data storage (add this if implemented).

How It Works

Admin Workflow:

	1. Login with admin credentials.
	2. Manage vehicles, customer details, and rental operations through the available options.
	3. Log out after completing the tasks.

Borrower Workflow:

	1. Sign up with basic details and an initial deposit.
	2. Log in to the system to access features like renting vehicles, viewing history, and returning vehicles.
	3. Log out when done.

Getting Started

    1. Clone the Repository
    
         https://github.com/Sanjay-2k-5/Vehicle-Rental-System.git
         cd vehicleRentalSystem/src/LoginAndDB

    2. Compile and Run the Application

        Use a Java IDE or command line to compile and run the application:

        javac login.java
        java login
	
Contributing

Contributions are welcome! Fork the repository and submit a pull request with your improvements.
