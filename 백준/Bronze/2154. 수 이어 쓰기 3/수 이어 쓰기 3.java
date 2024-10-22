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

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i ++) {
            sb.append(i);
        }

        String nNum = String.valueOf(n);

        int pos = sb.indexOf(nNum);

        bw.write(pos + 1 + "\n");
        bw.flush();
        bw.close();
    }
}