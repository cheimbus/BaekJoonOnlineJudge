import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n, m;
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static boolean possible() {
        for(int i = 0; i < arr.size() - 1; i ++)
            for(int j = i + 1; j < arr.size(); j ++) {
                if(arr.get(i) == arr.get(j)) {
                    return false;
                }
            }
        return true;
    }

    public static void recursion(int currNum) {
        if(currNum == m) {
            for(int i = 0; i < arr.size(); i ++) {
                sb.append(arr.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i ++) {
            arr.add(i);
            if(possible()) {
                recursion(currNum + 1);
            }
            arr.remove(arr.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        recursion(0);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}