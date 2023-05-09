import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0; 
        int[][] changeTimes;
        changeTimes = convertTime(book_time);
        changeTimes = orderBytime(changeTimes);

        List<Integer> endTimeList = new ArrayList<>();
        for(int[] time : changeTimes){
            boolean flag = false;
            for(int i=0; i<endTimeList.size(); i++){
                if(time[0]>=endTimeList.get(i)) {
                    endTimeList.set(i,time[1]);
                    flag = true;
                    break;
                }
            }
            if(flag==false) {
                endTimeList.add(time[1]);
                answer++;
            }
        }
        return answer;
    }

    public static int[][] convertTime(String[][] times){
        int[][] changeTimes = new int[times.length][2];

        for (int i=0; i<times.length; i++){
            int changeTime1 = Integer.parseInt(times[i][0].split(":")[0])*60 + Integer.parseInt(times[i][0].split(":")[1]);
            int changeTime2 = Integer.parseInt(times[i][1].split(":")[0])*60 + Integer.parseInt(times[i][1].split(":")[1]) + 10;
            changeTimes[i][0] = changeTime1;
            changeTimes[i][1] = changeTime2;
        }

        return changeTimes;
    }

    //체크인 기준으로 오름차순 정렬
    public static int[][] orderBytime(int[][] times){
        int tmpIndex=0;
        for (int i = 0; i<times.length-1; i++){
            tmpIndex = i;
            for(int j = i+1; j< times.length; j++){
                if(times[tmpIndex][0]>times[j][0]) {
                    tmpIndex = j;
                } 
                else if(times[tmpIndex][0]==times[j][0]){
                    if(times[tmpIndex][1]>times[j][1])
                        tmpIndex = j;
                }
            } 
            int[] tmp = times[i];
            times[i] = times[tmpIndex];
            times[tmpIndex] = tmp;
        }
        return times;
    }
}