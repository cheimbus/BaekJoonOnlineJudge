import java.util.*;
import java.io.*;

public class Main {
    public static int n;
    public static StringBuilder sb = new StringBuilder();

    public static void find(char[] cArr) {
            Stack<Character> st = new Stack<>();

            for(char c : cArr) {
                if(c == '(') st.push(c);
                else if(c == ')') {
                    if(st.isEmpty()) {
                        sb.append("NO" + "\n");
                        return;
                    }
                    else {
                        st.pop();
                    }
                }
            }
            if(st.isEmpty()) sb.append("YES" + "\n");
            else sb.append("NO" + "\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        while(n -- > 0) {
            char[] cArr = br.readLine().toCharArray();
            find(cArr);
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
