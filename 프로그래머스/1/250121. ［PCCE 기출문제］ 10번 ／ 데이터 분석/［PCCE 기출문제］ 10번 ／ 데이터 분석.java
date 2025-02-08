import java.util.*;

class Solution {
    public int getKey(String ext) {
        int val = 0;
        if (ext.equals("code")) val = 0;
        else if (ext.equals("date")) val = 1;
        else if (ext.equals("maximum")) val = 2;
        else if (ext.equals("remain")) val = 3;
        return val;
    }

    public ArrayList<int[]> solution(int[][] data, String ext, int val_ext, String sort_by) {
        ArrayList<int[]> arr = new ArrayList<>();

        int key = getKey(ext);

        for (int i = 0; i < data.length; i++) {
            if (data[i][key] < val_ext) {
                arr.add(data[i]);
            }
        }

        int key2 = getKey(sort_by);

        arr.sort(Comparator.comparingInt(a -> a[key2]));

        return arr;
    }
}
