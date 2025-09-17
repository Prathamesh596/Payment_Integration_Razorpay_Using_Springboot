💳 Spring Boot Payment Gateway Integration

A simple Spring Boot project demonstrating integration with Razorpay Payment Gateway. Users can select a course, enter details, and make payments seamlessly.

🚀 Features

Create orders dynamically via Razorpay API

Handle payment success callbacks

Store order details in MySQL database

Responsive UI using Bootstrap 5

Easy integration for future courses or products

📋 Technologies Used

Backend: Java, Spring Boot, Spring Data JPA

Database: MySQL

Frontend: HTML, Bootstrap 5, Razorpay Checkout

Payment Gateway: Razorpay API


razorpay-springboot/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/payintegrate/
│   │   │       ├── RazorpayIntegrationApplication.java   # Main Spring Boot application
│   │   │       ├── controller/
│   │   │       │   └── StudentController.java           # Handles API requests & callbacks
│   │   │       ├── service/
│   │   │       │   └── StudentService.java              # Business logic & Razorpay integration
│   │   │       ├── dto/
│   │   │       │   └── StudentOrder.java                # Data model for orders
│   │   │       └── repo/
│   │   │           └── StudentOrderRepo.java           # JPA repository for orders
│   │   │
│   │   └── resources/
│   │       ├── application.properties                   # Spring Boot config & Razorpay credentials
│   │       ├── templates/
│   │       │   ├── index.html                           # Home page with payment form
│   │       │   └── success.html                         # Payment success page
│   │       └── static/
│   │           ├── css/                                 # Custom styles (optional)
│   │           └── js/                                  # Custom JS (optional)
│   │
└── pom.xml                                              # Maven dependencies & build config


controller/ → Handles HTTP requests (/create-order, /handle-payment-callback)

service/ → Business logic, Razorpay API calls, database updates

dto/ → Entity representing a student order

repo/ → JPA repository for database operations

templates/ → HTML pages served by Spring Boot (index.html, success.html)

static/ → Optional folder for CSS, JS, images

application.properties → Database and Razorpay configuration

pom.xml → Maven build file with dependencies
