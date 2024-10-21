import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Integer.parseInt(br.readLine());
        long k = 10;

        while(n > k) {
            if(n % k >= k / 2) {
                n = n - (n % k);
                n += k;
            }
            else {
                n = n - (n % k);
            }
            k *= 10;
        }
        bw.write(n + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}