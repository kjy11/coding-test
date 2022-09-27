package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_43238Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int n, int[] times, long expected) {
        Lessons_43238 test = new Lessons_43238();
        assertEquals(expected, test.solution(n, times));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(6, new int[] {7, 10}, 28)
        );
    }


}