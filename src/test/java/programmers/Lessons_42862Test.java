package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_42862Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int n, int[] lost, int[] reserve, int expected) {
        Lessons_42862 test = new Lessons_42862();
        assertEquals(expected, test.solution(n, lost, reserve));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(5, new int[] {2, 4}, new int[] {1, 3, 5}, 5),
            Arguments.of(3, new int[] {3}, new int[] {1}, 2),
            Arguments.of(5, new int[] {2, 4}, new int[] {3}, 4)
        );
    }
}