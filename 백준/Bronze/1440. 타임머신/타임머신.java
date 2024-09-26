import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static boolean isTime(int h, int m, int s) {
        boolean isTime = false;

        if(1 <= h && h <= 12 && 0 <= m && m < 60 && 0 <= s && s < 60) isTime = true;

        return isTime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String time = br.readLine();
        String[] arrT = time.split(":");
        int[] arr = new int[3];

        for(int i = 0; i < arrT.length; i++) {
            arr[i] = Integer.parseInt(arrT[i]);
        }

        int len = arrT.length;
        int cnt = 0;

        for(int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                for(int k = 0; k < len; k++) {
                    if(i != j && i != k && j != k && isTime(arr[i], arr[j], arr[k])) {
                        cnt ++;
                    }
                }
            }
        }

        bw.write(String.valueOf(cnt));

        bw.flush();
        bw.close();
    }
}