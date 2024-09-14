import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static StringBuilder sb = new StringBuilder();
    
    public static void findComNum(int x, int y) {
        
        int data = 1;
        for(int i = 0; i < y; i++) {
            data *= x;
            data = data % 10;
        }
        
        if(data == 0) {
            sb.append(10).append("\n");
            return;
        }
        
        sb.append(data).append("\n");   
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        
        for(int i = 0; i < n; i++) {
            stk = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stk.nextToken());
            int y = Integer.parseInt(stk.nextToken());
            findComNum(x, y);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        System.out.print(sb);
    }
}