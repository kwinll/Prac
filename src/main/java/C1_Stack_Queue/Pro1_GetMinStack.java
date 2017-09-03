package C1_Stack_Queue;

import org.omg.CORBA.INTERNAL;

import java.util.Stack;

public class Pro1_GetMinStack {
	class StackTwo {

		private Stack<Integer> data;
		private Stack<Integer> dataMin;

		public StackTwo() {

			data = new Stack<Integer>();
			dataMin = new Stack<Integer>();
		}

		public void push(Integer value) {
			if (dataMin.isEmpty()) {
				dataMin.push(value);
			} else if (dataMin.peek() >= value) {
				dataMin.push(value);
			} else {
				dataMin.push(dataMin.peek());
			}
			;
			data.push(value);
		}

		public Integer pop() {
			if (data.isEmpty())
				throw new RuntimeException("The stack is emptu");
			dataMin.pop();
			return data.pop();

		}

		public Integer getMin() {
			if (dataMin.isEmpty())
				throw new RuntimeException("No element");
			return dataMin.peek();
		}

		public boolean isEmpty() {
			return data.isEmpty();
		}
	}

	class StackOne {
		private Stack<Integer> data;
		private Stack<Integer> dataMin;

		public StackOne() {
			data = new Stack<Integer>();
			dataMin = new Stack<Integer>();
		}

		public void push(Integer value) {
			if (dataMin.isEmpty()) {
				dataMin.push(value);
			} else if (dataMin.peek() >= value) {
				dataMin.push(value);
			}
			data.push(value);
		}

		public Integer pop() {
			if (data.isEmpty()) {
				throw new RuntimeException("The stack is emptu");
			} else if (data.peek() == dataMin.peek()) {
				dataMin.pop();
				return data.pop();
			}
			return data.pop();
		}

		public Integer getMin() {
			if (dataMin.isEmpty())
				throw new RuntimeException("No element");
			return dataMin.peek();
		}

		public boolean isEmpty() {
			return data.isEmpty();
		}
	}

	public void testStackOne() {
		StackOne stackOne = new StackOne();
		stackOne.push(3);
		stackOne.push(4);
		stackOne.push(5);
		stackOne.push(1);
		stackOne.push(2);
		stackOne.push(1);

		while (!stackOne.isEmpty()) {
			System.out.println(stackOne.getMin());
			stackOne.pop();
		}

	}

	public void testStackTwo() {
		StackTwo stackOne = new StackTwo();
		stackOne.push(3);
		stackOne.push(4);
		stackOne.push(5);
		stackOne.push(1);
		stackOne.push(2);
		stackOne.push(1);

		while (!stackOne.isEmpty()) {
			System.out.println(stackOne.getMin());
			stackOne.pop();
		}

	}

	public static void main(String[] args) {
		Pro1_GetMinStack aGetMinStack = new Pro1_GetMinStack();
		aGetMinStack.testStackOne();
		aGetMinStack.testStackTwo();
	}

}
