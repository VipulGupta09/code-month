import java.util.ArrayList;

public class ProducerConsumer {

	public static void main(String[] args) {
		
		
		ProducerConsumerMethod producerConsumerMethod = new ProducerConsumerMethod();
		Producer producer = new Producer(producerConsumerMethod);
		Thread t1 = new Thread(producer);

		Consumer consumer = new Consumer(producerConsumerMethod);
		Thread t2 = new Thread(consumer);

		t1.start();
		t2.start();

	}

}

class Producer implements Runnable {
	ProducerConsumerMethod pcmObject;

	@Override
	public void run() {
		try {
			pcmObject.producere();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	Producer(ProducerConsumerMethod pcm) {
		pcmObject = pcm;
	}

}

class Consumer implements Runnable {
	ProducerConsumerMethod pcmObject;

	@Override
	public void run() {
		try {
			pcmObject.consumer();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	Consumer(ProducerConsumerMethod pcm) {
		pcmObject = pcm;
	}

}

class ProducerConsumerMethod {
	ArrayList<Integer> list = new ArrayList<Integer>();
	int maxCapacity = 2;

	public void producere() throws InterruptedException {
		int initialValue = 1;
		while (true) {
			synchronized (this) {
				if (list.size() == maxCapacity) {
					wait(); // this is in Object class
				}

				System.out.println("Producer produces value :" + initialValue);

				list.add(initialValue++);
				notify();

				Thread.sleep(2000);
			}
		}
	}

	public void consumer() throws InterruptedException {
		while (true) {
			synchronized (this) {
				if (list.size() == 0) {
					wait(); // this is in Object class
				}
				int val = list.remove(0);
				System.out.println("Consumer consumes value :" + val);

				notify();

				Thread.sleep(2000);
			}
		}
	}
}
