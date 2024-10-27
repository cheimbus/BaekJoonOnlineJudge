import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());
        int roomCnt = 1;

        long range = 1;
        int step = 6;  
        
        while (n > range) {
            range += step * roomCnt;
            roomCnt++; 
        }

        bw.write(roomCnt + "\n"); 
        bw.flush();
        bw.close();
    }
}
