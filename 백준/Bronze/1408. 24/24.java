import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int currTimeSec = 0;
        int startTimeSec = 0;


        String currTime = br.readLine();
        String startTime = br.readLine();

        String[] sCurTime = currTime.split(":");
        String[] sStartTime = startTime.split(":");

        int curH = Integer.parseInt(sCurTime[0]) * 3600;
        int curM = Integer.parseInt(sCurTime[1]) * 60;
        int curS = Integer.parseInt(sCurTime[2]);

        currTimeSec = curH + curM + curS;

        int startH = Integer.parseInt(sStartTime[0]) * 3600;
        int startM = Integer.parseInt(sStartTime[1]) * 60;
        int startS = Integer.parseInt(sStartTime[2]);

        startTimeSec = startH + startM + startS;

        int remainTime = 0;

        if(startTimeSec >= currTimeSec) {
            remainTime = startTimeSec - currTimeSec;
        }
        else {
            remainTime = 24 * 3600 - (currTimeSec - startTimeSec);
        }

        int rH = remainTime / 3600;
        int rM = (remainTime % 3600) / 60;
        int rS = remainTime % 60;

        String re = String.format("%02d:%02d:%02d", rH, rM, rS);
        bw.write(re);

        bw.flush();
        bw.close();
    }
}