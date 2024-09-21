import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String s = br.readLine();
            if(s.equals("0")) break;
            int cnt = 0;
            for(int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '0') cnt += 4;
                else if(s.charAt(i) == '1') cnt += 2;
                else cnt += 3;
            }
            cnt += 2;
            cnt += s.length() -1;
            
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}