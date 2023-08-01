import java.util.HashMap;

class Solution {
    public static int[] solution(String[] names, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];

        HashMap<String,Integer> map = new HashMap<>();

        for(int i=0; i<names.length; i++){
            map.put(names[i],yearning[i]);
        }

        for(int i=0; i<photo.length; i++){
            for(int j=0; j<photo[i].length; j++){
                if (map.containsValue(map.get(photo[i][j]))){
                    answer[i] += map.get(photo[i][j]);
                }
            }
        }

        //System.out.println(Arrays.toString(answer));
        return answer;
    }
}