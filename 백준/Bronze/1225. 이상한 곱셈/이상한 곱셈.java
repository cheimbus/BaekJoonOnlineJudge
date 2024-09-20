import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        
        String s1 = stk.nextToken();
        String s2 = stk.nextToken();
        
        long val = 0;
        for(int i = 0; i < s1.length(); i++) {
            for(int j = 0; j < s2.length(); j++) {
                val += Character.getNumericValue(s1.charAt(i)) * Character.getNumericValue(s2.charAt(j));
            }
        }
        
        System.out.print(val);
    }
}