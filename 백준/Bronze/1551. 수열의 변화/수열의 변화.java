import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stk.nextToken());
        int k = Integer.parseInt(stk.nextToken());

        ArrayList<Integer> arr = new ArrayList<>();
        stk = new StringTokenizer(br.readLine(), ",");

        for(int i = 0; i < n; i ++) {
            arr.add(Integer.parseInt(stk.nextToken()));
        }

        int size = arr.size();
        for(int i = 0; i < k; i ++) {
            size --;
            for(int j = 0; j < size; j ++) {
                int val = arr.get(j + 1) - arr.get(j);
                arr.set(j, val);
            }
            arr.remove(size);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.size(); i ++) {
            sb.append(arr.get(i)).append(",");
        }
        sb.setLength(sb.length() -1);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}