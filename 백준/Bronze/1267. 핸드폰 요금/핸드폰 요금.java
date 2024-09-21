import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); // 통화 기록 개수
        StringTokenizer stk = new StringTokenizer(br.readLine()); // 통화 시간들
        
        int chargeY = 0; // Y 요금제 (30초당 10원)
        int chargeM = 0; // M 요금제 (60초당 15원)
        
        for (int i = 0; i < n; i++) {
            int sec = Integer.parseInt(stk.nextToken());
            
            // 30초당 10원 요금 (Y 요금제)
            chargeY += (sec / 30 + 1) * 10;
            
            // 60초당 15원 요금 (M 요금제)
            chargeM += (sec / 60 + 1) * 15;
        }
        
        // 요금 비교 및 출력
        if (chargeY < chargeM) {
            System.out.println("Y " + chargeY);
        } else if (chargeM < chargeY) {
            System.out.println("M " + chargeM);
        } else {
            System.out.println("Y M " + chargeY);
        }
    }
}
