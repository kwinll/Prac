package C1_Stack_Queue;

import java.util.Stack;

public class Pro3_ReverseAStack {

	public static int getAndRemoveLastElement(Stack<Integer> stack) {
		int result = stack.pop();
		if (stack.isEmpty())
			return result;
		int lastOne = getAndRemoveLastElement(stack);
		stack.push(result);
		return lastOne;
	}

	public static void revese(Stack<Integer> stack) {
		if (stack.isEmpty())
			return;
		int last = getAndRemoveLastElement(stack);
		revese(stack);
		stack.push(last);
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		stack.add(1);
		stack.add(2);
		stack.add(3);
		stack.add(4);
		stack.add(5);

		revese(stack);

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());

		}
	}

}
