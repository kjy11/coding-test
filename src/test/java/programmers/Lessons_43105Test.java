package programmers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_43105Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int[][] triangle, int expected) {
        Lessons_43105 test = new Lessons_43105();
        assertEquals(expected, test.solution(triangle));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}}, 30)
        );
    }
}