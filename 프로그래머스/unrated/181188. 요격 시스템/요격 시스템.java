import java.util.*;

class Solution {
    public static int solution(int[][] targets) {
        //처음 요격 미사일을 넣고 시작
        int answer = 1;
        //폭격 미사일의 끝 좌표를 기준으로 정렬
        Arrays.sort(targets, (o1, o2) -> { return o1[1]-o2[1]; });

        int last = targets[0][1] //첫 폭격 미사일의 끝 좌표 == 요격 미사일이 발사되는 x좌표

        for(int[] target : targets){
            if (last <= target[0]) {
                answer++;
                last = target[1];
            }
        }
        return answer;
    }
}
