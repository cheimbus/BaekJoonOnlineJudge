import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static String[] commendArr;
    public static ArrayList<Character> charLi = new ArrayList<>();
    
    public static void findCommend() {
        int length = commendArr[0].length();  // 첫 번째 문자열의 길이를 기준으로
        for (int i = 0; i < length; i++) {
            char currentChar = commendArr[0].charAt(i);  // 첫 번째 문자열의 i번째 문자
            boolean isSame = true;
            
            // 다른 문자열들과 비교
            for (int j = 1; j < commendArr.length; j++) {
                if (commendArr[j].charAt(i) != currentChar) {
                    isSame = false;
                    break;
                }
            }
            
            if (isSame) {
                charLi.add(currentChar);  // 모두 같으면 해당 문자를 추가
            } else {
                charLi.add('?');  // 다르면 '?' 추가
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());  // 문자열의 개수
        
        commendArr = new String[n];  // n개의 문자열을 담을 배열 생성
        
        for (int i = 0; i < n; i++) {
            commendArr[i] = br.readLine();  // 각 문자열 입력받기
        }
        
        findCommend();  // 공통 패턴 찾기
        
        StringBuilder sb = new StringBuilder();
        
        for (Character ch : charLi) {
            sb.append(ch);  // 결과 문자열 생성
        }
        System.out.print(sb);  // 출력
    }
}
