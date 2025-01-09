import java.io.*;
import java.util.*;

public class Main {
    public static int n, m, ans;
    public static int[] arr;
    public static int[] tmp;

    public static int calc(int len) {
        int val = 0;
        for (int i = 0; i < len; i++) {
            val = val * 10 + tmp[i];
        }
        if (n >= val) return val;
        else return 0;
    }

    public static void dfs(int depth, int len) {
        if (depth == len) {
            ans = Math.max(ans, calc(len));
            return;
        }

        for (int i = 0; i < m; i++) {
            tmp[depth] = arr[i];
            dfs(depth + 1, len);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] sArr = br.readLine().split(" ");
        n = Integer.parseInt(sArr[0]);
        m = Integer.parseInt(sArr[1]);

        arr = new int[m];

        StringTokenizer stk = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(stk.nextToken());
        }
        Arrays.sort(arr);

        // 1부터 n의 자리 수까지 탐색
        for (int len = 1; len <= sArr[0].length(); len++) {
            tmp = new int[len]; // 길이 변경 시 배열 초기화
            dfs(0, len);
        }

        bw.write(ans + "");
        bw.flush();
    }
}
