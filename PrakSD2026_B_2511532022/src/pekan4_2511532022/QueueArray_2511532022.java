package pekan4_2511532022;

public class QueueArray_2511532022 {
	int front_2022, rear_2022, size_2022;
	int capacity_2022;
	int array_2022[];
	
	public QueueArray_2511532022(int capacity_2022) {
		this.capacity_2022 = capacity_2022;
		front_2022 = this.size_2022 = 0;
		rear_2022 = capacity_2022 - 1;
		array_2022 = new int[this.capacity_2022];
	}
	
	boolean isFull(QueueArray_2511532022 queue) {
		return (queue.size_2022 == queue.capacity_2022);
	}
	
	boolean isEmpty(QueueArray_2511532022 queue) {
		return (queue.size_2022 == 0);
	}
	
	void enqueue_2022(int item) {
		if (isFull(this))
			return;
		this.rear_2022 = (this.rear_2022 + 1) % this.capacity_2022;
		this.array_2022 [this.rear_2022] = item;
		this.size_2022 = this.size_2022 + 1;
		System.out.println(item + "enqueue to queue");
	}
	
	int dequeue_2022() {
		if (isEmpty(this))
			return Integer.MIN_VALUE;
		int item = this.array_2022[this.front_2022];
		this.front_2022 = (this.front_2022 +1 ) % this.capacity_2022;
		this.size_2022 = this.size_2022 - 1;
		return item;
	}
	
	int front_2022() {
		if (isEmpty (this))
			return Integer.MIN_VALUE;
		
		return this.array_2022[this.front_2022];
	}
	
	int rear_2022() {
		if (isEmpty (this))
			return Integer.MIN_VALUE;
		
		return this.array_2022[this.rear_2022];
	}
	
	//mencetak elemen antrian
	void display_2022() {
		int i;
		if (front_2022 == rear_2022) {
			System.out.printf("\nAntrian Kosong\n");
			return;
		}
		//kunjungi dari belakang dan cetak
		for (i = front_2022; i < rear_2022; i++) {
			System.out.printf(" %d <--", array_2022[i]);
		}
		return;
	}
}

