# Library Management System

This is a simple **Library Management System** built with **Spring Boot**. It uses Object-Oriented Programming (OOP) principles to manage books, members, and borrowing/returning operations. The application operates with in-memory storage (no database).

---

## Features
- **Add/Remove Books**: Admins can manage the book catalog.
- **Add Members**: Register new members to the library.
- **Borrow Books**: Members can borrow available books.
- **Return Books**: Members can return borrowed books.
- **Track Quantity**: Dynamically tracks the quantity of books.
- **Concurrency Handling**: Prevents race conditions when borrowing the last copy of a book.

---

## Technologies Used
- **Java** 
- **Spring Boot**
- **In-Memory Data Storage**


---

## Installation and Usage
1. Clone the repository:
   ```bash
   git clone <repository-url>
   cd library-management-system

2. Run the project
  ```bash
  mvn spring-boot:run


