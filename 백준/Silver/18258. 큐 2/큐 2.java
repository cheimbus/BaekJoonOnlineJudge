import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Deque<String> dq = new LinkedList<>();

        StringBuilder sb = new StringBuilder();
        while(n -- > 0) {
            String[] sArr = br.readLine().split(" ");
            if(sArr[0].equals("push")) {
                dq.add(sArr[1]);
            }
            else if(sArr[0].equals("pop")) {
                if(dq.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else sb.append(dq.pop()).append("\n");
            }
            else if(sArr[0].equals("size")) {
                sb.append(dq.size()).append("\n");
            }
            else if(sArr[0].equals("empty")) {
                if(dq.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if(sArr[0].equals("front")) {
                if(dq.peek() == null) sb.append(-1).append("\n");
                else sb.append(dq.peek()).append("\n");
            }
            else if(sArr[0].equals("back")) {
                if(dq.peekLast() == null) sb.append(-1).append("\n");
                else sb.append(dq.peekLast()).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }
}
