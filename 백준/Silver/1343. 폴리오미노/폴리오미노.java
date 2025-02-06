import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    public static int n;
    public static int[] arr = new int[]{4, 2};
    public static StringBuilder sb = new StringBuilder();
    public static boolean flg = true;

    public static boolean find(int val) {
        int a = 0;
        int b = 0;
        for(int i = 0; i < 2; i ++) {
            if(i == 0) {
                a = val / arr[i];
                val %= arr[i];
            }
            else if(i == 1) {
                b = val / arr[i];
                val %= arr[i];
            }
        }
        if(val != 0) return false;

        for(int i = 0; i < a; i ++) {
            String s = "AAAA";
            sb.append(s);
        }
        for(int i = 0; i < b; i ++) {
            String s = "BB";
            sb.append(s);
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] cArr = br.readLine().toCharArray();

        int val = 0;
        for(char c : cArr) {
            if(c == 'X') val++;
            else {
                if(val == 0) {
                    sb.append(".");
                    continue;
                }
                boolean b = find(val);
                if(!b) {
                    sb.setLength(0);
                    sb.append(-1);
                    flg = false;
                }
                val = 0;
                sb.append(".");
            }
        }
        if(!flg) {
            sb.setLength(0);
            sb.append(-1);
        }
        else {
            if(!find(val)) {
                sb.setLength(0);
                sb.append(-1);
            }
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
