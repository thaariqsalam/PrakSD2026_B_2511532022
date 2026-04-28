package pekan4_2511532022;

public class QueueArrayDriver_2511532022 {
	public static void main(String[]args) {
	QueueArray_2511532022 queue = new QueueArray_2511532022(1000);
	queue.enqueue_2022(10);
	queue.enqueue_2022(20);
	queue.enqueue_2022(30);
	queue.enqueue_2022(40);
	System.out.println("Item di depan " + queue.front_2022());
	System.out.println("item paling belakang " + queue.rear_2022());
	System.out.println("tampilkan queue");
	queue.display_2022();
	System.out.println();
	System.out.println(queue.dequeue_2022 () + " dihapus dari queue");
	System.out.println("item di depan: " + queue.front_2022());
	System.out.println("item di belakang: " + queue.rear_2022());
	System.out.println("tampilkan queue setelah satu kata di hapus");
	queue.display_2022();
	}
}











