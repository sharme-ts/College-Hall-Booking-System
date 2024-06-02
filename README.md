# College-Hall-Booking-System

## Table of Contents
1. Introduction
2. Features
3. Technologies Used
4. Installation and Setup
5. Database Configuration
6. Usage
7. File Structure
8. Contributing
9. License

## Introduction
The College Hall Booking System is a web application designed to streamline the process of booking college halls for various events. This system allows users to view available halls, make reservations, and manage bookings efficiently.

## Features
- User registration and login
- View available halls and their details
- Book halls for specific dates and times
- View and manage current bookings
- Admin panel for managing halls and reservations
- Responsive design for mobile and desktop users

## Technologies Used
- **Frontend**: HTML, CSS, JavaScript
- **Backend**: Java, JDBC
- **Database**: MySQL
- **Server**: Apache Tomcat

## Installation and Setup
1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/college-hall-booking-system.git
   cd college-hall-booking-system
   ```

2. **Setup Database**
   - Install MySQL server.
   - Create a new database named `hall_booking_system`.
   - Run the provided SQL script (`database.sql`) to create necessary tables.

3. **Configure Database Connection**
   - Open the `config.properties` file located in the `src` directory.
   - Update the following properties with your database credentials:
     ```properties
     db.url=jdbc:mysql://localhost:3306/hall_booking_system
     db.user=root
     db.password=yourpassword
     ```

4. **Build and Deploy**
   - Open the project in your preferred IDE (e.g., IntelliJ, Eclipse).
   - Build the project.
   - Deploy the project to an Apache Tomcat server.

## Database Configuration
1. **Create Database**
   ```sql
   CREATE DATABASE hall_booking_system;
   ```

2. **Create Tables**
   Run the following SQL script to create the necessary tables:
   ```sql
   USE hall_booking_system;

   CREATE TABLE users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       username VARCHAR(50) NOT NULL UNIQUE,
       password VARCHAR(50) NOT NULL,
       email VARCHAR(100) NOT NULL UNIQUE
   );

   CREATE TABLE halls (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100) NOT NULL,
       location VARCHAR(100) NOT NULL,
       capacity INT NOT NULL
   );

   CREATE TABLE bookings (
       id INT AUTO_INCREMENT PRIMARY KEY,
       user_id INT NOT NULL,
       hall_id INT NOT NULL,
       booking_date DATE NOT NULL,
       start_time TIME NOT NULL,
       end_time TIME NOT NULL,
       FOREIGN KEY (user_id) REFERENCES users(id),
       FOREIGN KEY (hall_id) REFERENCES halls(id)
   );
   ```

## Usage
1. **Access the Application**
   - Open your web browser.
   - Navigate to `http://localhost:8080/college-hall-booking-system`.

2. **Register and Login**
   - Register a new account or login with existing credentials.

3. **Book a Hall**
   - Navigate to the "Book a Hall" section.
   - Select a hall, date, and time.
   - Confirm the booking.

4. **Manage Bookings**
   - View your current bookings.
   - Cancel or modify bookings if necessary.

5. **Admin Panel**
   - Access the admin panel to manage halls and bookings.

## File Structure
```
college-hall-booking-system/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── com/
│   │   │   │   └── example/
│   │   │   │       └── controller/
│   │   │   │       └── dao/
│   │   │   │       └── model/
│   │   │   │       └── service/
│   │   ├── resources/
│   │   │   └── config.properties
│   ├── webapp/
│   │   ├── css/
│   │   ├── js/
│   │   ├── WEB-INF/
│   │   │   └── web.xml
│   │   └── index.html
├── database.sql
└── README.md
```

## Contributing
We welcome contributions to improve the College Hall Booking System. To contribute, please follow these steps:
1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push the branch.
4. Create a pull request with a detailed description of your changes.

## License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.

---
