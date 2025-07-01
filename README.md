# Views Layer Documentation

## 📁 Lokasi Folder Views

Dalam proyek Spring Boot ini, **Views** terletak di:

```
src/main/resources/
├── templates/                    # 🎨 VIEWS LAYER (Thymeleaf Templates)
│   ├── layout/                   # Layout templates
│   │   └── base.html            # Base layout template
│   ├── user/                     # User-related views
│   │   ├── list.html            # Users list page
│   │   ├── form.html            # Add/Edit user form
│   │   └── detail.html          # User detail page
│   └── index.html               # Home page
├── static/                       # Static resources (CSS, JS, images)
└── application.properties        # Configuration
```

## 🏗️ Struktur MVC Lengkap

```
📂 Complete MVC Structure:
├── 🎮 CONTROLLER LAYER
│   ├── UserController.java      # REST API Controller (JSON responses)
│   ├── WebController.java       # Web Controller (HTML views)
│   └── GlobalExceptionHandler.java
├── 🏢 SERVICE LAYER
│   ├── UserService.java
│   └── UserServiceImpl.java
├── 🗄️ REPOSITORY LAYER
│   ├── UserRepository.java
│   └── UserRepositoryImpl.java
├── 📊 MODEL LAYER
│   └── User.java
├── 📦 DTO LAYER
│   └── UserDTO.java
├── ⚙️ CONFIG LAYER
│   └── WebConfig.java
└── 🎨 VIEW LAYER
    └── templates/ (HTML templates)
```

## 🎨 Template Engine: Thymeleaf

### Dependencies yang Diperlukan

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

### Template Structure

#### 1. **Base Layout** (`layout/base.html`)

- Template dasar yang digunakan oleh semua halaman
- Berisi navigation, footer, Bootstrap CSS/JS
- Menggunakan Thymeleaf layout dialect

#### 2. **Home Page** (`index.html`)

- Landing page aplikasi
- Menampilkan informasi tentang aplikasi dan API endpoints
- Card-based responsive design

#### 3. **User Views** (`user/`)

- **`list.html`**: Menampilkan daftar semua user dalam tabel
- **`form.html`**: Form untuk add/edit user dengan validasi
- **`detail.html`**: Halaman detail user dengan informasi lengkap

## 🌐 Web Routes vs API Routes

### Web Routes (HTML Pages) - `WebController`

```
GET  /                     → Home page
GET  /users                → Users list page
GET  /users/new            → Add user form
GET  /users/{id}           → User detail page
GET  /users/{id}/edit      → Edit user form
POST /users                → Create user (form submission)
POST /users/{id}           → Update user (form submission)
POST /users/{id}/delete    → Delete user (form submission)
```

### API Routes (JSON Responses) - `UserController`

```
GET    /api/users          → Get all users (JSON)
GET    /api/users/{id}     → Get user by ID (JSON)
POST   /api/users          → Create user (JSON)
PUT    /api/users/{id}     → Update user (JSON)
DELETE /api/users/{id}     → Delete user (JSON)
```

## 🎯 Keunggulan Struktur Views Ini

### 1. **Dual Interface**

- **Web Interface**: HTML pages untuk human interaction
- **API Interface**: JSON responses untuk programmatic access

### 2. **Responsive Design**

- Bootstrap 5 framework
- Mobile-friendly interface
- Modern card-based layout

### 3. **Template Reusability**

- Base layout template untuk konsistensi
- Fragment-based templates
- DRY (Don't Repeat Yourself) principle

### 4. **User Experience Features**

- Form validation (client & server side)
- Success/error messages with flash attributes
- Confirmation modals for delete operations
- Breadcrumb navigation

### 5. **Developer-Friendly**

- Clear separation between web and API controllers
- Proper error handling and redirects
- Easy to extend and maintain

## 🚀 Cara Mengakses Views

1. **Start aplikasi**:

   ```bash
   ./mvnw spring-boot:run
   ```

2. **Akses melalui browser**:

   ```
   http://localhost:8080/           # Home page
   http://localhost:8080/users      # Users list
   http://localhost:8080/users/new  # Add user form
   ```

3. **Test API endpoints**:
   ```
   http://localhost:8080/api/users  # JSON API
   ```

## 📱 Features yang Tersedia

### ✅ User Management

- ➕ Create new users
- 📋 View all users in table
- 👁️ View user details
- ✏️ Edit user information
- 🗑️ Delete users with confirmation

### ✅ UI/UX Features

- 📱 Responsive design
- 🎨 Modern Bootstrap styling
- ✉️ Flash messages for feedback
- 🔍 Search and filter capabilities
- 📊 API response viewer

### ✅ Technical Features

- 🔒 Form validation
- 🌐 CORS support
- 📡 Dual interface (Web + API)
- ⚡ Fast in-memory storage
- 🔧 Easy configuration

## 🔄 Data Flow

```
User Request → WebController → Service → Repository → Database
     ↓               ↓           ↓          ↓
HTML Response ← View Template ← DTO ← Entity ← Data
```

Struktur ini memberikan fleksibilitas untuk menggunakan aplikasi baik sebagai **web application** maupun **REST API service**!
