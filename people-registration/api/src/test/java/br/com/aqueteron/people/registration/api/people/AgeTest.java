package br.com.aqueteron.people.registration.api.people;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class AgeTest {

    static Stream<Integer> invalidAgeIntegerProvider() {
        return Stream.of(
                -1,
                0,
                101,
                150
        );
    }

    @ParameterizedTest
    @MethodSource("invalidAgeIntegerProvider")
    void testInvalidAgeInteger(Integer age) {
        assertThrows(IllegalArgumentException.class, () -> new Age(age));
    }


}
