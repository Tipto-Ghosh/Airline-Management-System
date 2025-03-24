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

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/Airline-Ticket-Management.git
