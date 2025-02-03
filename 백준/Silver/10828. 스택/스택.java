import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Stack<String> st = new Stack<>();

        StringBuilder sb = new StringBuilder();
        while(n -- > 0) {
            String[] sArr = br.readLine().split(" ");
            if(sArr[0].equals("push")) {
                st.push(sArr[1]);
            }
            else if(sArr[0].equals("pop")) {
                if(st.isEmpty()) sb.append(-1).append("\n");
                else sb.append(st.pop()).append("\n");
            }
            else if(sArr[0].equals("size")) {
                sb.append(st.size() + "\n");
            }
            else if(sArr[0].equals("empty")) {
                if(st.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            }
            else if(sArr[0].equals("top")) {
                if(st.isEmpty()) sb.append(-1 + "\n");
                else sb.append(st.peek() + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
