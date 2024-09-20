import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        int s1 = Integer.parseInt(stk.nextToken());
        int s2 = Integer.parseInt(stk.nextToken());
        int s3 = Integer.parseInt(stk.nextToken());
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    int mul = i + j + k;
                    map.put(mul, map.getOrDefault(mul, 0) + 1);
                }
            }
        }
        
        int maxValue = 0;
        int maxKey = 0;
        
        for (int key : map.keySet()) {
            int val = map.get(key);
            if (val > maxValue || (val == maxValue && key < maxKey)) {
                maxValue = val;
                maxKey = key;
            }
        }
        
        System.out.println(maxKey);
    }
}
