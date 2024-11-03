import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();
        long n = Long.parseLong(br.readLine());

        for(long i = 2; i <= Math.sqrt(n); i ++) {
            while(n % i == 0) {
                sb.append(i).append("\n");
                n /= i;
            }
        }

        if (n != 1) {
            sb.append(n).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}