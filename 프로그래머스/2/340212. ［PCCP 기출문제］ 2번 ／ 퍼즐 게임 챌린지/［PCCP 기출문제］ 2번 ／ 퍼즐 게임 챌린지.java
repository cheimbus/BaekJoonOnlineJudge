class Solution {
    public boolean find(int lv, int[] diffs, int[] times, long limit) {
        long currT = 0;
        
        for(int i = 0; i < diffs.length; i ++) {
            int a = diffs[i];
            int t = times[i];
            int p = (i > 0) ? times[i - 1] : 0;
            
            if(lv >= a) currT += t;
            else currT += (long) (t + p) * (a - lv) + t;
            if(currT > limit) return false;
        }
        return true;
    }
    
    public int solution(int[] diffs, int[] times, long limit) {
        int lt = 1;
        int rt = 1_000_000_000;
        int ans = rt;
        
        while(lt <= rt) {
            int mid = lt + (rt - lt) / 2;
            
            if(find(mid, diffs, times, limit)) {
                ans = mid;
                rt = mid - 1;
            }
            else lt = mid + 1;
        }
        return ans;
    }
}