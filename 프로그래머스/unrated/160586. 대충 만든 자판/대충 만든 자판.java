import java.util.*;

class Solution {
    public static int[] solution(String[] keymaps, String[] targets) {
        int[] answer = new int[targets.length];
        int cnt =0;

        HashMap<String,Integer> map = new HashMap<>();

        for (String key : keymaps){
            String[] keys = key.split("");
            for (int i=0 ; i<keys.length; i++){
                if (map.get(keys[i])==null || map.get(keys[i]) > i+1) {
                    map.put(keys[i], i+1);
                }
            }
        }

        for (String target : targets){
            String[] targetAlphas = target.split("");
            for (String targetAlpha:targetAlphas){
                if (!map.containsKey(targetAlpha)) {
                    answer[cnt] = -1;
                    break;
                    
                }
                else {
                    answer[cnt] += map.get(targetAlpha);
                }
            }
            cnt++;
        }

        return answer;
    }
}