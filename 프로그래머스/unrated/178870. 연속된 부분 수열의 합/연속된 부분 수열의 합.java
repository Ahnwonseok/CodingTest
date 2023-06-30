import java.util.*;
class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

        int L = 0;
        int R = -1;
        int range = Integer.MAX_VALUE;
        int sum = 0;

        while (R < sequence.length){

            //System.out.println(sum);
            if (sum < k) {
                R++;
                if (R < sequence.length)
                    sum += sequence[R];
            }
            else if (sum > k) {
                sum -= sequence[L];
                L++;
            }
            else {
                if (R-L < range) {
                    answer[0] = L;
                    answer[1] = R;
                    range = R - L;
                }
                sum -= sequence[L];
                L++;
            }
            //else if (R-L == range) break;
            //System.out.println(Arrays.toString(answer));
            //System.out.println("------------------");
        }

        return answer;
    }
}