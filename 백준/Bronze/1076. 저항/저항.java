import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    public static String[][] regiArr = {
        {"black", "0", "1"},
        {"brown", "1", "10"},
        {"red", "2", "100"},
        {"orange", "3", "1000"},
        {"yellow", "4", "10000"},
        {"green", "5", "100000"},
        {"blue", "6", "1000000"},
        {"violet", "7", "10000000"},
        {"grey", "8", "100000000"},
        {"white", "9", "1000000000"}
    };
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        long registance;
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0; i < 2; i++) {
            String regi = br.readLine();
            for(int j = 0; j < regiArr.length; j++) {
                if(regi.equals(regiArr[j][0])) {
                    sb.append(regiArr[j][1]);
                    break;
                }
            }
        }
        registance = Long.parseLong(sb.toString());
        String regi = br.readLine();
        for(int i = 0; i < regiArr.length; i++) {
            if(regi.equals(regiArr[i][0])) {
                registance *= Integer.parseInt(regiArr[i][2]);
                break;
            }
        }
        
        System.out.print(registance);
    }
}