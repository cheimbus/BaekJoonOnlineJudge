import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        ArrayList<Character> playerLi = new ArrayList<>();
        Map<Character, Integer> player = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char s = br.readLine().charAt(0);
            player.put(s, player.getOrDefault(s, 0) +1);
            if(player.get(s) == 5) {
                playerLi.add(s);
            }
        }
        
        Collections.sort(playerLi);
        for(Character c : playerLi) {
            sb.append(c);
        }
        
        if(sb.length() > 0) {
            System.out.print(sb.toString());
        }
        else {
            System.out.print("PREDAJA");
        }
    }
}