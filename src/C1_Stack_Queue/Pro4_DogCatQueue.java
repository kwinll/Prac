package C1_Stack_Queue;

import java.util.Queue;

public class Pro4_DogCatQueue {

	class Pet {
		private String type;

		public String getType() {
			return type;
		}

		/**
		 * @param type
		 */
		public Pet(String type) {
			this.type = type;
		}

	}

	class Cat extends Pet {

		public Cat(String type) {
			super("Cat");
			// TODO Auto-generated constructor stub
		}

	}

	class Dog extends Pet {

		public Dog(String type) {
			super("Dog");
			// TODO Auto-generated constructor stub
		}
	}

	class PetWithCounter {
		private Pet pet;

		private long count;

		public Pet getPet() {
			return pet;
		}

		public long getCount() {
			return count;
		}

		/**
		 * @param pet
		 * @param count
		 */
		public PetWithCounter(Pet pet, long count) {
			this.pet = pet;
			this.count = count;
		}

		public String getPetType() {
			return pet.getType();
		}

	}

	private Queue<PetWithCounter> catQueue;
	private Queue<PetWithCounter> dogQueue;
	private long count = 0;

	/**
	 * @param catQueue
	 * @param dogQueue
	 */
	public Pro4_DogCatQueue(Queue<PetWithCounter> catQueue, Queue<PetWithCounter> dogQueue) {
		this.catQueue = catQueue;
		this.dogQueue = dogQueue;
	}

	public void add(Pet pet) {
		if (pet.getType().equals("Dog"))
			dogQueue.add(new PetWithCounter(pet, count++));
		else if (pet.getType().equals("Cat"))
			catQueue.add(new PetWithCounter(pet, count++));
		else {
			throw new RuntimeException("Error");
		}
	}

	public Pet pollAll() {

		if (!catQueue.isEmpty() && !dogQueue.isEmpty()) {
			if (catQueue.peek().getCount() > dogQueue.peek().getCount()) {
				return dogQueue.poll().getPet();
			} else {
				return catQueue.poll().getPet();
			}
		}

		else if (!catQueue.isEmpty() && dogQueue.isEmpty()) {
			return catQueue.poll().getPet();
		} else if (!dogQueue.isEmpty() && catQueue.isEmpty()) {
			return dogQueue.poll().getPet();
		} else {
			throw new RuntimeException();
		}
	}

	public Pet pollDog() {
		return dogQueue.poll().getPet();
	}

	public Pet pollCat() {
		return catQueue.poll().getPet();
	}

	public boolean isEmpty() {
		return catQueue.isEmpty() && dogQueue.isEmpty();
	}

	public boolean isDogEmpty() {
		return dogQueue.isEmpty();
	}

	public boolean isCatEmpty() {
		return catQueue.isEmpty();
	}

}
