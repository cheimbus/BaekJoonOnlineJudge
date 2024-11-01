import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static String findSentence(String[] arr) {
        String currVal = arr[0];

        for(int i = 1; i < arr.length; i ++) {
            if(arr[i].toLowerCase().compareTo(currVal.toLowerCase()) < 0) {
                currVal = arr[i];
            }
        }
        return currVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while(!(line = br.readLine()).equals("0")) {
            int n = Integer.parseInt(line);
            String[] arr = new String[n];

            for(int i = 0; i < n; i ++) {
                arr[i] = br.readLine();
            }
            String currS = findSentence(arr);
            sb.append(currS).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}