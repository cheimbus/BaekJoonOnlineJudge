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

        while(n >= 4) {
            char[] gms = String.valueOf(n).toCharArray();
            boolean[] isGms = new boolean[gms.length];
            int gmsCnt = 0;

            for(char c : gms) {
                if(c == '4' || c == '7') {
                    isGms[gmsCnt] = true;
                    gmsCnt ++;
                    continue;
                }
                break;
            }

            int cnt = 0;
            for(boolean b : isGms) {
                if(b) cnt ++;
            }

            if(cnt == gms.length) {
                sb.append(n);
                break;
            }
            n --;
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}