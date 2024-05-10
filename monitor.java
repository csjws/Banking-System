import java.util.Scanner;
import java.util.*;
public class monitor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("==========================================");
        System.out.println("숫자를 제외한 원하시는 작업을 입력해주세요");
        System.out.println("==========================================");
        System.out.println("1. 로그인     2.회원가입     3. 비밀번호찾기");
        System.out.print("입력 : ");
        String sp= sc.next();


        System.out.println("<<Bank System>>");
        System.out.println("==========================================");
        System.out.println("숫자를 제외한 원하시는 작업을 입력해주세요");
        System.out.println("==========================================");
        System.out.println("1. 입금하기     2.출금하기     3. 계좌이체하기");
        System.out.println("4. 잔액조회     5.환율        6. 비밀번호변경");
        System.out.println("7. 회원탈퇴     8.Exit");
        System.out.print("입력 : ");
        String s= sc.next();
    }
}
