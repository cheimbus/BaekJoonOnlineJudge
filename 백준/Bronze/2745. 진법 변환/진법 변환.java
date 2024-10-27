import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static String target;
    public static int num;
    public static long ans;

    public static void findDecimalNum() {
        char[] c = target.toCharArray();
        int exponent = 0;

        for (int i = c.length - 1; i >= 0; i--) {
            int value = Character.getNumericValue(c[i]);
            ans += value * Math.pow(num, exponent++);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        target = stk.nextToken();
        num = Integer.parseInt(stk.nextToken());

        findDecimalNum();

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
