import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {
    public static char[][] orderList = new char[][]{
            {'A','C','A','G'},
            {'C','G','T','A'},
            {'A','T','C','G'},
            {'G','A','G','T'}
    };

    public static int getCordinate(char an) {
        if(an == 'A') return 0;
        else if(an == 'G') return 1;
        else if(an == 'C') return 2;
        else return 3;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] order = br.readLine().toCharArray();

        for(int i = n - 1; i > 0; i --) {
            char cAn = order[i];
            char cAn1 = order[i - 1];

            int an = getCordinate(cAn);
            int an1 = getCordinate(cAn1);
            char target = orderList[an][an1];
            order[i - 1] = target;
        }

        bw.write(order[0]);
        bw.flush();
        bw.close();
    }
}