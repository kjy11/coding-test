package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_1843Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(String[] arr, int expected) {
        Lessons_1843 test = new Lessons_1843();
        assertEquals(expected, test.solution(arr));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(new String[] {"1", "-", "3", "+", "5", "-", "8"}, 1),
            Arguments.of(new String[] {"5", "-", "3", "+", "1", "+", "2", "-", "4"}, 3)
        );
    }
}