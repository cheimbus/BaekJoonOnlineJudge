import java.io.*;
import java.util.*;

public class Main {
    private static String targetString;
    private static int n, minCost = Integer.MAX_VALUE;
    private static int[] costs;
    private static String[] books;
    public static ArrayList<Integer> arr = new ArrayList<>();

    private static boolean canFormTarget() {
        int[] targetCount = new int[26];
        for (char c : targetString.toCharArray()) {
            targetCount[c - 'A']++;
        }

        int[] combinedCount = new int[26];
        for (int index : arr) {
            for (char c : books[index].toCharArray()) {
                combinedCount[c - 'A']++;
            }
        }

        for (int i = 0; i < 26; i++) {
            if (combinedCount[i] < targetCount[i]) {
                return false;
            }
        }
        return true;
    }

    private static void dfs(int depth) {
        if (depth == n) {
            if (canFormTarget()) {
                int totalCost = 0;
                for (int index : arr) {
                    totalCost += costs[index];
                }
                minCost = Math.min(minCost, totalCost);
            }
            return;
        }

        arr.add(depth);
        dfs(depth + 1);
        arr.remove(arr.size() - 1);
        dfs(depth + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        targetString = br.readLine();
        n = Integer.parseInt(br.readLine());

        costs = new int[n];
        books = new String[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            costs[i] = Integer.parseInt(st.nextToken());
            books[i] = st.nextToken();
        }

        dfs(0);

        int ans = minCost == Integer.MAX_VALUE ? -1 : minCost;

        bw.write(ans + "");
        bw.flush();
    }
}
