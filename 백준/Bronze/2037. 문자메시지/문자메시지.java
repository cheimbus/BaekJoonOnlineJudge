import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int p, w, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        p = Integer.parseInt(stk.nextToken());
        w = Integer.parseInt(stk.nextToken());

        String[] message = br.readLine().split("");
        String[][] sArr = new String[][]{{"A","B","C"},{"D","E","F"},{"G","H","I"},{"J","K","L"},
                {"M","N","O"},{"P","Q","R","S"},{"T","U","V"},{"W","X","Y","Z"}};

        int samePos = -1;
        for(String s : message) {
            if(s.equals(" ")) {
                cnt += p;
                samePos = -1;
                continue;
            }
            for(int i = 0; i < sArr.length; i ++) {
                int pos = 0;
                for(int j = 0; j < sArr[i].length; j ++) {
                    pos ++;
                    if(s.equals(sArr[i][j]) && samePos == i) {
                        cnt += w + p * pos;
                        break;
                    }
                    else if(s.equals(sArr[i][j])) {
                        cnt += p * pos;
                        samePos = i;
                        break;
                    }
                }
            }
        }
        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}