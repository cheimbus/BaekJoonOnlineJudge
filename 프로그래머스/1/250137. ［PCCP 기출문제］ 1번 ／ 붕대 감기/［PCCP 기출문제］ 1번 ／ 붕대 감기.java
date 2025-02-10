class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = 0;    
        int t = 0;
        int cs = 0;
        int ch = health;
        boolean flg = false;
        
        for(int i = 0; i < attacks.length; i ++) {
            int ct = attacks[i][0];
            int ca = attacks[i][1];
            
            while(true) {
                t ++;
                if(t == ct) {
                    ch -= ca;
                    cs = 0;
                    if(ch <= 0) {
                        flg = true;
                        break;
                    }
                    break;
                }
                else {
                    cs ++;
                    ch += bandage[1];
                    if(cs == bandage[0]) {
                        ch += bandage[2];
                        cs = 0;
                    }
                    if(ch >= health) ch = health;
                }
            }
            if(flg) break;
        }
        
        answer = ch;
        if(flg) answer = -1;
        
        return answer;
    }
}