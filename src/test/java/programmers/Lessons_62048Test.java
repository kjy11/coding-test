package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_62048Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int w, int h, int expected) {
        Lessons_62048 test = new Lessons_62048();
        assertEquals(expected, test.solution(w, h));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(8, 12, 80),
            Arguments.of(2, 3, 2),
            Arguments.of(3, 5, 8),
            Arguments.of(3, 4, 6),
            Arguments.of(4, 3, 6),
            Arguments.of(5, 3, 8),
            Arguments.of(1, 1, 0)
        );
    }
}