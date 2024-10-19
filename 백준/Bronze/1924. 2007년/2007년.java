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

        int currDay = 0;

        switch(month) {
            case 1:
                currDay = 0;
                break;
            case 2:
                currDay = 31;
                break;
            case 3:
                currDay = 31 + 28;
                break;
            case 4:
                currDay = 31 + 28 + 31;
                break;
            case 5:
                currDay = 31 + 28 + 31 + 30;
                break;
            case 6:
                currDay = 31 + 28 + 31 + 30 + 31;
                break;
            case 7:
                currDay = 31 + 28 + 31 + 30 + 31 + 30;
                break;
            case 8:
                currDay = 31 + 28 + 31 + 30 + 31 + 30 + 31;
                break;
            case 9:
                currDay = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
                break;
            case 10:
                currDay = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
                break;
            case 11:
                currDay = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
                break;
            case 12:
                currDay = 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
                break;
        }

        currDay += day;
        StringBuilder sb = new StringBuilder();

        if(currDay % 7 == 1) sb.append("MON");
        else if(currDay % 7 == 2) sb.append("TUE");
        else if(currDay % 7 == 3) sb.append("WED");
        else if(currDay % 7 == 4) sb.append("THU");
        else if(currDay % 7 == 5) sb.append("FRI");
        else if(currDay % 7 == 6) sb.append("SAT");
        else if(currDay % 7 == 0) sb.append("SUN");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}