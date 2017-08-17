package C1_Stack_Queue;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import com.sun.org.apache.xerces.internal.impl.dv.ValidatedInfo;

public class Pro6_WindowMax {

	public static int[] getMax(int[] arr, int windowSize) {
		if (arr.length < windowSize)
			throw new RuntimeException("Can not get max window");

		int[] res = new int[arr.length - windowSize + 1];
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < arr.length; ++i) {
			while (list.size() > 0) {
				if (i - list.peekFirst() > windowSize - 1) {
					list.poll();
					continue;
				} else {
					if (arr[list.peekLast()] > arr[i]) {
						list.add(i);
						break;
					} else {
						list.pop();
					}
				}
			}

			if (list.size() == 0)
				list.add(i);

			if (i >= windowSize - 1) {
				res[i - windowSize + 1] = arr[list.peekFirst()];
			}
		}
		return res;
	}

	public static int[] getMax2(int[] arr, int windowSize) {
		if (arr.length < windowSize)
			throw new RuntimeException("Can not get max window");

		int[] res = new int[arr.length - windowSize + 1];
		LinkedList<Integer> list = new LinkedList<>();

		for (int i = 0; i < arr.length; ++i) {

			if (list.size() != 0 && i - list.peekFirst() > windowSize - 1)
				list.poll();

			if (list.size() == 0)
				list.add(i);

			if (i >= windowSize - 1) {
				res[i - windowSize + 1] = arr[list.peekFirst()];
			}
		}
		return res;
	}

	/**
	 * Assume have a list 9 8 8 6 5 4 3
	 * 
	 * if a k if k = 2, return 3's index
	 * 
	 * if k =7, return 8's index
	 * 
	 * if k >= 9 return 0
	 * 
	 **/
	public static int binarySearch(List<Integer> list, Integer key, int[] arr, int start, int end) {
		int mid = (end - start) / 2;
		if (mid == 0) {
			if (arr[list.get(mid)] > key)
				return mid;
			else {
				return -1;
			}
		} else {
			if (key > arr[list.get(mid)])
				return binarySearch(list, key, arr, start, mid - 1);
			else
				return binarySearch(list, key, arr, mid + 1, end);
		}

	}

	public static void main(String[] args) {

	}

}
