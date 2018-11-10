
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
			System.out.println("원판 " + newDisk.getNum() + "을(를) " + TowerName + "에서 " + this.getname() + "로 옮긴다.");
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
	      System.out.println("원판이 총 움직인 횟수는 " + result + "회이다.");

	      return result;
	   }
   
   
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.println("<--객체 이동을 이용한 하노이의 탑-->");
      System.out.print("원판의 갯수를 입력하세요:");
      int num = scanner.nextInt();

      System.out.println();
      Tower Tower_A = new Tower("A"); // 타워A 생성
      Tower Tower_B = new Tower("B"); // 타워B 생성
      Tower Tower_C = new Tower("C"); // 타워C 생성
      for(int i=num;i>=1;i--) {
    	  Tower_A.push(new Disk(i,null)); //타워에 디스크 삽입
      }
      Hanoi(num, Tower_A, Tower_B, Tower_C);
      allMoveCount(num);
   }
   
}