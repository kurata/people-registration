package br.com.aqueteron.people.registration.api.configuration;

import br.com.aqueteron.people.registration.api.exception.BusinessException;
import net.datafaker.Faker;
import net.datafaker.providers.base.Options;
import org.springframework.http.HttpStatus;

public class ExceptionStub {
    public static BusinessException createBusinessException() {
        Faker faker = new Faker();
        Options options = faker.options();
        return new BusinessException(
                options.option(HttpStatus.class),
                "Exception message");
    }

    public static Exception createException() {
        return new Exception("Exception message");
    }

    public static IllegalArgumentException createIllegalArgumentException() {
        return new IllegalArgumentException("IllegalArgumentException message");
    }
}
