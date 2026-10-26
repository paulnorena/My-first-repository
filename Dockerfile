
FROM eclipse-temurin:24-jdk

RUN apt-get update \
    && apt-get install -y ant \
    && rm -rf /var/lib/apt/lists/*

WORKDIR /app

COPY . .

RUN ant clean jar

RUN mkdir -p /data \
    && if [ -f /app/biblioteca.dat ]; then \
        cp /app/biblioteca.dat /data/biblioteca.dat; \
    fi

WORKDIR /data

CMD ["java", "-cp", "/app/dist/ProyectoDesarrollo.jar", "Clasees.ProyectoDesarrollo"]
