import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());

        HashMap<String, String> hm1 = new HashMap<>();
        HashMap<String, String> hm2 = new HashMap<>();
        for(int i = 1; i <= n; i ++) {
            String s = br.readLine();
            hm1.put(s, i + "");
            hm2.put(i + "", s);
        }

        StringBuilder sb = new StringBuilder();
        while(m -- > 0) {
            String s = br.readLine();

            if(hm1.containsKey(s)) sb.append(hm1.get(s)).append("\n");
            else sb.append(hm2.get(s)).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
