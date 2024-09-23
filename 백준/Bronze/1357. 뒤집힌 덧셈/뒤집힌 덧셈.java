import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        String n = stk.nextToken();
        String m = stk.nextToken();
        
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        for(int i = n.length()-1; i >= 0; i--) {
            sb1.append(n.charAt(i));
        }
        for(int i = m.length()-1; i >= 0; i--) {
            sb2.append(m.charAt(i));
        }
        
        int x = Integer.parseInt(sb1.toString());
        int y = Integer.parseInt(sb2.toString());
        
        int plus = x + y;
        String sPlus = String.valueOf(plus);
        
        StringBuilder sb3 = new StringBuilder();
        for(int i = sPlus.length()-1; i >= 0; i--) {
            sb3.append(sPlus.charAt(i));
        }
        
        int result = Integer.parseInt(sb3.toString());
        
        System.out.print(result);
    }
}