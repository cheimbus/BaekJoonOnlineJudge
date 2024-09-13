import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = 1;
        
        for(int i = 0; i < 3; i++) {
            n *= Integer.parseInt(br.readLine());
        }
        
        int[] intArr = new int[10];
        
        String[] sArr = String.valueOf(n).split("");
        
        for(String s : sArr) {
            int digit = Integer.parseInt(s);
            intArr[digit]++;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i : intArr) {
            sb.append(i).append("\n");
        }
        
        System.out.print(sb);
    }
}