import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    public static String[][] sArr = new String[8][8];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 8; i++) {
            String line = br.readLine();
            for(int j = 0; j < 8; j++) {
                sArr[i][j] = String.valueOf(line.charAt(j));
            }
        }
        
        int cnt = 0;
        
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(i % 2 == 0 && j % 2 == 0 && sArr[i][j].equals("F")) cnt++;
                else if(i % 2 == 1 && j % 2 == 1 && sArr[i][j].equals("F")) cnt++;
            }
        }
        System.out.print(cnt);
    }
}