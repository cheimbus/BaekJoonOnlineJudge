import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i ++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        StringBuilder sb = new StringBuilder();

        int tmp = arr[0];
        int leftCnt = 1;
        for(int i = 1; i < n; i ++) {
            if(tmp < arr[i]) {
                leftCnt ++;
                tmp = arr[i];
            }
        }

        sb.append(leftCnt).append("\n");

        tmp = arr[n - 1];
        int rightCnt = 1;
        for(int i = n - 2; i >= 0; i --) {
            if(tmp < arr[i]) {
                rightCnt ++;
                tmp = arr[i];
            }
        }

        sb.append(rightCnt);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}