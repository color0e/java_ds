import java.util.EmptyStackException;
import java.util.Scanner;



public class TowerOfHanoi_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListStack<Integer> towerA = new ListStack<Integer>("A");
		ListStack<Integer> towerB = new ListStack<Integer>("B");
		ListStack<Integer> towerC = new ListStack<Integer>("C");
		System.out.println("재귀함수를 사용하지 않고 stack 구조를 사용하는 알고리즘의 경우입니다.");
		System.out.print("원판의 갯수를 입력하세요:");
	      int num = sc.nextInt();
		int op_num=Hanoi(num,towerA,towerB,towerC); // 원판의 개수,타워객체A,타워객체B,타워객체C
		System.out.println("스택 자료구조와 제어문을 사용한을 사용한 알고리즘의 총 움직인 수는 "+op_num+"회 이다.");
		System.out.println();
		
		}
	public static int Hanoi(int n,ListStack<Integer> from,ListStack<Integer> by,ListStack<Integer> to) {
		ListStack<ListStack<Integer>> Stack = new ListStack<ListStack<Integer>>();
		ListStack<Integer> Stack2 = new ListStack<Integer>();
		ListStack<Integer> temp;
		int count=0;
		for(int i=n ;i>=1;i--) {
			from.push(i);
		}
		while(true) {
			while(n>1) {
				Stack.push(to);
				Stack.push(by);
				Stack.push(from);
				Stack2.push(n);
				--n;
				temp=to;
				to=by;
				by=temp;
			}
			Integer disk=from.pop();
			to.push(disk);
			System.out.println("원판 "+disk+"을 "+from.getname()+"에서 "+to.getname()+"으로 옮긴다.");
			count++;
			if(!Stack.isEmpty()) {
				n=Stack2.pop();
				from=Stack.pop();
				by=Stack.pop();
				to=Stack.pop();
				disk=from.pop();
				to.push(disk);
				System.out.println("원판 "+disk+"을 "+from.getname()+"에서 "+to.getname()+"으로 옮긴다.");
				count++;
				--n;
				temp=from;
				from=by;
				by=temp;
			}else {
				return count;
			}
		}
	}
	public static int total_op_num(int n) {
		int total=1;
		for(int i=0;i<n;i++) {
			total=total*2;
		}
		return total-1;
	}
	static class Node <E> {
		private E       item;     
		private Node<E> next;
		public Node(E newItem, Node<E> node){  // 생성자
			item = newItem;
			next = node;
		}
		// get 메소드들과 set 메소드들
		public E       getItem() { return item; }
		public Node<E> getNext() { return next; }
		public void    setItem(E newItem)      { item = newItem; }
		public void    setNext(Node<E> newNext){ next = newNext; }
	}

	static public class ListStack <E> {	
		private Node<E> top;   // 스택 top 항목을 가진  Node를 가리키기 위해
		private int size;      // 스택의 항목 수
		private String name;
		public ListStack() {   // 스택 생성자
			top = null;
			size = 0;
		}
		public ListStack(String name) {
			top = null;
			size = 0;
			this.name=name;
		}
		public int     size()    { return size;}      // 스택의 항목의 수를 리턴
		public boolean isEmpty() { return size == 0;} // 스택이 empty이면 true 리턴	
		public void push(E newItem){  // 스택 push 연산
			Node newNode = new Node(newItem, top);  // 리스트 앞부분에 삽입
			top = newNode;                          // top이 새 노드 가리킴
			size++;                                 // 스택 항목 수 1 증가
		}
		public String getname() {
			return this.name;
		}
		public E peek() {  // 스택 top 항목만을 리턴
			if (isEmpty()) throw new EmptyStackException(); // underflow 시 프로그램 정지 
			return top.getItem();
		}
		public E pop() {   // 스택 pop연산
			if (isEmpty()) throw new EmptyStackException(); // underflow 시 프로그램 정지
			E topItem = top.getItem();   // 스택 top 항목을 topItem에 저장
			top = top.getNext();         // top이 top 바로 아래 항목을 가리킴
			size--;                      // 스택 항목 수를 1 감소
			return topItem;
		}	
		public void print() { // 스택의 항목들을 top부터 차례로 출력
			if (isEmpty()) System.out.print("스택이 비어있음.");      
			else 
				for (Node p = top; p != null; p = p.getNext()) 
					System.out.print(p.getItem()+"\t ");
			System.out.println();
		}
	}
}
