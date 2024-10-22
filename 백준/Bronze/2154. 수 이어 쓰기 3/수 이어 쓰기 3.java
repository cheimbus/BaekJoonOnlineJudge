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
        char[] cArr = sb.toString().toCharArray();
        int len = String.valueOf(n).length();

        int cnt = 0;
        for(int i = 0; i < cArr.length - len + 1; i ++) {
            cnt ++;
            StringBuilder sb1 = new StringBuilder();
            for(int j = i; j < i + len; j ++) {
                sb1.append(cArr[j]);
            }
            if(nNum.equals(sb1.toString())) break;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}