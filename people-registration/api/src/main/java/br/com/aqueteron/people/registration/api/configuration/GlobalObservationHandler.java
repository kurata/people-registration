package br.com.aqueteron.people.registration.api.configuration;

import io.micrometer.common.KeyValue;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Slf4j
@Component
public class GlobalObservationHandler implements ObservationHandler<Observation.Context> {

    @Override
    public void onStop(Observation.Context context) {
        log.info("After running the observation for context [{}], peopleType [{}]", context.getName(), getUserTypeFromContext(context));
        ObservationHandler.super.onStop(context);
    }

    @Override
    public void onStart(Observation.Context context) {
        log.info("Before running the observation for context [{}], peopleType [{}]", context.getName(), getUserTypeFromContext(context));
        ObservationHandler.super.onStart(context);
    }

    @Override
    public boolean supportsContext(Observation.Context context) {
        return true;
    }

    private String getUserTypeFromContext(Observation.Context context) {
        return StreamSupport.stream(context.getLowCardinalityKeyValues().spliterator(), false)
                .filter(keyValue -> "peopleType".equals(keyValue.getKey()))
                .map(KeyValue::getValue)
                .findFirst()
                .orElse("UNKNOWN");
    }
}
