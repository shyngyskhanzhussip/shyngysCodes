# Docker Setup for Microservices

This Docker Compose setup provides PostgreSQL database and pgAdmin for managing your microservices.

## Services

### PostgreSQL Database
- **Port**: 5432
- **Database**: `microservices_db`
- **Username**: `admin`
- **Password**: `password123`
- **Pre-created databases**: `customers_db`, `orders_db`, `products_db`

### pgAdmin (Database Management UI)
- **Port**: 5050
- **Email**: `admin@admin.com`
- **Password**: `admin123`
- **URL**: http://localhost:5050

## Quick Start

### 1. Start the services
```bash
docker-compose up -d
```

### 2. Check services status
```bash
docker-compose ps
```

### 3. View logs
```bash
docker-compose logs -f
```

### 4. Stop services
```bash
docker-compose down
```

### 5. Remove all data (clean restart)
```bash
docker-compose down -v
```

## Connecting to PostgreSQL

### From Applications
```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/customers_db
    username: admin
    password: password123
```

### From pgAdmin
1. Open http://localhost:5050
2. Login with `admin@admin.com` / `admin123`
3. Add new server:
   - **Name**: `Microservices DB`
   - **Host**: `postgres` (container name)
   - **Port**: `5432`
   - **Database**: `microservices_db`
   - **Username**: `admin`
   - **Password**: `password123`

### Using psql command line
```bash
docker exec -it postgres-db psql -U admin -d customers_db
```

## Available Databases

- `customers_db` - Customer management service
- `orders_db` - Order management service  
- `products_db` - Product catalog service

## Troubleshooting

### Reset database data
```bash
docker-compose down -v
docker-compose up -d
```

### Check PostgreSQL logs
```bash
docker-compose logs postgres
```

### Check pgAdmin logs
```bash
docker-compose logs pgadmin
``` 