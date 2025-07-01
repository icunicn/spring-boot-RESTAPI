# Spring Boot User Management System

A full-stack web application built with Spring Boot, Thymeleaf, and PostgreSQL for managing user data with both web interface and REST API capabilities.

## 🚀 Features

- **Dual Interface**: Web UI and REST API
- **CRUD Operations**: Create, Read, Update, Delete users
- **Responsive Design**: Bootstrap 5 with mobile-friendly interface
- **Database Integration**: PostgreSQL with JPA/Hibernate
- **Form Validation**: Client and server-side validation
- **Error Handling**: Global exception handling
- **Modern UI**: Card-based layout with confirmation modals

## 🛠️ Technology Stack

- **Backend**: Spring Boot 3.x
- **Frontend**: Thymeleaf, Bootstrap 5, HTML/CSS/JavaScript
- **Database**: PostgreSQL 14+
- **ORM**: JPA/Hibernate
- **Build Tool**: Maven
- **Java Version**: 17+

## 📋 Prerequisites

Before running this application, make sure you have:

- Java 17 or higher
- Maven 3.6+
- PostgreSQL 14+ installed and running
- Git (for cloning the repository)

## 🗄️ Database Setup

### 1. Install PostgreSQL

Download and install PostgreSQL from [official website](https://www.postgresql.org/download/)

### 2. Create Database

Connect to PostgreSQL and create a database:

```sql
-- Connect to PostgreSQL as superuser
psql -U postgres

-- Create database (optional, you can use the default 'postgres' database)
CREATE DATABASE user_management;

-- Create the user table
\c user_management; -- or \c postgres if using default database

CREATE TABLE "user" (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE,
    phone VARCHAR(255)
);

-- Insert sample data (optional)
INSERT INTO "user" (name, email, phone) VALUES 
('John Doe', 'john.doe@example.com', '+1234567890'),
('Jane Smith', 'jane.smith@example.com', '+0987654321'),
('Bob Johnson', 'bob.johnson@example.com', '+1122334455');
```

### 3. Configure Database Connection

Update `src/main/resources/application.properties` with your PostgreSQL credentials:

```properties
# PostgreSQL Database Configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/user_management
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=org.postgresql.Driver

# JPA/Hibernate Configuration
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd try
```

### 2. Build the Project

```bash
# Using Maven wrapper (recommended)
./mvnw clean install

# Or using Maven (if installed globally)
mvn clean install
```

### 3. Run the Application

```bash
# Using Maven wrapper
./mvnw spring-boot:run

# Or using Maven
mvn spring-boot:run

# Or using the batch file (Windows)
run.bat

# Or run the JAR file
java -jar target/try-0.0.1-SNAPSHOT.jar
```

### 4. Access the Application

- **Web Interface**: http://localhost:8080
- **API Documentation**: http://localhost:8080/api/users

## 🌐 API Endpoints

### Web Routes (HTML Pages)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Home page |
| GET | `/users` | Users list page |
| GET | `/users/new` | Add user form |
| GET | `/users/{id}` | User detail page |
| GET | `/users/{id}/edit` | Edit user form |
| POST | `/users` | Create user (form submission) |
| POST | `/users/{id}` | Update user (form submission) |
| POST | `/users/{id}/delete` | Delete user (form submission) |

### REST API Routes (JSON)

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| POST | `/api/users` | Create new user |
| PUT | `/api/users/{id}` | Update user |
| DELETE | `/api/users/{id}` | Delete user |

### API Examples

#### Get All Users
```bash
curl -X GET http://localhost:8080/api/users
```

#### Create New User
```bash
curl -X POST http://localhost:8080/api/users \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Alice Brown",
    "email": "alice.brown@example.com",
    "phone": "+1555666777"
  }'
```

#### Update User
```bash
curl -X PUT http://localhost:8080/api/users/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Updated",
    "email": "john.updated@example.com",
    "phone": "+1999888777"
  }'
```

#### Delete User
```bash
curl -X DELETE http://localhost:8080/api/users/1
```

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── TryApplication.java          # Main application class
│   │   ├── config/
│   │   │   └── WebConfig.java           # Web configuration
│   │   ├── controller/
│   │   │   ├── UserController.java      # REST API controller
│   │   │   ├── WebController.java       # Web controller
│   │   │   ├── DatabaseTestController.java
│   │   │   ├── ErrorController.java     # Error handling
│   │   │   └── GlobalExceptionHandler.java
│   │   ├── dto/
│   │   │   └── UserDTO.java             # Data Transfer Object
│   │   ├── model/
│   │   │   └── User.java                # JPA Entity
│   │   ├── repository/
│   │   │   └── UserRepository.java      # JPA Repository
│   │   └── service/
│   │       ├── UserService.java         # Service interface
│   │       └── UserServiceImpl.java     # Service implementation
│   └── resources/
│       ├── application.properties       # Configuration
│       ├── static/                      # Static resources (CSS, JS)
│       └── templates/                   # Thymeleaf templates
│           ├── layout/
│           │   └── base.html           # Base layout
│           ├── user/
│           │   ├── list.html           # Users list
│           │   ├── form.html           # Add/Edit form
│           │   └── detail.html         # User detail
│           ├── index.html              # Home page
│           └── error.html              # Error page
└── test/
    └── java/com/example/demo/
        └── TryApplicationTests.java     # Unit tests
```

## 🎨 Web Interface Features

- **Responsive Design**: Works on desktop, tablet, and mobile
- **Bootstrap 5**: Modern and clean UI components
- **Form Validation**: Real-time validation with error messages
- **Confirmation Modals**: Safe delete operations
- **Flash Messages**: Success/error notifications
- **Search & Filter**: Easy data management

## 🔧 Configuration

### Database Configuration

The application uses PostgreSQL by default. Key configuration in `application.properties`:

```properties
# Database
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres
spring.datasource.password=root

# JPA Settings
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# Connection Pool
spring.datasource.hikari.maximum-pool-size=20
spring.datasource.hikari.minimum-idle=5
```

### Profile-based Configuration

You can create different profiles for different environments:

- `application-dev.properties` - Development
- `application-prod.properties` - Production
- `application-test.properties` - Testing

Run with specific profile:
```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

## 🧪 Testing

### Run Tests

```bash
# Run all tests
./mvnw test

# Run specific test class
./mvnw test -Dtest=TryApplicationTests
```

### Manual Testing

1. Start the application
2. Open browser and go to http://localhost:8080
3. Test CRUD operations through the web interface
4. Test API endpoints using curl or Postman

## 🚀 Deployment

### Build for Production

```bash
./mvnw clean package -DskipTests
```

### Run Production JAR

```bash
java -jar target/try-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod
```

### Docker Deployment (Optional)

Create `Dockerfile`:

```dockerfile
FROM openjdk:17-jdk-slim
COPY target/try-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
```

Build and run:
```bash
docker build -t user-management .
docker run -p 8080:8080 user-management
```

## 📚 Documentation

- [MVC Structure Documentation](MVC_STRUCTURE.md)
- [Views Documentation](VIEWS_DOCUMENTATION.md)
- [Help Documentation](HELP.md)

## 🛡️ Error Handling

The application includes comprehensive error handling:

- **Global Exception Handler**: Catches and handles all exceptions
- **Custom Error Pages**: User-friendly error messages
- **API Error Responses**: Structured JSON error responses
- **Validation Errors**: Field-level validation with detailed messages

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📝 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 📞 Support

If you encounter any issues:

1. Check the [HELP.md](HELP.md) file
2. Review application logs
3. Verify database connection
4. Check PostgreSQL service status

## 🔍 Troubleshooting

### Common Issues

1. **Database Connection Failed**
   - Verify PostgreSQL is running
   - Check credentials in `application.properties`
   - Ensure database exists

2. **Table Not Found**
   - Make sure the `user` table exists in PostgreSQL
   - Check table name casing (PostgreSQL is case-sensitive)
   - Verify schema configuration

3. **Port Already in Use**
   - Change port in `application.properties`: `server.port=8081`
   - Or stop the process using port 8080

4. **Maven Build Failed**
   - Ensure Java 17+ is installed
   - Check internet connection for dependencies
   - Clear Maven cache: `./mvnw dependency:purge-local-repository`

## 🏆 Achievements

- ✅ Full MVC Architecture
- ✅ RESTful API Design
- ✅ Responsive Web Interface
- ✅ PostgreSQL Integration
- ✅ Form Validation
- ✅ Error Handling
- ✅ Modern UI/UX
- ✅ Production-Ready Code

---

**Happy Coding! 🚀**
