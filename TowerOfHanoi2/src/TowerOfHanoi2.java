import java.util.Scanner;

public class TowerOfHanoi2 {
   public static void hanoiRecursion(int i, char from, char mid, char to) {

      if (i == 1) {
         System.out.println("원판 " + i + "을(를) " + from + "에서 " + to + "로 옮긴다.");
      } else {
         hanoiRecursion(i - 1, from, to, mid);
         System.out.println("원판 " + i + "을(를) " + from + "에서 " + to + "로 옮긴다.");
         hanoiRecursion(i - 1, mid, from, to);
      }

   }

   public static int allMoveCount(int i) {
      int hanoi = 1;
      int x = 0;
      int result = 0;

      for (x = 1; x <= i; x++) {
         hanoi *= 2;
      }
      result = hanoi - 1;
      System.out.println("원판이 총 움직인 횟수는 " + result + "회이다.");

      return result;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("<--재귀를 이용한 하노이의 탑-->");
      System.out.print("원판의 갯수를 입력하세요:");
      int num = scanner.nextInt();
      hanoiRecursion(num, 'A', 'B', 'C');
      allMoveCount(num);
   }
}