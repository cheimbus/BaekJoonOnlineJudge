import java.util.*;
class Solution {
    public int getKey(String s) {
        if(s.equals("code")) return 0;
        else if(s.equals("date")) return 1;
        else if(s.equals("maximum")) return 2;
        else if(s.equals("remain")) return 3;
        return 0;
    }
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int key1 = getKey(ext);
        
        ArrayList<int[]> arr = new ArrayList<>();
        for(int i = 0; i < data.length; i ++) {
            if(data[i][key1] < val_ext) arr.add(data[i]);
        }
        
        int key2 = getKey(sort_by);
        arr.sort(Comparator.comparingInt(a -> a[key2]));
        
        int[][] ans = new int[arr.size()][4];
        for(int i = 0; i < arr.size(); i ++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}