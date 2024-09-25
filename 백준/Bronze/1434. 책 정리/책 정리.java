import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static int MAX_VAL = 50;
    public static int[] box = new int[MAX_VAL];
    public static int[] book = new int[MAX_VAL];
    public static int sum = 0;
    public static int x = 0;
    public static int n,m;

    public static void sumWastedBoxes() {
        for(int i = 0; i < n; i++) {
            sum += box[i];
        }
    }

    public static void cleanBooks() {
        for(int i = 0; i < m; i ++) {
            int books = book[i];
            while(true) {
                if(box[x] < books) x++;
                else {
                    box[x] -= books;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stk = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stk.nextToken());
        m = Integer.parseInt(stk.nextToken());

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(stk.nextToken());
            box[i] = num;
        }

        stk = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            int num = Integer.parseInt(stk.nextToken());
            book[i] = num;
        }

        cleanBooks();
        sumWastedBoxes();

        bw.write(String.valueOf(sum));
        bw.flush();
        bw.close();
    }
}

