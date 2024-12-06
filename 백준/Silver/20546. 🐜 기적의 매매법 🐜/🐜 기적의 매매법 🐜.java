import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int n;
    public static int[] arr = new int[14];

    public static int find1() {
        int val = n;
        int result = 0;
        int lastVal = 0;
        for(int i = 0; i < arr.length; i ++) {
            if(val / arr[i] > 0) {
                result += val / arr[i];
                val = val % arr[i];
            }
            lastVal = arr[i];
        }
        return val + result * lastVal;
    }

    public static int find2() {
        int val = n;
        int remain = 0;
        int currVal = arr[0];
        int aCnt = 1;
        int bCnt = 1;

        for(int i = 1; i < arr.length; i ++) {
            if(currVal > arr[i]) {
                aCnt ++;
                bCnt = 0;
                if(aCnt == 3) {
                    remain += val / arr[i];
                    val %= arr[i];
                    aCnt = 2;
                }
            }
            else if(currVal < arr[i]) {
                bCnt ++;
                aCnt = 0;
                if(bCnt == 3) {
                    val += remain * arr[i];
                    remain = 0;
                    bCnt = 2;
                }
            }
            currVal = arr[i];
        }
        return val + remain * currVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < 14; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        int a = find1();
        int b = find2();

        StringBuilder sb = new StringBuilder();
        if(a > b) sb.append("BNP");
        else if(a < b) sb.append("TIMING");
        else sb.append("SAMESAME");

        bw.write(sb.toString());
        bw.flush();
    }
}