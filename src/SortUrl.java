import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;



public class SortUrl {

	public static void main(String[] args) {
		String [] str = {"www.google.com",
				 "www.fb.com",
				 "www.twitter.com",
				 "www.google.com",
				 "www.fb.com"};
		
		List<String> list = sortURL(str);
	}
	
	public static List<String> sortURL(String[] str){
		
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		for(String s : str)
			map.put(s, map.getOrDefault(s, 0)+1);
		
		List<String> list = new ArrayList<String>();
		
		PriorityQueue<String> p	 = new PriorityQueue<String>((a,b) ->{
			if(map.get(a) == map.get(b)) {
                if( a.length() == b.length())
                    return a.compareTo(b);
                return a.length() - b.length();
            }
            return map.get(b) - map.get(a);
		});
		
		p.addAll(map.keySet());
		while(!p.isEmpty())
			list.add(p.poll());
		
		return list;
		
	}
	

}
