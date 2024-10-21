import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static boolean isPrimeNum(int num) {
        for(int i = 2; i < num; i ++) {
            if(num % i == 0) return false;
        }
        return true;
    }

    public static boolean findPrimeNum(int num) {
        return num > 1 && isPrimeNum(num);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        StringTokenizer stk = new StringTokenizer(br.readLine());
        while(n -- > 0) {
            int num = Integer.parseInt(stk.nextToken());
            if(findPrimeNum(num)) cnt ++;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}