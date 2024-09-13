import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    
    public static int cycleCnt = 0;
    public static String firstText;
    
    public static void plusCycle(String num) {
        cycleCnt++;

        int x = Integer.parseInt(String.valueOf(num.charAt(0)));
        int y = Integer.parseInt(String.valueOf(num.charAt(1)));
        
        int plus = x + y;
        int addPlus = plus % 10;
        
        StringBuilder sb = new StringBuilder();
        sb.append(y).append(addPlus);

        if (firstText.equals(sb.toString())) {
            return;
        }

        plusCycle(sb.toString());
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        
        if (n < 10) {
            sb.append("0").append(n);
        } else {
            sb.append(n);
        }
        
        firstText = sb.toString();
        plusCycle(sb.toString());
        
        System.out.print(cycleCnt);
    }
}
