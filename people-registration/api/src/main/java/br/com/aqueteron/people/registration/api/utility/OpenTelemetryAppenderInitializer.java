//package br.com.aqueteron.people.registration.api.utility;
//
//import io.opentelemetry.api.OpenTelemetry;
//import io.opentelemetry.instrumentation.log4j.appender.v2_17.OpenTelemetryAppender;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class OpenTelemetryAppenderInitializer implements InitializingBean {
//
//    private final OpenTelemetry openTelemetry;
//
//    OpenTelemetryAppenderInitializer(OpenTelemetry openTelemetry) {
//        this.openTelemetry = openTelemetry;
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        OpenTelemetryAppender.install(this.openTelemetry);
//    }
//}
