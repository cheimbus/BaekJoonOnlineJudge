import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int cnt;
    public static int k, n;

    public static void findNum(int h, int m, int s) {
        String curr = String.format("%02d%02d%02d", h, m, s);
        char[] cArr = curr.toCharArray();
        for(char c : cArr) {
            if(Character.getNumericValue(c) == k) {
                cnt ++;
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        k = Integer.parseInt(stk.nextToken());

        int toSec = (n * 3600) + (59 * 60) + 59;

        for(int i = 0; i <= toSec; i ++) {
            int currH = i / 3600;
            int currM = (i % 3600) / 60;
            int currS = i % 60;
            findNum(currH, currM, currS);
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}