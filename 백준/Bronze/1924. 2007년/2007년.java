import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int month = Integer.parseInt(stk.nextToken());
        int day = Integer.parseInt(stk.nextToken());
        String[] monArr = new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};
        int[] months = new int[]{0,31,28,31,30,31,30,31,31,30,31,30,31};

        int mappingDay = 0;
        for(int i = 0; i < month; i ++) {
            mappingDay += months[i];
        }

        mappingDay += day;
        StringBuilder sb = new StringBuilder();
        sb.append(monArr[mappingDay % 7]);

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}