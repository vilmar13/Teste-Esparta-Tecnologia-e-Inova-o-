import java.util.Vector;

public class Distinct {
	private int[] array;
	
	public Distinct(int[] array) {
		this.array = array;
	}
	
	public int solution() {
		Vector<Integer> v=new Vector<Integer>();
		boolean macth = false;
		for(int i = 0; i < array.length; i++) {
			for(int j = 0; j< v.size(); j++) {
				if(i == j)
					continue;
				if(array[i] == v.get(j)) {
					macth = true;
					break;
				}
			}
			if (macth) {
				macth = false;
			} else {
				v.add(array[i]);
			}
		}
		
		return v.size();
	}
	
	public static void main(String[] args) {
		Distinct distinct = new Distinct(new int[]{2,1,1,2,3,1,1,1,23,23,23,23,1,1,1,5,34444,44,-11,-11});
		int solution = distinct.solution();
		System.out.println("Distinct values in array: " + solution);
	}
}
