# Airline Ticket Management System

## Overview
The **Airline Ticket Management System** is a Java-based OOP project designed to manage airline ticketing efficiently. It provides role-based access to different types of users: **Authority**, **Employee**, and **Client**. The system ensures a smooth ticket booking and management process, enabling users to view flights, manage profiles, handle payments, and more. The project uses **text file-based data storage** for managing all records.

---

## Features

### Common Features for All Users
- Login
- Logout
- Password recovery
- Profile update
- Password update (for logged-in users)

### Client Features
- Sign up as a new user
- Buy tickets for flights
- Make payments for tickets
- View flight list
- View aeroplane list
- View self-purchased tickets
- View payment history

### Employee Features
- Sell and return tickets
- Accept payments for tickets
- Add, update, remove, and view aeroplane list
- Add, update, remove, and view client list
- Add, update, remove, and view flight list
- View ticket list
- View payment list

### Authority Features
- Add, update, remove, and view employee list
- Add, update, remove, and view client list
- Add, update, remove, and view authority list
- View aeroplane list
- View flight list
- View ticket list
- View payment list

---

## System Entities

### User
- **Attributes:** userId, name, gender, age, email, phoneNo, address, role, securityAns, password

### Authority
- **Additional Attributes:** authorityType

### Employee
- **Additional Attributes:** designation, salary

### Client
- **Additional Attributes:** membershipType

### Aeroplane
- **Attributes:** aeroplaneId, name, category, totalSeat, pricePerSeat, availableSeat, bookedSeat

### Flight
- **Attributes:** flightId, aeroplaneId, fromLocation, toLocation, date, duration

### Ticket
- **Attributes:** ticketId, aeroplaneId, flightId, userId (client), numberOfTicket, totalAmount, paidAmount, dueAmount

### Payment
- **Attributes:** paymentId, ticketId, userId (client), amount, date

---

## Technologies Used
- Programming Language: **Java**
- OOP Concepts: **Inheritance, Polymorphism, Encapsulation, Abstraction**
- IDE: **IntelliJ IDEA**
- Data Storage: **Text File-Based**

---

## Getting Started

### Prerequisites
- Java JDK 17 or higher
- IntelliJ IDEA or any preferred IDE

Here’s a comprehensive guide to set up the project on your local machine, which you can add to your `README.md` file:

---

## Installation Guide

### Prerequisites

Before setting up the project, ensure that you have the following software installed on your local machine:

- **Java JDK 17 or higher**: The project uses Java for development.
  - [Download Java JDK](https://adoptopenjdk.net/)
- **IntelliJ IDEA** (or any preferred Java IDE): To edit, build, and run the project.
  - [Download IntelliJ IDEA](https://www.jetbrains.com/idea/)
  
(Optional: **MySQL Database** if you wish to switch from text file-based data storage to a database system in the future)

### Steps to Set Up the Project

1. **Clone the Repository**

   First, clone the repository from GitHub to your local machine using the following command:
   ```bash
   git clone https://github.com/yourusername/Airline-Ticket-Management.git
   ```
   This will create a copy of the project on your machine.

2. **Navigate to the Project Directory**

   Open your terminal/command prompt and navigate to the project directory:
   ```bash
   cd Airline-Ticket-Management
   ```

3. **Open the Project in Your IDE**

   - Open **IntelliJ IDEA** (or your preferred Java IDE).
   - Click on `File` > `Open`, and select the `Airline-Ticket-Management` folder you just cloned.
   - IntelliJ will automatically detect the project and configure it for you.

4. **Configure Java JDK**

   - In IntelliJ IDEA, ensure that the project is set up to use **Java JDK 17 or higher**.
   - To check or configure the JDK:
     - Go to `File` > `Project Structure` > `Project`.
     - Set the **Project SDK** to JDK 17 or above.

5. **Build the Project**

   - After opening the project, IntelliJ will index the project files.
   - Once the indexing is complete, click on the **Build** menu at the top and select **Build Project** (or press `Ctrl+F9`).
   - IntelliJ will compile the project, and you should see the "Build Successful" message if everything is set up correctly.

6. **Running the Application**

   - Navigate to the `Main.java` file (located in the `src` directory or wherever your `Main` class is located).
   - Right-click on the `Main.java` file and select **Run 'Main.main()'** to start the application.
   
   The application should start, and you will be prompted to log in as one of the users (Authority, Employee, or Client).

7. **Text File Storage**

   - The project uses **text files** for storing and managing data such as user information, tickets, payments, etc.
   - Ensure that the following files are present in the project directory (or create them if necessary):
     - `users.txt`
     - `clients.txt`
     - `employees.txt`
     - `tickets.txt`
     - `payments.txt`
     - Other necessary text files for the project’s functionality.

8. **Make Sure Your Text Files Are Structured Correctly**

   - The text files should be formatted correctly for the application to function.
   - Ensure that all entities such as `User`, `Employee`, `Client`, etc., are saved in the appropriate text file as expected by the program.
   
---

## Troubleshooting

- **Issue:** The application does not run correctly or throws errors during the startup.
  - **Solution:** Ensure that the Java JDK is correctly set up, and verify the `Main.java` class is located properly in the `src` directory.

- **Issue:** Text files are missing or empty.
  - **Solution:** Make sure the necessary text files (`users.txt`, `clients.txt`, etc.) are present in the project directory. If not, create them manually with appropriate content for testing.
