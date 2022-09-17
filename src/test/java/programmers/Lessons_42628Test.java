package programmers;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_42628Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(String[] operations, int[] expected) {
        Lessons_42628 test = new Lessons_42628();
        assertArrayEquals(expected, test.solution(operations));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of(new String[] {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}, new int[] {0, 0}),
            Arguments.of(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}, new int[] {333, -45})
        );
    }


}