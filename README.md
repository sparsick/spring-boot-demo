# Demo
Spring Boot Demo Application

```
mvn clean install
mvn spring:boot run
```

Applikation URL: `http://localhost:8080/customer`

API für Prometheus: `http://localhost:8080/actuator/prometheus`

# Application Monitoring

```
cd application monitoring
docker-compose up
```

fährt Prometheus und Grafana hoch.

Grafana: http://localhost:3000
Username: admin
Passwort: pass

Prometheus: http://localhost:9090