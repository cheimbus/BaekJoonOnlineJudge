import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {       
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(stk.nextToken());
        int y = Integer.parseInt(stk.nextToken());
        int w = Integer.parseInt(stk.nextToken());
        int h = Integer.parseInt(stk.nextToken());
        
        int xMin = Math.min(x, w-x);
        int yMin = Math.min(y, h-y);
        int minVal = Math.min(xMin, yMin);
        
        System.out.print(minVal);
    }
}