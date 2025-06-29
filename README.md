# Microservices Architecture with Spring Cloud

A modern microservices architecture built with Spring Boot, Spring Cloud, PostgreSQL, and Docker.

## 🏗️ Architecture Overview

This project implements a microservices architecture using:

- **Spring Boot 3.5.3** - Application framework
- **Spring Cloud 2025.0.0** - Microservices toolkit  
- **PostgreSQL 15** - Production database
- **Docker Compose** - Development environment
- **pgAdmin** - Database management
- **Maven** - Build and dependency management

## 📁 Project Structure

```
shyngysCodes/                    # Parent module
├── customers/                   # Customer management microservice
├── docker/                      # Docker configuration
├── scripts/                     # Development scripts
├── docker-compose.yml           # Infrastructure setup
├── pom.xml                     # Parent POM
└── README.md                   # This file
```

## 🚀 Quick Start

### Prerequisites

- **Java 21** or higher
- **Docker** and **Docker Compose**
- **Maven 3.6+**

### 1. Clone and Setup

```bash
git clone <repository-url>
cd shyngysCodes
```

### 2. Start Infrastructure

```bash
# Start PostgreSQL and pgAdmin
./scripts/start-dev.sh

# Or manually
docker-compose up -d
```

### 3. Run Microservices

```bash
# Start customers service
cd customers
mvn spring-boot:run -Dspring.profiles.active=dev
```

### 4. Access Services

- **Customers API**: http://localhost:8080/api/v1/customers
- **pgAdmin**: http://localhost:5050 (admin@admin.com / admin123)
- **Health Check**: http://localhost:8080/actuator/health

## 🛠️ Available Services

### Customers Service (Port 8080)

Customer management microservice with full CRUD operations.

**Endpoints:**
- `GET /api/v1/customers` - List all customers
- `GET /api/v1/customers/{id}` - Get customer by ID
- `POST /api/v1/customers` - Create new customer
- `PUT /api/v1/customers/{id}` - Update customer
- `DELETE /api/v1/customers/{id}` - Delete customer

**Sample Request:**
```bash
curl -X POST http://localhost:8080/api/v1/customers \
  -H "Content-Type: application/json" \
  -d '{"firstName":"John","lastName":"Doe","email":"john@example.com","phoneNumber":"+1234567890"}'
```

## 🗄️ Database Configuration

### PostgreSQL (Port 5432)

- **Host**: localhost:5432
- **Database**: customers_db
- **Username**: admin
- **Password**: password123

### pgAdmin (Port 5050)

- **URL**: http://localhost:5050
- **Email**: admin@admin.com
- **Password**: admin123

### Connection Details

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/customers_db
    username: admin
    password: password123
```

## 🐳 Docker Services

The development environment includes:

- **PostgreSQL 15** - Primary database
- **pgAdmin 4** - Database management UI
- **Custom Network** - Isolated microservices network
- **Persistent Volumes** - Data persistence

```bash
# Start all services
docker-compose up -d

# Check status
docker-compose ps

# View logs
docker-compose logs -f

# Stop services
docker-compose down

# Reset data
docker-compose down -v
```

## ⚙️ Development Profiles

### dev (Development)
- Uses PostgreSQL database
- Debug logging enabled
- H2 console disabled

### test (Testing)
- Uses H2 in-memory database
- Optimized for unit tests
- Fast startup

### prod (Production)
- Environment variable configuration
- Minimal logging
- Validation-only DDL

```bash
# Run with specific profile
mvn spring-boot:run -Dspring.profiles.active=dev
```

## 🧪 Testing

### Unit Tests
```bash
mvn test
```

### Integration Tests
```bash
mvn test -Dspring.profiles.active=test
```

### API Testing
```bash
# Health check
curl http://localhost:8080/actuator/health

# Get all customers
curl http://localhost:8080/api/v1/customers
```

## 📊 Monitoring & Health Checks

### Actuator Endpoints

- `/actuator/health` - Application health
- `/actuator/info` - Application information  
- `/actuator/metrics` - Application metrics

### Database Health

```bash
docker exec postgres-db pg_isready -U admin -d customers_db
```

## 🏛️ Architecture Principles

### Microservices Best Practices

- **Single Responsibility** - Each service has one business domain
- **Database per Service** - Isolated data storage
- **API Gateway Ready** - Prepared for service routing
- **Configuration Management** - Environment-based configuration
- **Health Monitoring** - Built-in health checks
- **Container Ready** - Docker-based deployment

### Technology Stack

| Component | Technology | Purpose |
|-----------|------------|---------|
| Framework | Spring Boot 3.5.3 | Application foundation |
| Cloud | Spring Cloud 2025.0.0 | Microservices toolkit |
| Database | PostgreSQL 15 | Data persistence |
| Build Tool | Maven | Dependency management |
| Containerization | Docker | Development environment |
| Database UI | pgAdmin 4 | Database management |

## 🚦 Getting Started Checklist

- [ ] Install Java 21+
- [ ] Install Docker
- [ ] Clone repository
- [ ] Start infrastructure: `./scripts/start-dev.sh`
- [ ] Run customers service: `cd customers && mvn spring-boot:run`
- [ ] Test API: `curl http://localhost:8080/api/v1/customers`
- [ ] Access pgAdmin: http://localhost:5050

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make changes
4. Add tests
5. Submit pull request

## 📝 License

This project is licensed under the MIT License.

## 🔗 Links

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/)
- [Spring Cloud Documentation](https://docs.spring.io/spring-cloud/)
- [Docker Documentation](https://docs.docker.com/)
- [PostgreSQL Documentation](https://www.postgresql.org/docs/) 