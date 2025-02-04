import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Integer> st = new ArrayDeque<>();

        int num = 1;
        boolean flg = true;

        for(int i = 0; i < n; i ++) {
            int val = Integer.parseInt(br.readLine());

            while(num <= val) {
                st.push(num ++);
                sb.append("+" + "\n");
            }

            if(st.peek() == val) {
                st.pop();
                sb.append("-" + "\n");
            }
            else flg = false;
        }

        if (!flg) {
            bw.write("NO");
        } else {
            bw.write(sb.toString());
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
