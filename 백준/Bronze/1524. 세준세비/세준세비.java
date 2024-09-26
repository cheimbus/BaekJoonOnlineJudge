import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String l = br.readLine();

            StringTokenizer stk = new StringTokenizer(br.readLine());
            int sj = Integer.parseInt(stk.nextToken());
            int sb = Integer.parseInt(stk.nextToken());

            ArrayList<Integer> sjArr = new ArrayList<>();
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < sj; j++) {
                sjArr.add(Integer.parseInt(stk.nextToken()));
            }

            ArrayList<Integer> sbArr = new ArrayList<>();
            stk = new StringTokenizer(br.readLine());
            for (int j = 0; j < sb; j++) {
                sbArr.add(Integer.parseInt(stk.nextToken()));
            }

            int sjMax = Collections.max(sjArr);
            int sbMax = Collections.max(sbArr);

            if (sjMax >= sbMax) stb.append("S\n");
            else if(sjMax < sbMax) stb.append("B\n");
            else stb.append("C\n");
        }

        bw.write(stb.toString());
        bw.flush();
        bw.close();
    }
}
