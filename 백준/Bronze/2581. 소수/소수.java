import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    public static int maxVal;
    public static int min = 100000;
    public static ArrayList<Integer> arr = new ArrayList<>();

    public static int findPrimeNum(int n) {
        if(n == 1) return 0;
        for(int i = 2; i < n; i ++) {
            if(n % i == 0) {
                return 0;
            }
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for(int i = n; i <= m; i ++) {
            int primeNum = findPrimeNum(i);
            if(primeNum != 0) {
                maxVal += primeNum;
                arr.add(primeNum);
            }
        }

        for(int i = 0; i < arr.size(); i ++) {
            if(min > arr.get(i)) min = arr.get(i);
        }

        StringBuilder sb = new StringBuilder();
        if(maxVal > 0) {
            sb.append(maxVal).append("\n").append(min);
        }
        else sb.append(-1);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
