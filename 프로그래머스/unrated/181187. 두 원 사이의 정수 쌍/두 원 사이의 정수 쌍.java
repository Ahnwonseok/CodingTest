class Solution {
    public long solution(int r1, int r2) {
        long r2count = 0;
        for (int i = 1; i <= r2; i++) {
            int y2 = (int) Math.floor(Math.sqrt(((long) r2 * r2 - (long) i * i))) + 1;
            r2count += y2;
        }
        r2count = r2count * 4 + 1;

        long r1count = 0;
        long edge = 0;
        for (int i = 1; i <= r1; i++) {
            double yPowSqrt = Math.sqrt(((long) r1 * r1 - (long) i * i));
            int y1 = (int) Math.floor(yPowSqrt) + 1;
            r1count += y1;
            if (yPowSqrt % 1 == 0.0)
                edge += 1;
        }
        r1count = r1count * 4 + 1;
        return r2count - r1count + edge * 4;
    }
}