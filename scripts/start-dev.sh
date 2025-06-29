#!/bin/bash

echo "🚀 Starting Microservices Development Environment..."

# Start Docker services
echo "📦 Starting Docker services (PostgreSQL + pgAdmin)..."
docker-compose up -d

# Wait for PostgreSQL to be ready
echo "⏳ Waiting for PostgreSQL to be ready..."
timeout=60
elapsed=0
while ! docker exec postgres-db pg_isready -U admin -d microservices_db > /dev/null 2>&1; do
    if [ $elapsed -ge $timeout ]; then
        echo "❌ PostgreSQL startup timeout!"
        exit 1
    fi
    sleep 2
    elapsed=$((elapsed + 2))
    echo "   Still waiting... ($elapsed/$timeout seconds)"
done

echo "✅ PostgreSQL is ready!"

# Show service status
echo "📊 Service Status:"
docker-compose ps

echo ""
echo "🎉 Development environment is ready!"
echo ""
echo "📋 Available Services:"
echo "   PostgreSQL: localhost:5432"
echo "   pgAdmin:    http://localhost:5050 (admin@admin.com / admin123)"
echo ""
echo "🗄️ Available Databases:"
echo "   - customers_db"
echo "   - orders_db" 
echo "   - products_db"
echo ""
echo "🚀 Start your microservices:"
echo "   cd customers && mvn spring-boot:run"
echo "" 