package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import utils.StringToArray;

class Lessons_87946Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int k, int[][] dungeons, int expected) {
        Lessons_87946 test = new Lessons_87946();
        assertEquals(expected, test.solution(k, dungeons));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(80, StringToArray.stringToArray("[[80,20],[50,40],[30,10]]"), 3)
        );
    }


}