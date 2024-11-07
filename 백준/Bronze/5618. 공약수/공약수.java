import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[3];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i ++) {
            int num = Integer.parseInt(stk.nextToken());
            arr[i] = num;
        }

        int maxVal = -1;
        for(int i : arr) {
            if(maxVal < i) maxVal = i;
        }

        StringBuilder sb = new StringBuilder();
        if(n == 2) {
            for(int i = 1; i <= maxVal; i ++) {
                if(arr[0] % i == 0 && arr[1] % i == 0) sb.append(i).append("\n");
            }
        }
        else if(n == 3) {
            for(int i = 1; i <= maxVal; i ++) {
                if(arr[0] % i == 0 && arr[1] % i == 0 && arr[2] % i == 0) sb.append(i).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}