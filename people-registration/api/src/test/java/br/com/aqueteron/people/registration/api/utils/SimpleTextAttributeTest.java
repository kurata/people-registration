package br.com.aqueteron.people.registration.api.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTextAttributeTest {

    static Stream<String> validAlphabetStringProvider() {
        return Stream.of(
                "Augusto",
                "Carlos Alberto",
                "José Maria",
                "Nelson D'Avilla",
                "Ávro",
                "João"
        );
    }

    @ParameterizedTest
    @MethodSource("validAlphabetStringProvider")
    void testValidAlphabetString(final String alphabet) {
        SimpleTextAttribute simpleTextAttributeObj = new SimpleTextAttribute(alphabet);
        assertNotNull(simpleTextAttributeObj);
    }

    static Stream<String> invalidAlphabetStringProvider() {
        return Stream.of(
                "&cia",
                "band-aid");
    }

    @ParameterizedTest
    @MethodSource("invalidAlphabetStringProvider")
    void testInvalidAlphabetString(final String alphabet) {
        assertThrows(IllegalArgumentException.class, () -> new SimpleTextAttribute(alphabet));
    }

}
