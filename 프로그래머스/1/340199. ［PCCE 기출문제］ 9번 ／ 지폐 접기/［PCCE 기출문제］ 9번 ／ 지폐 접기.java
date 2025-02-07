class Solution {
    
    public boolean find(int a, int b, int c, int d) {
        if(a >= c && b >= d) return true;
        return false;
    }
    
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        int w1 = wallet[0];
        int w2 = wallet[1];
        int b1 = bill[0];
        int b2 = bill[1];
        
        if(w1 >= b1 && w2 >= b2) return answer;
        else if(w1 >= b2 && w2 >= b1) return answer;
        
        while(true) {
            answer ++;
            if(b1 > b2) {
                b1 /= 2;
                if(find(w1, w2, b1, b2)) break;
                int nb1 = b2;
                int nb2 = b1;
                if(find(w1, w2, nb1, nb2)) break;
            }
            else {
                b2 /= 2;
                if(find(w1, w2, b1, b2)) break;
                int nb1 = b2;
                int nb2 = b1;
                if(find(w1, w2, nb1, nb2)) break;
            }
        }
        return answer;
    }
}