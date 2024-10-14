import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static int n;
    public static int[] ASCII_CODE = new int[128];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        for (char c = 'A'; c <= 'Z'; c ++) {
            ASCII_CODE[c] = c - 'A';
        }

        StringBuilder sb = new StringBuilder();

        while(n -- > 0) {
            String[] arr = br.readLine().split("-");
            String sen = arr[0];
            int num = Integer.parseInt(arr[1]);

            long senVal = 0;
            char[] cSen = sen.toCharArray();
            for(int i = 0; i < 3; i ++) {
                int j = 3 - 1 - i;
                int senNum = ASCII_CODE[cSen[i]];
                senVal += senNum * (long) Math.pow(26, j);
            }

            if(Math.abs(senVal - num) <= 100) sb.append("nice").append("\n");
            else sb.append("not nice").append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}