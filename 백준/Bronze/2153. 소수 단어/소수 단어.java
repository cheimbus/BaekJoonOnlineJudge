import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class Main {

    public static boolean isPrimeNum(int n) {
        for(int i = 2; i < n; i ++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] sen = br.readLine().toCharArray();

        StringBuilder sb = new StringBuilder();
        int num = 0;
        for(char c : sen) {
            if('a' <= c && c <= 'z') num += c - 96;
            else if('A' <= c && c <= 'Z') num += c - 38;
        }
        if(num == 1) sb.append("It is a prime word.");
        else if(isPrimeNum(num)) sb.append("It is a prime word.");
        else sb.append("It is not a prime word.");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}