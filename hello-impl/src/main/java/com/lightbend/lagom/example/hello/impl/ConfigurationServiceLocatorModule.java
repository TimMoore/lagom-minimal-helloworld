package com.lightbend.lagom.example.hello.impl;

import com.google.inject.AbstractModule;
import com.lightbend.lagom.javadsl.api.ServiceLocator;
import com.lightbend.lagom.javadsl.client.ConfigurationServiceLocator;
import com.typesafe.config.Config;
import play.Environment;

public class ConfigurationServiceLocatorModule extends AbstractModule {

    private final Environment environment;

    public ConfigurationServiceLocatorModule(Environment environment, @SuppressWarnings("unused") Config config) {
        this.environment = environment;
    }

    @Override
    protected void configure() {
        if (environment.isProd()) {
            bind(ServiceLocator.class).to(ConfigurationServiceLocator.class);
        }
    }
}
