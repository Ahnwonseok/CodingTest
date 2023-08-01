class Solution {
    public static int solution(int n, int m, int[] section) {
        int answer = 1;
        int a = section[0];

        for (int i = 0; i<section.length; i++){

            if(a+m-1 < section[i]){
                a = section[i];
                answer++;
            }
        }
        return answer;
    }
}