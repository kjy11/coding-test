package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_42860Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(String name, int expected) {
        Lessons_42860 test = new Lessons_42860();
        assertEquals(expected, test.solution(name));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of("JEROEN", 56),
            Arguments.of("JAN", 23),
            Arguments.of("BBABBBBAAAAAAAB", 15),
            Arguments.of("AAB", 2),
            Arguments.of("AAABBBABA", 10)
        );
    }
}