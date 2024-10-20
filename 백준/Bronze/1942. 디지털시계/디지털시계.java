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

        String line;

        while((line = br.readLine()) != null) {
            StringTokenizer stk = new StringTokenizer(line);
            String[] sCurrTimeArr = stk.nextToken().split(":");
            String[] sEndTimeArr = stk.nextToken().split(":");

            String sCurrTime = String.format("%s%s%s", sCurrTimeArr[0], sCurrTimeArr[1], sCurrTimeArr[2]);
            String sEndTime = String.format("%s%s%s", sEndTimeArr[0], sEndTimeArr[1], sEndTimeArr[2]);

            int currTime = Integer.parseInt(sCurrTime);
            int endTime = Integer.parseInt(sEndTime);

            int currHour = Integer.parseInt(sCurrTimeArr[0]);
            int currMin = Integer.parseInt(sCurrTimeArr[1]);
            int currSec = Integer.parseInt(sCurrTimeArr[2]);

            int cnt = 0;

            while(currTime != endTime) {
                if(currTime % 3 == 0) cnt ++;
                currSec ++;

                if(currSec == 60) {
                    currMin ++;
                    currSec = 0;
                    if(currMin == 60) {
                        currHour ++;
                        currMin = 0;
                        if(currHour == 24) {
                            currHour = 0;
                        }
                    }
                }
                String setTime = String.format("%02d%02d%02d", currHour, currMin, currSec);
                currTime = Integer.parseInt(setTime);
            }

            if(currTime % 3 == 0) cnt ++;

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}