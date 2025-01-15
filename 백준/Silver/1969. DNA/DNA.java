import java.io.*;
import java.util.*;

public class Main {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        String[] sArr = new String[n];
        char[] cArr = new char[]{'A', 'C', 'G', 'T'};

        for(int i = 0; i < n; i ++) {
            sArr[i] = br.readLine();
        }

        int[] aArr = new int[m];
        int val = 0;
        for(int i = 0; i < m; i ++) {
            int[] arr = new int[4];
            for(int j = 0; j < 4; j ++) {
                for(int k = 0; k < n; k ++) {
                    if(cArr[j] != sArr[k].charAt(i)) {
                        arr[j] ++;
                    }
                }
            }
            int id = 0;
            int val2 = Integer.MAX_VALUE;
            for(int b = 0; b < 4; b ++) {
                if(val2 > arr[b]) {
                    id = b;
                    val2 = arr[b];
                }
            }
            aArr[i] = id;
            val += val2;
        }

        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i < m; i ++) {
            sb1.append(cArr[aArr[i]]);
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sb1).append("\n").append(val);

        bw.write(sb2.toString());
        bw.flush();
    }
}
