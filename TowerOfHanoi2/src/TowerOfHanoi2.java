import java.util.Scanner;

public class TowerOfHanoi2 {
   public static void hanoiRecursion(int i, char from, char mid, char to) {

      if (i == 1) {
         System.out.println("���� " + i + "��(��) " + from + "���� " + to + "�� �ű��.");
      } else {
         hanoiRecursion(i - 1, from, to, mid);
         System.out.println("���� " + i + "��(��) " + from + "���� " + to + "�� �ű��.");
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
      System.out.println("������ �� ������ Ƚ���� " + result + "ȸ�̴�.");

      return result;
   }

   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("<--��͸� �̿��� �ϳ����� ž-->");
      System.out.print("������ ������ �Է��ϼ���:");
      int num = scanner.nextInt();
      hanoiRecursion(num, 'A', 'B', 'C');
      allMoveCount(num);
   }
}