package programmers;

import java.util.HashMap;
import java.util.Map;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 * 코딩테스트 연습 > 2021 카카오 채용연계형 인턴십 > 숫자 문자열과 영단어
 * */
public class Lessons_81301 {
    public int solution(String s) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        String tmp = "";
        for (String string : s.split("")) {
            try {
                int i = Integer.parseInt(string);
                answer = answer * 10 + i;
            } catch (Exception e){
                tmp += string;
                if (map.containsKey(tmp)) {
                    answer = answer * 10 + map.get(tmp);
                    tmp = "";
                }
            }
        }
        return answer;
    }
}
