import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(true) {
            String s = br.readLine();
            int num = Integer.parseInt(s);
            int len = s.length();
            int k = 10;
            if(num == 0) break;

            while(num >= 10) {
                int plus = 0;
                while(len -- > 0) {
                    plus += num % k;
                    num /= k;
                    k *= 10;
                }
                num = plus;
                k = 10;
                len = String.valueOf(plus).length();
            }
            bw.write(num + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}