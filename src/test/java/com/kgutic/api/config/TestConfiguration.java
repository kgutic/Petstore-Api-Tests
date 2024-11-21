package com.kgutic.api.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.builder.fluent.Configurations;

@Slf4j
public class TestConfiguration {
    private final Configuration configuration;

    public TestConfiguration() {
        try {
            configuration = new Configurations()
                    .combined(Thread.currentThread().getContextClassLoader().getResource("config.xml"));
        } catch (Exception e) {
            log.error("Failed to setup tests", e);
            throw new IllegalStateException("Cannot load configuration");
        }
    }

    public String getEndpointUrl() {
        return configuration.getString("endpoint.url");
    }
}
