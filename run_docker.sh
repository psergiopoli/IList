./gradlew build
docker-compose down
docker-compose build
docker-compose up -d
docker-compose logs -f