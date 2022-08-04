package programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_92342Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int n, int[] info, int[] expected) {
        Lessons_92342 test = new Lessons_92342();
        assertArrayEquals(expected, test.solution(n, info));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(5, new int[] {2,1,1,1,0,0,0,0,0,0,0}, new int[] {0,2,2,0,1,0,0,0,0,0,0}),
            Arguments.of(1, new int[] {1,0,0,0,0,0,0,0,0,0,0}, new int[] {-1}),
            Arguments.of(9, new int[] {0,0,1,2,0,1,1,1,1,1,1}, new int[] {1,1,2,0,1,2,2,0,0,0,0}),
            Arguments.of(10, new int[] {0,0,0,0,0,0,0,0,3,4,3}, new int[] {1,1,1,1,1,1,1,1,0,0,2}),
            Arguments.of(2, new int[] {0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0}, new int[] {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0})
        );
    }
}