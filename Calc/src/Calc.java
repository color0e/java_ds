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
		Calc c = new Calc();
		String infix = "A*(B+C/D)";
		String infix2 = "A+(B*C-D)";
		System.out.println("수식 1:"+infix);
		System.out.println("수식 2:"+infix2);
		//1번문제
		System.out.println("1. 중위표기법으로 표현된 수식 "+infix+"을 문자열의 역순으로 출력 ");
	    System.out.println(c.Reverse(infix));
	    System.out.println("   중위표기법으로 표현된 수식 "+infix2+"을 문자열의 역순으로 출력 ");
	    System.out.println(c.Reverse(infix2));
		//2번문제
	    System.out.print("2. 중위표기식:"+infix+"의 변환과정 :");
		String postfix = c.PFExpression(infix);
		//System.out.println(postfix);
		System.out.println();
		System.out.print("   중위표기식:"+infix2+"의 변환과정 :");
		String postfix2 = c.PFExpression(infix2);
		System.out.println();
		//System.out.println(postfix2);
		//3번 문제
		System.out.println("3. 후위표기식:"+postfix);
		String exp = postfix;
		//String exp = "BC*A+D-";
		Double[] num=new Double[c.num_length(exp)];
		Scanner sc = new Scanner(System.in);
		for(int i=0;i<c.num_length(exp);i++) {
			System.out.print("피연산자"+(char)('A'+i)+":");
		num[i]=sc.nextDouble();
		//System.out.println(num[i]);
		}
		System.out.println("   후위표기식:"+postfix2);
		String exp2 = postfix2;
		//String exp = "BC*A+D-";
		Double[] num2=new Double[c.num_length(exp2)];
		for(int i=0;i<c.num_length(exp2);i++) {
			System.out.print("피연산자"+(char)('A'+i)+":");
		num2[i]=sc.nextDouble();
		//System.out.println(num[i]);
		}		
		System.out.println("4."+postfix+"연산결과:"+c.PFCalculation(exp, num));
		System.out.println("  "+postfix2+"연산결과:"+c.PFCalculation(exp2, num2));
	}
	
}
