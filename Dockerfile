FROM openjdk:15-alpine
WORKDIR /
ADD build/libs/rock_paper_scissors_be.jar rock_paper_scissors_be.jar
CMD ["java", "-jar", "rock_paper_scissors_be.jar", "--port=$PORT"]
