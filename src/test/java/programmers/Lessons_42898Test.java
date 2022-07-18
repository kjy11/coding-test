package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_42898Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int m, int n, int[][] puddles, int expected) {
        Lessons_42898 test = new Lessons_42898();
        assertEquals(expected, test.solution(m, n, puddles));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(4, 3, new int[][] {{2, 2}}, 4)
        );
    }
}