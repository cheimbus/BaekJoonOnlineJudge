import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] arr = new int[3];
        for(int i = 0; i < 3; i ++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        StringBuilder sb = new StringBuilder();
        int a = arr[0] + arr[1] - arr[2];
        String b = arr[0] + "" + arr[1];
        int c = Integer.parseInt(b) - arr[2];
        sb.append(a).append("\n").append(c);
        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}