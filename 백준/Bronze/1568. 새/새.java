import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int birds = Integer.parseInt(br.readLine());
        int cnt = 1;
        int sec = 0;
        while(birds > 0) {
            if(cnt > birds) {
                cnt = 1;
                continue;
            }
            birds -= cnt;
            cnt ++;
            sec ++;
        }

        bw.write(sec + "\n");
        bw.flush();
        bw.close();
    }
}