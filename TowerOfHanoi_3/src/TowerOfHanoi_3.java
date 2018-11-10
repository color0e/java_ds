
import java.util.EmptyStackException;
import java.util.Scanner;


public class TowerOfHanoi_3 {
	
	static class Disk {
		private int num;     
		private Disk next;
		public Disk(int num, Disk next){  
			this.num=num;
			this.next = next;
		}
		public Disk       getDisk() { return this; }
		public int       getNum() { return num; }
		public Disk getNext() { return next; }
		public void    setNum(int num)      { this.num = num; }
		public void    setNext(Disk next){ this.next = next; }
	}

	public static class Tower {	
		private Disk top;   
		private int size;   
		private String name;
		public Tower() {   
			top = null;
			size = 0;
		}
		public Tower(String name) {
			this.name=name;
		}
		public int     size()    { return size;}     
		public boolean isEmpty() { return size == 0;} 	
		public void push(Disk newDisk){  
			newDisk.setNext(top);  
			top = newDisk;                          
			size++;                              
		}
		public void push(Disk newDisk,String TowerName){  
			System.out.println("���� " + newDisk.getNum() + "��(��) " + TowerName + "���� " + this.getname() + "�� �ű��.");
			newDisk.setNext(top);  
			top = newDisk;                          
			size++;                              
		}
		public String getname() {
			return this.name;
		}
		public Disk peek() {  
			if (isEmpty()) throw new EmptyStackException();  
			return top.getDisk();
		}
		public Disk pop() {   
			if (isEmpty()) throw new EmptyStackException(); 
			Disk topDisk = top.getDisk();   
			top = top.getNext();         
			size--;                      
			return topDisk;
		}
	}

   public static void Hanoi(int i, Tower from, Tower mid, Tower to) {

      if (i == 1) {
    	  to.push(from.pop(),from.getname());
      } else {
         Hanoi(i - 1, from, to, mid);
         to.push(from.pop(),from.getname());
         Hanoi(i - 1, mid, from, to);
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

      System.out.println("<--��ü �̵��� �̿��� �ϳ����� ž-->");
      System.out.print("������ ������ �Է��ϼ���:");
      int num = scanner.nextInt();

      System.out.println();
      Tower Tower_A = new Tower("A"); // Ÿ��A ����
      Tower Tower_B = new Tower("B"); // Ÿ��B ����
      Tower Tower_C = new Tower("C"); // Ÿ��C ����
      for(int i=num;i>=1;i--) {
    	  Tower_A.push(new Disk(i,null)); //Ÿ���� ��ũ ����
      }
      Hanoi(num, Tower_A, Tower_B, Tower_C);
      allMoveCount(num);
   }
   
}