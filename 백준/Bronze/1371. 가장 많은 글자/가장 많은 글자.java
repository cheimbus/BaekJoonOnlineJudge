import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new TreeMap<>();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        
        String inputLine;
        while((inputLine = br.readLine()) != null) {
            sb1.append(inputLine);
        }
        
        String line = sb1.toString(); 
        String[] split = line.split(" ");
        
        for (String s : split) {
            sb2.append(s);
        }
        
        line = sb2.toString();
        
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
       
        int maxVal = -1;
        StringBuilder sb3 = new StringBuilder();
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int val = entry.getValue();
            if (val > maxVal) {
                maxVal = val;
                sb3.setLength(0);
                sb3.append(entry.getKey());
            } else if (val == maxVal) {
                sb3.append(entry.getKey());
            }
        }

        System.out.print(sb3.toString());
    }
}
