FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY . .
RUN apk add --no-cache maven
RUN mvn clean package -DskipTests
CMD ["java", "-jar", "target/music-library-mcp-1.0.0.jar"]