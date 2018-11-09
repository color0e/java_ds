import java.util.EmptyStackException;
import java.util.Scanner;

public class Calc implements Calcinterface{
	public int num_length(String exp) {
		int count=0;
		int index=0;
		char[] ch = exp.toCharArray();
		for(char c : ch) {
			index=(int)c-'A';
			if(index<=25&&index>=0) {
				count++;
			}else{
			    
			}//else
		}//for
		return count;
	}
	@Override
	public String Reverse(String xp) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String PFExpression(String infix) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double PFCalculation(String exp, Double[] v) {
		// TODO Auto-generated method stub
		ListStack<Double> stack = new ListStack<Double>();
		char[] ch=exp.toCharArray();
		Double[] num=new Double[2];
		int index;
		Double result=0.0;
		
		for(char c : ch) {
			index=(int)c-'A';
			if(index<=25&&index>=0) {
				//System.out.println(index);
				//System.out.println(v[index]);
			stack.push(v[index]);
			}else{
			switch(c) {
			case '+':
				num[0]=stack.pop();
			    num[1]=stack.pop();
			    result = num[1]+num[0];
				stack.push(result);
				break;
			case '-':
				num[0]=stack.pop();
			    num[1]=stack.pop();
			    result = num[1]-num[0];
				stack.push(result);
				break;
			case '*':
				num[0]=stack.pop();
			    num[1]=stack.pop();
			    result = num[1]*num[0];
				stack.push(result);
				break;
			case '/':
				num[0]=stack.pop();
			    num[1]=stack.pop();
			    result = num[1]/num[0];
				stack.push(result);
				break;
			default:
				System.out.println("�߸��� �Է°��Դϴ�.");
				return null;
			}//switch
			
			}//else
		}//for
		return stack.pop();
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
		public ListStack() {   // ���� ������
			top = null;
			size = 0;
		}
		public int     size()    { return size;}      // ������ �׸��� ���� ����
		public boolean isEmpty() { return size == 0;} // ������ empty�̸� true ����	
		public void push(E newItem){  // ���� push ����
			Node newNode = new Node(newItem, top);  // ����Ʈ �պκп� ����
			top = newNode;                          // top�� �� ��� ����Ŵ
			size++;                                 // ���� �׸� �� 1 ����
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
	
	public static void main(String[] args) {
		//3�� ����
		String exp = "ABC*+D/";
		//String exp = "BC*A+D-";
		Calc c = new Calc();
		Double[] num=new Double[c.num_length(exp)];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<c.num_length(exp);i++) {
			System.out.print("�ǿ�����"+(char)('A'+i)+":");
		num[i]=sc.nextDouble();
		//System.out.println(num[i]);
		}
		System.out.println(c.PFCalculation(exp, num));
	}
	
}
