import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        if (n == 1) {
            System.out.println(arr[1]);
            return;
        }

        // dp[i]: i번째 계단까지 올랐을 때 얻을 수 있는 최대 점수
        int[] dp = new int[n + 1];

        // 초기값 설정
        dp[1] = arr[1];
        dp[2] = arr[1] + arr[2]; // 두 번째 계단까지는 반드시 첫 계단을 밟아야 함.

        // 점화식
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + arr[i - 1]) + arr[i];
        }

        // 결과 출력
        System.out.println(dp[n]);
    }
}
