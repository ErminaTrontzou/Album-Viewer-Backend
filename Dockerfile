# Stage  1: Build the application
FROM gradle:jdk17 as build
WORKDIR /home/gradle/src
COPY . .
# Ensure the Gradle Wrapper script is executable
#RUN chmod +x ./gradlew
#RUN ./gradlew clean build -x test --no-daemon
RUN gradle clean build -x test --no-daemon

# Stage  2: Setup the runtime environment
FROM eclipse-temurin:17-jdk-alpine
# Copies the built JAR file into a lightweight Java runtime environment.
WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]