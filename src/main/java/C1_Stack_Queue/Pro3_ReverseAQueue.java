package C1_Stack_Queue;

import java.util.Queue;

public class Pro3_ReverseAQueue {

	private static Integer getAndRemoveTheLastOne(Queue<Integer> queue) {
		int res = queue.poll();
		if (queue.isEmpty())
			return res;
		else {
			int lastOne = getAndRemoveTheLastOne(queue);
			queue.add(res);
			return lastOne;
		}
	}

	public static void reverse(Queue<Integer> queue) {
		if (queue.isEmpty())
			return;

		int last = getAndRemoveTheLastOne(queue);
		reverse(queue);
		queue.add(last);
	}

}
