import java.util.*;
import java.io.*;

public class Main {
    public static int n, m;
    public static ArrayList<Integer> arr = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        Deque<String> dq = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        while(n -- > 0) {
            String[] sArr = br.readLine().split(" ");
            if(sArr[0].equals("push_front")) {
                dq.addFirst(sArr[1]);
            }
            else if(sArr[0].equals("push_back")) {
                dq.add(sArr[1]);
            }
            else if(sArr[0].equals("pop_front")) {
                if(dq.isEmpty()) sb.append(-1 + "\n");
                else sb.append(dq.poll() + "\n");
            }
            else if(sArr[0].equals("pop_back")) {
                if(dq.isEmpty()) sb.append(-1 + "\n");
                else sb.append(dq.pollLast() + "\n");
            }
            else if(sArr[0].equals("size")) {
                sb.append(dq.size() + "\n");
            }
            else if(sArr[0].equals("empty")) {
                if(dq.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            }
            else if(sArr[0].equals("front")) {
                if(dq.isEmpty()) sb.append(-1 + "\n");
                else sb.append(dq.peek() + "\n");
            }
            else if(sArr[0].equals("back")) {
                if(dq.isEmpty()) sb.append(-1 + "\n");
                else sb.append(dq.peekLast() + "\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
