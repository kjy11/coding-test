package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static utils.StringToArray.stringToArray;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_92344Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int[][] board, int[][] skill, int expected) {
        Lessons_92344 test = new Lessons_92344();
        assertEquals(expected, test.solution(board, skill));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(stringToArray("[[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5],[5,5,5,5,5]]"), stringToArray("[[1,0,0,3,4,4],[1,2,0,2,3,2],[2,1,0,3,1,2],[1,0,1,3,3,1]]"), 10),
            Arguments.of(stringToArray("[[1,2,3],[4,5,6],[7,8,9]]"), stringToArray("[[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]"), 6)
        );
    }


}