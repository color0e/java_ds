import java.util.EmptyStackException;
import java.util.Scanner;

public class Calc{
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
	public String Reverse(String xp) {
		// TODO Auto-generated method stub
		ListStack<Character> stack = new ListStack<Character>();
		StringBuilder result = new StringBuilder();
	      for(char c : xp.toCharArray()) {
	      stack.push(c);
	      }
	      while(!stack.isEmpty()) 
	      {
	       result.append(stack.pop());
	      }
		return result.toString();
	}

	public String PFExpression(String infix) {
		// TODO Auto-generated method stub
		int index;
		Character c2;
		Character top;
		StringBuilder result = new StringBuilder();
		ListStack<Character> stack = new ListStack<Character>();
		for(char c : infix.toCharArray()) {
			index = (int)c-'A';
			if(index<=25&&index>=0) {
			  result.append(c);
			  System.out.print(c+"=>");
			}else if(c=='(') {
				stack.push(c);
			}else if(c==')') {
				while(true) {
					c2 = stack.pop();
					if(c2=='(') {
						break;
					}else {
						result.append(c2);
						System.out.print(c2+"=>");
					}
				}
			}else {
				switch(c) {
				case '+':
				case '-':
					while(!stack.isEmpty()&&(stack.peek()=='*'||stack.peek()=='/')) {
						c2=stack.pop();
						result.append(c2);
						System.out.print(c2+"=>");
					}
					stack.push(c);
					break;
				case '*':
				case '/':
					stack.push(c);
					break;
				default:
					break;
				}
			}
		}
		while(!stack.isEmpty()) {
			char c3=stack.pop();
			result.append(c3);
			System.out.print(c3+"=>");
		}
		
		return result.toString();
	}

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
		Calc c = new Calc();
		String infix = "A*(B+C/D)";
		String infix2 = "A+(B*C-D)";
		System.out.println("���� 1:"+infix);
		System.out.println("���� 2:"+infix2);
		//1������
		System.out.println("1. ����ǥ������� ǥ���� ���� "+infix+"�� ���ڿ��� �������� ��� ");
	    System.out.println(c.Reverse(infix));
	    System.out.println("   ����ǥ������� ǥ���� ���� "+infix2+"�� ���ڿ��� �������� ��� ");
	    System.out.println(c.Reverse(infix2));
		//2������
	    System.out.print("2. ����ǥ���:"+infix+"�� ��ȯ���� :");
		String postfix = c.PFExpression(infix);
		//System.out.println(postfix);
		System.out.println();
		System.out.print("   ����ǥ���:"+infix2+"�� ��ȯ���� :");
		String postfix2 = c.PFExpression(infix2);
		System.out.println();
		//System.out.println(postfix2);
		//3�� ����
		System.out.println("3. ����ǥ���:"+postfix);
		String exp = postfix;
		//String exp = "BC*A+D-";
		Double[] num=new Double[c.num_length(exp)];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<c.num_length(exp);i++) {
			System.out.print("�ǿ�����"+(char)('A'+i)+":");
		num[i]=sc.nextDouble();
		//System.out.println(num[i]);
		}
		System.out.println("   ����ǥ���:"+postfix2);
		String exp2 = postfix2;
		//String exp = "BC*A+D-";
		Double[] num2=new Double[c.num_length(exp2)];
		for(int i=0;i<c.num_length(exp2);i++) {
			System.out.print("�ǿ�����"+(char)('A'+i)+":");
		num2[i]=sc.nextDouble();
		//System.out.println(num[i]);
		}		
		System.out.println("4."+postfix+"������:"+c.PFCalculation(exp, num));
		System.out.println("  "+postfix2+"������:"+c.PFCalculation(exp2, num2));
	}
	
}
