import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        StringBuilder sb = new StringBuilder();

        long cnt = n * n * n;

        sb.append(cnt).append("\n").append(3);
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}