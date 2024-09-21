import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String sNum = br.readLine();
            if(sNum.equals("0")) break;
            
            int num = Integer.parseInt(sNum);
            
            if(num < 10) {
                sb.append("yes").append("\n");
                continue;
            }
            
            boolean isPal = true;
            for(int i = 0; i < sNum.length() / 2; i++) {
                if(sNum.charAt(i) != sNum.charAt(sNum.length() -1 -i)) {
                    isPal = false;
                    break;
                }
            }
            if(isPal) {
                sb.append("yes").append("\n");
            }
            else {
                sb.append("no").append("\n");
            }

        }
        
        System.out.print(sb);
    }
}