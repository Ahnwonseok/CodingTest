import java.util.*;

class Solution {
    public int solution(int NextStorey) {
        int answer = 0;

        while (NextStorey > 0){
            int NowRemain = NextStorey % 10;
            NextStorey /= 10; 
            int nextRest = NextStorey % 10;

            if (NowRemain > 5 && NextStorey == 0) {
                answer += 11 - NowRemain;
            }
            else if (NowRemain > 5) {
                answer += 10 - NowRemain;
                NextStorey += 1;
            }
            else if (NowRemain == 5){
                if (nextRest >= 5) NextStorey += 1;
                answer += 5;
            }
            else {
                answer += NowRemain;
            }
        }

        return answer;
    }
}