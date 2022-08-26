package programmers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class Lessons_81301Test {

    @ParameterizedTest
    @MethodSource("createTestData")
    void solution(String s, int expected) {
        Lessons_81301 test = new Lessons_81301();
        assertEquals(expected, test.solution(s));
    }

    private static Stream<Arguments> createTestData() {
        return Stream.of(
            Arguments.of("one4seveneight", 1478),
            Arguments.of("23four5six7", 234567),
            Arguments.of("2three45sixseven", 234567),
            Arguments.of("123", 123)
        );
    }


}