package programmers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Lessons_42895Test {

    @ParameterizedTest
    @CsvSource(value = {"5:12:4", "2:11:3"}, delimiter = ':')
    void solution(int n, int number, int result) {
        Lessons_42895 test = new Lessons_42895();
        assertEquals(result, test.solution(n, number));
    }
}