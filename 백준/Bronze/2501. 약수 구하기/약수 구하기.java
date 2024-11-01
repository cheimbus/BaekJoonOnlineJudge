import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= n; i ++) {
            if(n % i == 0) arr.add(i);
        }

        int cnt = 0;
        if(arr.size() < m) cnt = 0;
        else cnt = arr.get(m - 1);

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}