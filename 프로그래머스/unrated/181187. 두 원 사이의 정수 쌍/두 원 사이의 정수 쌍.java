class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;
        long y1 = 0; 
        long y2 = 0;
        long line = 0;

        Solution twoCircle = new Solution();
        y1 = twoCircle.innerNum(false, r1);
        y2 = twoCircle.innerNum(false, r2);
        line = twoCircle.innerNum(true, r1);

        answer = y2 - y1 + line;
        
        return answer;
    }

    public long innerNum(boolean flag, int r){
        int x = 1;
        int y = 1;
        long sum_y = 0;
        long line = 0;

        while (x <= r) {
            if(Math.sqrt(Math.pow(x,2)+Math.pow(r-y,2)) < r){
                sum_y += r - y + 1;
                x++;
            }
            else if(Math.sqrt(Math.pow(x,2)+Math.pow(r-y,2)) == r){
                sum_y += r - y + 1;
                line++;
                x++;
            }
            else y++;
        }

        if (flag) return line * 4;
        else return sum_y * 4;
    }
}