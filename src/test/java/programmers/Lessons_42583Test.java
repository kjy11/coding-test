package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_42583Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(int bridge_length, int weight, int[] truck_weights, int expected) {
        Lessons_42583 test = new Lessons_42583();
        assertEquals(expected, test.solution(bridge_length, weight, truck_weights));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(2, 10, new int[] {7,4,5,6}, 8),
            Arguments.of(100, 100, new int[] {10}, 101),
            Arguments.of(100, 100, new int[] {10,10,10,10,10,10,10,10,10,10}, 110)
        );
    }


}