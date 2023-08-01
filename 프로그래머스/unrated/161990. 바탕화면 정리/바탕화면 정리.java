class Solution {
  public static int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int[] lu = {51,51,0,0};        

        for (int i=0; i < wallpaper.length; i++){

            String[] walls = wallpaper[i].split("");

            for (int j=0; j< walls.length; j++){
                if (walls[j].equals(".")) continue;
                else{                    
                    if (i<lu[0]) lu[0] = i;
                    if (j<lu[1]) lu[1] = j;
                    if (i>lu[2]) lu[2] = i;
                    if (j>lu[3]) lu[3] = j;
                }
            }
        }

        answer[0] = lu[0];
        answer[1] = lu[1];
        answer[2] = lu[2]+1;
        answer[3] = lu[3]+1 ;

        return answer;
    }
}