cd ../producer && mvn clean package -DskipTests && cd ../docker
cd ../consumer && mvn clean package -DskipTests && cd ../docker

docker-compose up -d
docker-compose logs -f