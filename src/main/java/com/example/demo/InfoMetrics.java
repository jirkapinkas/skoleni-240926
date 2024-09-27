package com.example.demo;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.util.Map;

@Component
public class InfoMetrics {

    private final InfoEndpoint infoEndpoint;
    private final MeterRegistry meterRegistry;
    private String appVersion;

    public InfoMetrics(InfoEndpoint infoEndpoint, MeterRegistry meterRegistry) {
        this.infoEndpoint = infoEndpoint;
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void registerMetrics() {
        // Fetch info from the /info endpoint
        Map<String, Object> infoMap = infoEndpoint.info();

        if (infoMap.containsKey("build")) {
            Map<String, Object> buildInfo = (Map<String, Object>) infoMap.get("build");
            if (buildInfo.containsKey("version")) {
                appVersion = (String) buildInfo.get("version");
            }
        }

        // Expose the version as a Prometheus gauge metric
        Gauge.builder("app_info_version", () -> 1)
            .description("Application version")
            .tags("version", appVersion)
            .register(meterRegistry);
    }
}