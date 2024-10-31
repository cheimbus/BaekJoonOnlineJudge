import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static int cnt;
    public static char c;
    public static StringBuilder sb = new StringBuilder();

    public static void find(char[] cArr) {

        for(int i = 0; i < cArr.length; i ++) {
            cArr[i] = Character.toLowerCase(cArr[i]);
        }

        for(char a : cArr) {
            if(c == a) cnt ++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while(!(line = br.readLine()).equals("#")) {

            c = line.charAt(0);
            char[] cArr = new char[250];

            for(int i = 2; i < line.length(); i ++) {
                cArr[i - 2] = line.charAt(i);
            }

            find(cArr);

            sb.append(c + " ").append(cnt).append("\n");

            cnt = 0;
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}