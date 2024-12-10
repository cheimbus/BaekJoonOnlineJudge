import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    public static char[] cArr;
    public static boolean[] visited;
    public static char[] tmp = new char[]{'q', 'u', 'a', 'c', 'k'};
    public static int cnt;

    public static void impl() {
        if(cArr[0] != 'q' || cArr.length % 5 != 0) {
            cnt = -1;
            return;
        }

        int idx = 0;
        for(int i = 0; i < cArr.length; i ++) {
            ArrayList<Character> list = new ArrayList<>();
            for(int j = i; j < cArr.length; j ++) {
                if(!visited[j] && cArr[j] == tmp[idx]) {
                    idx ++;
                    visited[j] = true;
                    list.add(cArr[j]);

                    if(idx == 5) {
                        idx = 0;
                    }
                }
            }
            if(!list.isEmpty()) {
                if(list.get(list.size() - 1) != 'k') {
                    cnt = - 1;
                    return;
                }
                cnt ++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        cArr = br.readLine().toCharArray();
        visited = new boolean[cArr.length];

        impl();

        bw.write(cnt + "");
        bw.flush();
    }
}