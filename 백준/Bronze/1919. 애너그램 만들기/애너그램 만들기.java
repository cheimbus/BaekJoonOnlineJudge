import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();

        int len1 = c1.length;  // c1의 길이
        int len2 = c2.length;  // c2의 길이

        boolean[] c1Arr = new boolean[len1];
        boolean[] c2Arr = new boolean[len2];

        // c1의 길이만큼 반복
        for (int i = 0; i < len1; i++) {
            char nc1 = c1[i];
            // c2의 길이만큼 반복
            for (int j = 0; j < len2; j++) {
                if (nc1 == c2[j] && !c1Arr[i] && !c2Arr[j]) {
                    c1Arr[i] = true;
                    c2Arr[j] = true;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < len1; i++) {
            if (!c1Arr[i]) cnt++;
        }

        for (int i = 0; i < len2; i++) {
            if (!c2Arr[i]) cnt++;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
