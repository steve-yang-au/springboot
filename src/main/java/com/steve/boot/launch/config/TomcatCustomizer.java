package com.steve.boot.launch.config;


import org.springframework.context.annotation.Configuration;

@Configuration
public class TomcatCustomizer {
//    @Value("${server.http-port}")
//    private int httpPort;
//    @Value("${server.port}")
//    private int httpsPort;
//
//    @Bean
//    public ConfigurableServletWebServerFactory configurableServletWebServerFactory(){
//        TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory(){
//            @Override
//            protected void postProcessContext(Context context) {
//                SecurityConstraint constraint = new SecurityConstraint();
//                constraint.setUserConstraint("CONFIDENTIAL");
//
//                SecurityCollection collection = new SecurityCollection();
//                collection.addPattern("/*");
//                constraint.addCollection(collection);
//                context.addConstraint(constraint);
//            }
//        };
//        factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
//            @Override
//            public void customize(Connector connector) {
//                connector.setPort(Integer.parseInt("8888"));
//                connector.setProperty("maxConnections", "8192");
//            }
//        });
//
//        factory.addAdditionalTomcatConnectors(connector());
//        return factory;
//    }
//
//    public Connector connector(){
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setScheme("http");
//        connector.setPort(httpPort);
//        connector.setSecure(false);
//        connector.setRedirectPort(httpsPort);
//        return connector;

//    }
}
