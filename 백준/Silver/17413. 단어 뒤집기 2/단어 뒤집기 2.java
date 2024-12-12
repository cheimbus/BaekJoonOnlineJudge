import java.io.*;
import java.util.*;

public class Main {
    public static char[] arr;
    public static StringBuilder sb = new StringBuilder();
    public static Stack<Character> st = new Stack<>();

    public static void print() {
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }
    }

    public static void impl() {
        boolean flag = false;
        for(int i = 0; i < arr.length; i ++) {
            char val = arr[i];
            if(val == '<') {
                print();
                sb.append('<');
                flag = true;
            }
            else if(val == '>') {
                sb.append('>');
                flag = false;
            }
            else if(flag) {
                sb.append(val);
            }
            else {
                if(val == ' ') {
                    print();
                    sb.append(' ');
                }
                else {
                    st.push(val);
                }
            }
        }
        print();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = br.readLine().toCharArray();

        impl();

        bw.write(sb.toString());
        bw.flush();
    }
}