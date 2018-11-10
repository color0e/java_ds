import java.util.EmptyStackException;
import java.util.Scanner;



public class TowerOfHanoi_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListStack<Integer> towerA = new ListStack<Integer>("A");
		ListStack<Integer> towerB = new ListStack<Integer>("B");
		ListStack<Integer> towerC = new ListStack<Integer>("C");
		System.out.println("����Լ��� ������� �ʰ� stack ������ ����ϴ� �˰����� ����Դϴ�.");
		System.out.print("������ ������ �Է��ϼ���:");
	      int num = sc.nextInt();
		int op_num=Hanoi(num,towerA,towerB,towerC); // ������ ����,Ÿ����üA,Ÿ����üB,Ÿ����üC
		System.out.println("���� �ڷᱸ���� ����� ������� ����� �˰����� �� ������ ���� "+op_num+"ȸ �̴�.");
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
			System.out.println("���� "+disk+"�� "+from.getname()+"���� "+to.getname()+"���� �ű��.");
			count++;
			if(!Stack.isEmpty()) {
				n=Stack2.pop();
				from=Stack.pop();
				by=Stack.pop();
				to=Stack.pop();
				disk=from.pop();
				to.push(disk);
				System.out.println("���� "+disk+"�� "+from.getname()+"���� "+to.getname()+"���� �ű��.");
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
		public Node(E newItem, Node<E> node){  // ������
			item = newItem;
			next = node;
		}
		// get �޼ҵ��� set �޼ҵ��
		public E       getItem() { return item; }
		public Node<E> getNext() { return next; }
		public void    setItem(E newItem)      { item = newItem; }
		public void    setNext(Node<E> newNext){ next = newNext; }
	}

	static public class ListStack <E> {	
		private Node<E> top;   // ���� top �׸��� ����  Node�� ����Ű�� ����
		private int size;      // ������ �׸� ��
		private String name;
		public ListStack() {   // ���� ������
			top = null;
			size = 0;
		}
		public ListStack(String name) {
			top = null;
			size = 0;
			this.name=name;
		}
		public int     size()    { return size;}      // ������ �׸��� ���� ����
		public boolean isEmpty() { return size == 0;} // ������ empty�̸� true ����	
		public void push(E newItem){  // ���� push ����
			Node newNode = new Node(newItem, top);  // ����Ʈ �պκп� ����
			top = newNode;                          // top�� �� ��� ����Ŵ
			size++;                                 // ���� �׸� �� 1 ����
		}
		public String getname() {
			return this.name;
		}
		public E peek() {  // ���� top �׸��� ����
			if (isEmpty()) throw new EmptyStackException(); // underflow �� ���α׷� ���� 
			return top.getItem();
		}
		public E pop() {   // ���� pop����
			if (isEmpty()) throw new EmptyStackException(); // underflow �� ���α׷� ����
			E topItem = top.getItem();   // ���� top �׸��� topItem�� ����
			top = top.getNext();         // top�� top �ٷ� �Ʒ� �׸��� ����Ŵ
			size--;                      // ���� �׸� ���� 1 ����
			return topItem;
		}	
		public void print() { // ������ �׸���� top���� ���ʷ� ���
			if (isEmpty()) System.out.print("������ �������.");      
			else 
				for (Node p = top; p != null; p = p.getNext()) 
					System.out.print(p.getItem()+"\t ");
			System.out.println();
		}
	}
}
