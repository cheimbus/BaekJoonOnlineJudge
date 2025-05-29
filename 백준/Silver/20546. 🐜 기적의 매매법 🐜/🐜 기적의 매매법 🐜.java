import java.io.*;
import java.util.*;


public class Main {
    public static int n;
    public static int[] arr;

    public static int impl1() {
        int val = n;
        int re = 0;

        for(int i = 0; i < 14; i ++) {
            if(val / arr[i] != 0) {
                re += val / arr[i];
                val %= arr[i];
            }
        }
        return val + re * arr[13];
    }

    public static int impl2() {
        int val = n;
        int re = 0;
        int a = arr[0];
        int cnt1 = 0;
        int cnt2 = 0;

        for(int i = 1; i < 14; i ++) {
            if(a < arr[i]) {
                cnt1 ++;
                cnt2 = 0;
                if(cnt1 == 3) {
                    cnt1 = 0;
                    val += re * arr[i];
                    re = 0;
                }
            }
            else if(a > arr[i]) {
                cnt2 ++;
                cnt1 = 0;
                if(cnt2 == 3) {
                    cnt2 = 0;
                    re += val / arr[i];
                    val %= arr[i];
                }
            }
            a = arr[i];
        }
        return val + re * a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[14];
        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < 14; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int a = impl1();
        int b = impl2();

        StringBuilder sb = new StringBuilder();
        if(a > b) sb.append("BNP");
        else if(a < b) sb.append("TIMING");
        else sb.append("SAMESAME");

        bw.write(sb.toString());
        bw.flush();
    }
}