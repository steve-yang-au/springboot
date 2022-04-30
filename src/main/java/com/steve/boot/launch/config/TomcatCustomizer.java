package com.steve.boot.launch.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatCustomizer {
    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory();
        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
            @Override
            public void customize(Connector connector) {
                connector.setPort(Integer.parseInt("8888"));
                connector.setProperty("maxConnections", "8102");
            }
        });
        return factory;
    }
}
