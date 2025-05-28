import java.io.*;
import java.util.*;

public class Main {
    public static Stack<Character> st = new Stack<>();
    public static boolean flag;
    public static StringBuilder sb = new StringBuilder();

    public static void pop() {
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] cArr = br.readLine().toCharArray();

        for(char c : cArr) {
            if(c == '<') {
                pop();
                flag = true;
                sb.append(c);
            }
            else if(c == '>') {
                flag = false;
                sb.append(c);
            }
            else if(flag) {
                sb.append(c);
            }
            else {
                if(c == ' ') {
                    pop();
                    sb.append(' ');
                }
                else {
                    st.add(c);
                }
            }
        }
        pop();

        bw.write(sb.toString());
        bw.flush();
    }
}