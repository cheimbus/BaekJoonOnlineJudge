import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.Stack;

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
            if(arr[i] == '<') {
                print();
                sb.append(arr[i]);
                flag = true;
            }
            else if(arr[i] == '>') {
                sb.append(arr[i]);
                flag = false;
            }
            else if(flag) {
                sb.append(arr[i]);
            }
            else {
                if(arr[i] == ' ') {
                    print();
                    sb.append(" ");
                }
                else {
                    st.push(arr[i]);
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