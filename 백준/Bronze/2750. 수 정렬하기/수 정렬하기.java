import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
public class Main {
    public static Set<Integer> numSet = new TreeSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            numSet.add(num);
        }
        
        Iterator<Integer> it = numSet.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()) {
            int num = it.next();
            sb.append(num).append("\n");
        }
        
        System.out.print(sb);
    }
}