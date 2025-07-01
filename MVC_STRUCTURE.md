# MVC Structure Documentation

## Struktur Folder MVC yang Telah Dibuat

Struktur folder MVC berikut telah dibuat dalam proyek Spring Boot ini:

```
src/main/java/com/example/demo/
├── TryApplication.java          # Main Application Class
├── controller/                  # Controller Layer (Presentation Layer)
│   ├── UserController.java     # REST Controller untuk User operations
│   └── GlobalExceptionHandler.java # Global exception handler
├── service/                     # Service Layer (Business Logic Layer)
│   ├── UserService.java        # Interface untuk User business logic
│   └── UserServiceImpl.java    # Implementation dari UserService
├── repository/                  # Repository Layer (Data Access Layer)
│   ├── UserRepository.java     # Interface untuk User data access
│   └── UserRepositoryImpl.java # In-memory implementation
├── model/                       # Model Layer (Entity/Domain Objects)
│   └── User.java               # User entity class
├── dto/                        # Data Transfer Objects
│   └── UserDTO.java            # User DTO for data transfer
└── config/                     # Configuration Classes
    └── WebConfig.java          # Web configuration (CORS, etc.)
```

## Penjelasan Setiap Layer

### 1. **Controller Layer** (`controller/`)

- **Fungsi**: Menangani HTTP requests dan responses
- **File**:
  - `UserController.java`: REST API endpoints untuk operasi CRUD User
  - `GlobalExceptionHandler.java`: Menangani exception secara global
- **Annotations**: `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`, dll.

### 2. **Service Layer** (`service/`)

- **Fungsi**: Berisi business logic aplikasi
- **File**:
  - `UserService.java`: Interface yang mendefinisikan business operations
  - `UserServiceImpl.java`: Implementation dari business logic
- **Annotations**: `@Service`, `@Autowired`

### 3. **Repository Layer** (`repository/`)

- **Fungsi**: Menangani akses data (CRUD operations)
- **File**:
  - `UserRepository.java`: Interface untuk data access operations
  - `UserRepositoryImpl.java`: In-memory implementation (untuk demo)
- **Annotations**: `@Repository`

### 4. **Model Layer** (`model/`)

- **Fungsi**: Mendefinisikan struktur data/entity
- **File**: `User.java`: Entity class yang merepresentasikan User
- **Annotations**: Bisa ditambahkan JPA annotations jika menggunakan database

### 5. **DTO Layer** (`dto/`)

- **Fungsi**: Data Transfer Objects untuk transfer data antar layer
- **File**: `UserDTO.java`: DTO untuk User data transfer

### 6. **Config Layer** (`config/`)

- **Fungsi**: Configuration classes untuk aplikasi
- **File**: `WebConfig.java`: Konfigurasi web (CORS, interceptors, dll.)
- **Annotations**: `@Configuration`

## API Endpoints yang Tersedia

Setelah menjalankan aplikasi, Anda dapat mengakses endpoints berikut:

- `GET /api/users` - Mendapatkan semua users
- `GET /api/users/{id}` - Mendapatkan user berdasarkan ID
- `GET /api/users/email/{email}` - Mendapatkan user berdasarkan email
- `POST /api/users` - Membuat user baru
- `PUT /api/users/{id}` - Update user
- `DELETE /api/users/{id}` - Hapus user

## Cara Menjalankan

1. Buka terminal di root folder proyek
2. Jalankan command: `./mvnw spring-boot:run` (Linux/Mac) atau `mvnw.cmd spring-boot:run` (Windows)
3. Aplikasi akan berjalan di `http://localhost:8080`

## Testing API

Anda bisa test API menggunakan tools seperti:

- Postman
- cURL
- Browser (untuk GET requests)

Contoh data user yang sudah ada:

- User 1: John Doe (john@example.com)
- User 2: Jane Smith (jane@example.com)

## Keuntungan Struktur MVC

1. **Separation of Concerns**: Setiap layer memiliki tanggung jawab yang jelas
2. **Maintainability**: Mudah untuk maintain dan update code
3. **Testability**: Setiap layer dapat di-test secara terpisah
4. **Scalability**: Mudah untuk menambah fitur baru
5. **Reusability**: Business logic dapat digunakan oleh berbagai controller
