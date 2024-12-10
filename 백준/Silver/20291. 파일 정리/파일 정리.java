import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
    public static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while(n -- > 0) {
            String[] arr = br.readLine().split("\\.");
            String s = arr[1];

            if(map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            }
            else {
                map.put(s, 1);
            }
        }

        TreeMap<String, Integer> tree = new TreeMap<>(map);
        StringBuilder sb = new StringBuilder();
        for(var entry : tree.entrySet()) {
            String s = entry.getKey();
            Integer i = entry.getValue();

            sb.append(s + " " + i).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
    }
}