import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < s.length(); i ++) {
            int target = s.charAt(i) - '0';
            String st = Integer.toBinaryString(target);
            if(st.length() == 3) {
                sb.append(st);
            }
            else if(st.length() == 2 && i != 0) {
                sb.append("0" + st);
            }
            else if(st.length() == 1 && i != 0) {
                sb.append("00" + st);
            }
            else sb.append(st);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}