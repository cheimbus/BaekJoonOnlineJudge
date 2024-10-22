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

        int[] months = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        while(true) {
            StringTokenizer stk = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(stk.nextToken());
            int month = Integer.parseInt(stk.nextToken());
            int year = Integer.parseInt(stk.nextToken());

            if(day == 0 && month == 0 && year == 0) break;

            int yearPlus = 0;
            if((year % 4 == 0) && ((year % 400 == 0) || year % 100 != 0)) {
                yearPlus = 1;
            }

            if(yearPlus == 1 && month > 2) {
                day += yearPlus;
            }

            int fullDay = 0;
            for(int i = 1; i < month; i ++) {
                fullDay += months[i];
            }
            fullDay += day;
            bw.write(fullDay + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}