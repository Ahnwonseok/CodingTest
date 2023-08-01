import java.util.*;
class Solution {
 public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String,Set> map = new HashMap<>();
        Set<String> set2 = new HashSet<>();
        Map<String,Set> map3 = new HashMap<>();

        for(String re : report){
            String[] list = re.split(" ");
            if (map.containsKey(list[1])) {
                map.get(list[1]).add(list[0]);
            }
            else {
                Set<String> set = new HashSet<>();
                set.add(list[0]);
                map.put(list[1],set);
            }

            if (map3.containsKey(list[0])) {
                map3.get(list[0]).add(list[1]);
            }
            else {
                Set<String> set = new HashSet<>();
                set.add(list[1]);
                map3.put(list[0],set);
            }

            if (map.get(list[1]).size()>=k) set2.add(list[1]);

        }

        for (int i=0; i< answer.length; i++){
            if(map3.containsKey(id_list[i])){
                for (String s : set2){
                    if (map3.get(id_list[i]).contains(s)){
                        answer[i] += 1;
                    }
                }
            }
        }
//        System.out.println(map);
//        System.out.println(map3);
//        System.out.println(set2);
//        System.out.println(Arrays.toString(answer));
        return answer;
    }
}