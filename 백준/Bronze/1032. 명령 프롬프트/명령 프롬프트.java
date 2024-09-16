import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
public class Main {
    public static String[] commendLi;
    public static ArrayList<Character> lastCommend = new ArrayList<>();
    
    public static void findCommend() {
        for(int i = 0 ; i < commendLi[0].length(); i++) {
            char curCommend = commendLi[0].charAt(i);
            boolean isSame = true;
            
            for(int j = 1; j < commendLi.length; j++) {
                if(curCommend != commendLi[j].charAt(i)) {
                    isSame = false;
                    lastCommend.add('?');
                    break;
                }
            }
            if(isSame) {
                lastCommend.add(curCommend);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        commendLi = new String[n];
        for(int i = 0; i < n; i++) {
            commendLi[i] = br.readLine();
        }
        
        findCommend();
        
        StringBuilder sb = new StringBuilder();
        for(char c : lastCommend) {
            sb.append(c);
        }
        System.out.print(sb);
    }
}