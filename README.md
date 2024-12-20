Vehicle Rental System

Overview

The Vehicle Rental System is a console-based Java application designed for vehicle rental management. It includes separate functionality for two types of users: Admin and Borrower. Admins can manage the vehicle inventory and rental operations, while borrowers can sign up, rent vehicles, and manage their rentals.

Features

- Admin Features

  - View All Vehicles: Display all registered vehicles in the system.
  - Search Vehicle: Search for a specific vehicle using filters or IDs.
  - View Customer Details: Display details of registered borrowers.
  - Vehicles Due for Service: Identify vehicles that need servicing.
  - View Rented and Non-Rented Vehicles: Distinguish between rented and available vehicles.
  - Add Vehicle: Add a new vehicle to the system.
  - Delete Vehicle: Remove an existing vehicle from the system.
  - Modify Vehicle Details: Update the details of any vehicle.
  - Return Request View: View pending requests from borrowers to return vehicles.
  - Return a Vehicle: Process a vehicle return request.
  - Log Out: Exit the admin session.

- Borrower Features

  - Sign Up:
     - Create a new account with an initial deposit of 30,000.
     - Gain access to all Sign-In Features.

  - Sign In:
     - My Info: View the borrower’s personal and account information.
     - View Available Vehicles: Browse through vehicles available for rent.
     - Rent a Vehicle: Rent a vehicle by selecting from the available options.
     - History of Rentals: View the history of rented vehicles.
     - Add Deposit: Add funds to the borrower’s account.
     - Return Request: Request to return a rented vehicle.
     - Log Out: Exit the borrower session.

Technologies Used

- Java: Core programming language for business logic and application flow.

How It Works

- Admin Workflow:

  - Login with admin credentials.
  - Manage vehicles, customer details, and rental operations through the available options.
  - Log out after completing the tasks.

- Borrower Workflow:

  - Sign up with basic details and an initial deposit.
  - Log in to the system to access features like renting vehicles, viewing history, and returning vehicles.
  - Log out when done.

Getting Started

  - Clone the Repository
    
         https://github.com/Sanjay-2k-5/Vehicle-Rental-System.git
         cd vehicleRentalSystem/src/LoginAndDB

  - Compile and Run the Application

     - Use a Java IDE or command line to compile and run the application:

           javac login.java
           java login
	
Contributing

Contributions are welcome! Fork the repository and submit a pull request with your improvements.
