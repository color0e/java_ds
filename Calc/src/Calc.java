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
				System.out.println("잘못된 입력값입니다.");
				return null;
			}//switch
			
			}//else
		}//for
		return stack.pop();
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
		public ListStack() {   // 스택 생성자
			top = null;
			size = 0;
		}
		public int     size()    { return size;}      // 스택의 항목의 수를 리턴
		public boolean isEmpty() { return size == 0;} // 스택이 empty이면 true 리턴	
		public void push(E newItem){  // 스택 push 연산
			Node newNode = new Node(newItem, top);  // 리스트 앞부분에 삽입
			top = newNode;                          // top이 새 노드 가리킴
			size++;                                 // 스택 항목 수 1 증가
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
	
	public static void main(String[] args) {
		//3번 문제
		String exp = "ABC*+D/";
		//String exp = "BC*A+D-";
		Calc c = new Calc();
		Double[] num=new Double[c.num_length(exp)];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<c.num_length(exp);i++) {
			System.out.print("피연산자"+(char)('A'+i)+":");
		num[i]=sc.nextDouble();
		//System.out.println(num[i]);
		}
		System.out.println(c.PFCalculation(exp, num));
	}
	
}
