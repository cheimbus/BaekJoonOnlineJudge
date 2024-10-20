import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        long sum = 5;
        long dot = 7;

        for(int i = 1; i < n; i ++) {
            sum += dot;
            dot += 3;
        }

        bw.write((sum % 45678) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}