package programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_42584Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int[] prices, int[] expected) {
        Lessons_42584 test = new Lessons_42584();
        assertArrayEquals(expected, test.solution(prices));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(new int[] {1, 2, 3, 2, 3}, new int[] {4, 3, 1, 1, 0})
        );
    }


}