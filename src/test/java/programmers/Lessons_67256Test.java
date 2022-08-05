package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_67256Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int[] numbers, String hand, String expected) {
        Lessons_67256 test = new Lessons_67256();
        assertEquals(expected, test.solution(numbers, hand));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(new int[] {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}, "right", "LRLLLRLLRRL"),
            Arguments.of(new int[] {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}, "left", "LRLLRRLLLRR"),
            Arguments.of(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right", "LLRLLRLLRL")
        );
    }
}