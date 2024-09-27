# mvn clean package
# docker build -t demo-o2-its .

# priklad bez loki
# docker compose -f docker-compose-no-loki.yml up

# priklad + loki
# docker compose up

# nastaveni grafany:
# Pridat datasource typu Prometheus s URL: http://prometheus:9090
# na adrese: http://localhost:3000/connections/datasources

# nastaveni dashboardu jvm (micrometer):
# Pridat dashboard (New -> Import) a pridat ID dashboardu 4701 a vybrat datasource Prometheus
# na adrese: http://localhost:3000/dashboards

# Pro rozchozeni Jaegeru jsem postupoval podle tohoto navodu:
# https://refactorfirst.com/distributed-tracing-with-opentelemetry-jaeger-in-spring-boot