import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = 8;
        int[] arr = new int[n];
        Integer[] tmp = {1, 2, 3, 4, 5, 6, 7, 8};
        for(int i = 0; i < n; i ++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }

        boolean isAsc = true;
        for(int i = 0; i < n; i ++) {
            if(arr[i] != tmp[i]) {
                isAsc = false;
                break;
            }
        }

        Arrays.sort(tmp, Collections.reverseOrder());
        boolean isDSC = true;
        for(int i = 0; i < n; i ++) {
            if(arr[i] != tmp[i]) {
                isDSC = false;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        if(isAsc) sb.append("ascending");
        else if(isDSC) sb.append("descending");
        else sb.append("mixed");

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}