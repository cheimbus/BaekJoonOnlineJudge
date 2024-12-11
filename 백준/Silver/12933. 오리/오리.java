import java.io.*;
import java.util.*;

public class Main {
    public static char[] arr;
    public static char[] tmp = new char[]{'q','u','a','c','k'};
    public static boolean[] visited;
    public static int cnt;

    public static void impl() {
        if(arr[0] != 'q' || arr.length % 5 != 0) {
            cnt = -1;
            return;
        }

        int idx = 0;
        for(int i = 0; i < arr.length; i ++) {
            ArrayList<Character> li = new ArrayList<>();
            for(int j = i; j < arr.length; j ++) {
                if(!visited[j] && arr[j] == tmp[idx]) {
                    idx ++;
                    visited[j] = true;
                    li.add(arr[j]);
                    if(idx == 5) idx = 0;
                }
            }
            if(li.size() != 0) {
                if(li.get(li.size() -1) != 'k') {
                    cnt = -1;
                    return;
                }
                cnt ++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = br.readLine().toCharArray();
        visited = new boolean[arr.length];

        impl();

        bw.write(cnt + "");
        bw.flush();
    }
}