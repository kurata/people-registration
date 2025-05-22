FROM amazoncorretto:21

ARG JAR_FILE
ENV MONGO_URL=""
ENV POSTGRESQL_URL=""
ENV POSTGRESQL_USER=""
ENV POSTGRESQL_PASSWORD=""
ENV RABBIT_HOST=""
ENV RABBIT_PORT=""
ENV RABBIT_USER=""
ENV RABBIT_PASSWORD=""
ENV PROFILES="docker"

RUN mkdir people-registration
ADD ${JAR_FILE} /people-registration/people-registration-api.jar
WORKDIR /people-registration
ENTRYPOINT ["/usr/bin/java", "-jar", "people-registration-api.jar"]
