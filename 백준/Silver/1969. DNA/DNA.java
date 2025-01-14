import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        char[] cArr = new char[]{'A', 'C', 'G', 'T'};
        int[] nArr = new int[m];

        String[] arr = new String[n];
        for(int i = 0; i < n; i ++) {
            arr[i] = br.readLine();
        }

        int ans = 0;

        for(int i = 0; i < m; i ++) {
            int[] tmp = new int[4];
            for(int j = 0; j < 4; j ++) {
                for(int k = 0; k < n; k ++) {
                    if(cArr[j] != arr[k].charAt(i)) {
                        tmp[j] ++;
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            int idx = 0;
            for(int b = 0; b < 4; b ++) {
                if(min > tmp[b]) {
                    min = tmp[b];
                    idx = b;
                }
            }
            nArr[i] = idx;
            ans += min;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i ++) {
            int val = nArr[i];
            sb.append(cArr[val]);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sb).append("\n").append(ans);

        bw.write(sb2.toString());
        bw.flush();
    }
}
