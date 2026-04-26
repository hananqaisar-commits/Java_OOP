FROM eclipse-temurin:17
WORKDIR /app
COPY . .
RUN javac -d out src/*.java
CMD ["java","-cp","out","Tester"]