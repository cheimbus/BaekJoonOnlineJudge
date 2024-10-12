import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int[] ASCII_CODE = new int[127];

    public static void findNum(String s) {
        char[] message = s.toCharArray();

        int val = 0;
        for(int i = message.length - 1; i >= 0; i --) {
            int j = message.length - 1 - i;
            char firstMessage = message[j];

            int num = ASCII_CODE[firstMessage];
            int squareNum = (int) Math.pow(8, i);
            val += num * squareNum;
        }

        sb.append(val).append("\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        ASCII_CODE['-'] = 0;
        ASCII_CODE['\\'] = 1;
        ASCII_CODE['('] = 2;
        ASCII_CODE['@'] = 3;
        ASCII_CODE['?'] = 4;
        ASCII_CODE['>'] = 5;
        ASCII_CODE['&'] = 6;
        ASCII_CODE['%'] = 7;
        ASCII_CODE['/'] = -1;

        while(true) {
            String s = br.readLine();
            if(s.equals("#")) break;

            findNum(s);
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}