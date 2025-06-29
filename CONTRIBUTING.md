# Contributing to Microservices Project

Thank you for your interest in contributing to our microservices project! This guide will help you get started.

## 📋 Prerequisites

- Java 21+
- Maven 3.6+
- Docker & Docker Compose
- Git

## 🚀 Development Setup

### 1. Fork and Clone

```bash
git clone https://github.com/yourusername/shyngysCodes.git
cd shyngysCodes
```

### 2. Start Development Environment

```bash
./scripts/start-dev.sh
```

### 3. Create Feature Branch

```bash
git checkout -b feature/your-feature-name
```

## 🏗️ Project Structure

- `customers/` - Customer management microservice
- `docker/` - Docker configuration files
- `scripts/` - Development and deployment scripts
- `pom.xml` - Parent Maven configuration

## 🧪 Testing Guidelines

### Before Submitting

1. **Run Tests**
   ```bash
   mvn clean test
   ```

2. **Test API Endpoints**
   ```bash
   curl http://localhost:8080/api/v1/customers
   ```

3. **Check Code Style**
   ```bash
   mvn checkstyle:check
   ```

## 📝 Commit Guidelines

### Commit Message Format

```
<type>(<scope>): <subject>

<body>

<footer>
```

### Types

- **feat**: New feature
- **fix**: Bug fix
- **docs**: Documentation only changes
- **style**: Code style changes (formatting, etc.)
- **refactor**: Code refactoring
- **test**: Adding or updating tests
- **chore**: Maintenance tasks

### Examples

```bash
git commit -m "feat(customers): add email validation to customer creation"
git commit -m "fix(database): resolve connection pool timeout issue"
git commit -m "docs(readme): update API documentation"
```

## 🔀 Branch Strategy

- `main` - Production-ready code
- `develop` - Integration branch
- `feature/*` - Feature development
- `hotfix/*` - Critical fixes

## 📋 Pull Request Process

1. **Create Feature Branch**
   ```bash
   git checkout -b feature/your-feature
   ```

2. **Make Changes**
   - Follow coding standards
   - Add tests for new features
   - Update documentation

3. **Test Your Changes**
   ```bash
   mvn clean test
   ./scripts/start-dev.sh
   # Test API endpoints
   ```

4. **Commit Changes**
   ```bash
   git add .
   git commit -m "feat(scope): description"
   ```

5. **Push and Create PR**
   ```bash
   git push origin feature/your-feature
   # Create PR on GitHub
   ```

## 🎯 Coding Standards

### Java Code Style

- Use **4 spaces** for indentation
- Maximum line length: **120 characters**
- Use **camelCase** for variables and methods
- Use **PascalCase** for classes
- Add **Javadoc** for public methods

### Spring Boot Best Practices

- Use **@RestController** for REST endpoints
- Implement proper **exception handling**
- Use **@Valid** for request validation
- Follow **SOLID principles**

### Database Guidelines

- Use **meaningful table names**
- Add proper **indexes**
- Include **foreign key constraints**
- Use **snake_case** for column names

## 🐳 Docker Guidelines

- Keep **Dockerfiles simple**
- Use **multi-stage builds** when possible
- Don't include **sensitive data** in images
- Use **.dockerignore** effectively

## 🛠️ Adding New Microservices

### 1. Create Module Structure

```bash
mkdir new-service
cd new-service
```

### 2. Create Maven Module

```xml
<parent>
    <groupId>com.demo.shyngys</groupId>
    <artifactId>shyngysCodes</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</parent>
<artifactId>new-service</artifactId>
```

### 3. Add to Parent POM

```xml
<modules>
    <module>customers</module>
    <module>new-service</module>
</modules>
```

### 4. Create Database

Add to `docker/init-scripts/01-init-databases.sql`:
```sql
CREATE DATABASE new_service_db;
```

## 🔍 Code Review Checklist

- [ ] Code follows project conventions
- [ ] Tests are included and passing
- [ ] Documentation is updated
- [ ] No sensitive data in commits
- [ ] API endpoints are tested
- [ ] Database migrations are included
- [ ] Error handling is implemented

## 🐛 Reporting Issues

### Bug Reports

Include:
- **Steps to reproduce**
- **Expected behavior**
- **Actual behavior**
- **Environment details**
- **Error logs**

### Feature Requests

Include:
- **Problem description**
- **Proposed solution**
- **Use cases**
- **Alternative solutions**

## 📞 Getting Help

- Create an **Issue** for bugs
- Use **Discussions** for questions
- Check **existing issues** first
- Provide **minimal reproducible examples**

## 📄 License

By contributing, you agree that your contributions will be licensed under the MIT License.

Thank you for contributing! 🎉 