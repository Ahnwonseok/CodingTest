import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public ArrayList solution(String today, String[] terms, String[] privacies) {
        ArrayList answer = new ArrayList();
        String key = "";
        int value,j=1;
        HashMap<String,Integer> term = new HashMap<>();
        int[] datesInt = new int[3];

        String[] todays = today.split("\\.");
        int[] todaysInt = Arrays.asList(todays).stream().mapToInt(Integer::parseInt).toArray();

            for (String t : terms){
            key = t.split(" ")[0];
            value = Integer.parseInt(t.split(" ")[1]);
            term.put(key,value);
        }

        for (String p : privacies){
            String[] dates = p.split("\\.|\\s");
            for (int i=0; i<3; i++){
                datesInt[i] = Integer.parseInt(dates[i]);
            }
            datesInt[1] += term.get(dates[3]);
            datesInt[0] += (datesInt[1]-1) / 12;
            datesInt[1] = datesInt[1] % 12;
            datesInt[2] -=  1;

            if (datesInt[1] == 0) datesInt[1] = 12;
            if (datesInt[2] == 0){
                datesInt[1] -= 1;
                datesInt[2] = 28;
                if( datesInt[1] == 0){
                    datesInt[0] -= 1;
                    datesInt[1] = 12;
                }
                if( datesInt[1] == -1){
                    datesInt[1] = 11;
                }
            }

            if(datesInt[0] < todaysInt[0]){
                answer.add(j);
            } else if (datesInt[0] == todaysInt[0] && datesInt[1] < todaysInt[1]) {
                answer.add(j);
            } else if (datesInt[0] == todaysInt[0] && datesInt[1] == todaysInt[1] && datesInt[2] < todaysInt[2]) {
                answer.add(j);
            }
            j++;
            //System.out.println(Arrays.toString(datesInt));
        }
        //System.out.println(answer);
        return answer;
    }

}