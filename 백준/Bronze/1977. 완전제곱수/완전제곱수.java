import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> list = new ArrayList<>();
    public static boolean isPerfectSquare(int num) {
        double sqrt = Math.sqrt(num);

        return sqrt == (int) sqrt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());


        for(int i = m; i <= n; i ++) {
            if(isPerfectSquare(i)) {
                list.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        if(list.isEmpty()) {
            sb.append(-1);
        }
        else {
            int minVal = list.get(0);
            int totalVal = 0;
            for(int i = 0; i < list.size(); i ++) {
                totalVal += list.get(i);
            }

            sb.append(totalVal).append("\n").append(minVal);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}