import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] st = br.readLine().toCharArray();
        char[] en = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < st.length; i ++) {
            if(st[i] == ' ') {
                sb.append(" ");
                continue;
            }

            int j = i % en.length;
            int stIdx = st[i];
            int enIdx = en[j];

            if(stIdx - enIdx <= 0) sb.append((char) (96 + 26 - Math.abs(stIdx - enIdx)));
            else sb.append((char) (stIdx - enIdx + 96));
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}