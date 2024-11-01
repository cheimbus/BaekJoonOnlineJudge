import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void findNum(int num) {
        int currVal = 0;

        int[] arr = new int[num];
        int cnt = 0;
        for(int i = 1; i < num; i ++) {
            if(num % i == 0) {
                arr[cnt ++] = i;
                currVal += i;
            }
        }

        if(currVal == num) {
            StringBuilder sb2 = new StringBuilder();
            for(int i = 0; i < cnt; i++) {
                sb2.append(arr[i]);
                if (i < cnt - 1) {
                    sb2.append(" + ");
                }
            }
            sb.append(currVal).append(" = ").append(sb2.toString()).append("\n");
        }
        else {
            sb.append(num).append(" ").append("is NOT perfect.").append("\n");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            if(n == -1) break;

            findNum(n);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
