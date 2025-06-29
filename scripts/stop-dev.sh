#!/bin/bash

echo "🛑 Stopping Microservices Development Environment..."

# Stop Docker services
docker-compose down

echo "✅ Development environment stopped!"
echo ""
echo "💡 To remove all data and start fresh:"
echo "   docker-compose down -v"
echo "" 