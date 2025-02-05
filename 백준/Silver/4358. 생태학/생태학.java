import java.util.*;
import java.util.Map.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        TreeMap<String, Integer> tm = new TreeMap<>();
        int cnt = 0;
        String in;
        while((in = br.readLine()) != null) {
            tm.put(in, tm.getOrDefault(in, 0) + 1);
            cnt ++;
        }

        StringBuilder sb = new StringBuilder();
        Iterator<Entry<String, Integer>> it = tm.entrySet().iterator();
        while(it.hasNext()) {
            Entry<String, Integer> e = it.next();
            String s = e.getKey();
            int v = e.getValue();
            double d = (double)v / cnt * 100;
            String format = String.format("%.4f", d);
            sb.append(s + " " + format).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        br.close();
    }
}
