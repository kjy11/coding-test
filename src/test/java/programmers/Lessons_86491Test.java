package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.StringToArray;

class Lessons_86491Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int[][] sizes, int expected) {
        Lessons_86491 test = new Lessons_86491();
        assertEquals(expected, test.solution(sizes));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(StringToArray.stringToArray("[[60, 50], [30, 70], [60, 30], [80, 40]]"), 4000),
            Arguments.of(StringToArray.stringToArray("[[10, 7], [12, 3], [8, 15], [14, 7], [5, 15]]"), 120),
            Arguments.of(StringToArray.stringToArray("[[14, 4], [19, 6], [6, 16], [18, 7], [7, 11]]"), 133)
        );
    }


}