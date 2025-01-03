import java.util.Scanner;

public class Main {
    public static final int MOD = 1000000000;
    public static int n;
    public static int[][] dp = new int[101][10];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        for (int i = 1; i <= 9; i++)
            dp[1][i] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= 9; j++) {
                // 숫자가 감소하는 경우를 고려합니다.
                if (j > 0) {
                    dp[i + 1][j - 1] = (dp[i + 1][j - 1] + dp[i][j]) % MOD;
                }

                // 숫자가 증가하는 경우를 고려합니다.
                if (j < 9) {
                    dp[i + 1][j + 1] = (dp[i + 1][j + 1] + dp[i][j]) % MOD;
                }
            }
        }

        // 최종 결과를 계산합니다.
        int ans = 0;
        for (int j = 0; j <= 9; j++) {
            ans = (ans + dp[n][j]) % MOD;
        }

        // 계산된 결과를 출력합니다.
        System.out.println(ans);
    }
}