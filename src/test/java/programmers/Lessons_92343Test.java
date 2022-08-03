package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_92343Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int[] info, int[][] edges, int expected) {
        Lessons_92343 test = new Lessons_92343();
        assertEquals(expected, test.solution(info, edges));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(new int[] {0,0,1,1,1,0,1,0,1,0,1,1}, new int[][] {{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}}, 5),
            Arguments.of(new int[] {0,1,0,1,1,0,1,0,0,1,0}, new int[][] {{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}}, 5)
        );
    }
}