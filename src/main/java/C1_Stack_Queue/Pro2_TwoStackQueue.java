package C1_Stack_Queue;

import java.util.Stack;

public class Pro2_TwoStackQueue {
	static class MyQueue {
		private Stack<Integer> pushStack;
		private Stack<Integer> popStack;

		/**
		 * @param pushStack
		 * @param popStack
		 */
		public MyQueue() {
			this.pushStack = new Stack<>();
			this.popStack = new Stack<>();
		}

		public void add(Integer value) {
			pushStack.add(value);
		}

		public Integer poll() {
			if (pushStack.isEmpty() && popStack.isEmpty())
				throw new RuntimeException("No element");
			else if (popStack.isEmpty()) {
				while (!pushStack.isEmpty()) {
					popStack.add(pushStack.pop());
				}
			}
			return popStack.pop();
		}

		public Integer peek() {
			if (pushStack.isEmpty() && popStack.isEmpty())
				throw new RuntimeException("No element");
			else if (popStack.isEmpty()) {
				while (!pushStack.isEmpty()) {
					popStack.add(pushStack.pop());
				}
			}
			return popStack.peek();
		}
		
		public boolean isEmpty(){
			return pushStack.isEmpty() && popStack.isEmpty();
		}

	}

	public static void main(String[] args) {
		MyQueue mu = new MyQueue();
		mu.add(1);
		mu.add(2);
		mu.add(3);
		mu.add(4);
		mu.add(5);

		mu.poll();
		System.out.println(mu.peek());
		mu.poll();
		System.out.println(mu.peek());
		mu.poll();
		
		mu.add(7);
		mu.add(8);
		mu.add(9);
		mu.add(10);
		mu.add(11);
		
		while(!mu.isEmpty()){
			System.out.println(mu.poll());
		}

	}
}
