import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int len = str.length();
        char[] charArr = str.toCharArray();
        
        int[] a = new int[len];
        int[] b = new int[len];
        
        for(int i = 0; i < len -1; i++) {
            int j = len - 1 - i;
            
            if(i == 0) {
                a[i] = Integer.parseInt(String.valueOf(charArr[i]));
                b[j] = Integer.parseInt(String.valueOf(charArr[j]));
                continue;
            }
            
            a[i] = a[i-1] * Integer.parseInt(String.valueOf(charArr[i]));
            b[j] = b[j+1] * Integer.parseInt(String.valueOf(charArr[j]));
        }

        boolean isTrue = false;
        for(int i = 0; i < len -1; i++) {
            if(a[i] == b[i+1]) {
                isTrue = true;
                break;
            }
        }
        String ujinsu = isTrue ? "YES" : "NO";
        System.out.print(ujinsu);
    }
}