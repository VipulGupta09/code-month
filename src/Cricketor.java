import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Batsman {
	private String name;
	private int average;
	private int strikeRate;

	public Batsman() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAverage() {
		return average;
	}

	public void setAverage(int average) {
		this.average = average;
	}

	public int getStrikeRate() {
		return strikeRate;
	}

	public void setStrikeRate(int strikeRate) {
		this.strikeRate = strikeRate;
	}

	public Batsman(String name, int average, int strikeRate) {
		this.name = name;
		this.average = average;
		this.strikeRate = strikeRate;
	}

	@Override
	public String toString() {
		return "Batsman [name=" + name + ", average=" + average + ", strikeRate=" + strikeRate + "]";
	}

}

class SortByaverage implements Comparator<Batsman> {

	@Override
	public int compare(Batsman o1, Batsman o2) {
		if (o1.getAverage() < o2.getAverage())
			return 1;
		return -1;
	}

}

class SortByStrikeRate implements Comparator<Batsman> {

	@Override
	public int compare(Batsman o1, Batsman o2) {
		if (o1.getStrikeRate() > o2.getStrikeRate())
			return 1;
		return -1;
	}

}

public class Cricketor {

	public static void main(String[] args) {
		Batsman batsman1 = new Batsman("abc", 100, 124);
		Batsman batsman2 = new Batsman("def", 90, 120);
		Batsman batsman3 = new Batsman("ghi", 50, 99);
		Batsman batsman4 = new Batsman("jkl", 90, 34);

		ArrayList<Batsman> list = new ArrayList<Batsman>();
		list.add(batsman1);
		list.add(batsman2);
		list.add(batsman3);
		list.add(batsman4);

		Collections.sort(list, new SortByaverage());
		Collections.sort(list, new SortByStrikeRate());

		System.out.println(list.toString());
	}

}

// Bastsman nam in decreasing order of avg, if avg is same, increasing order of strike rate