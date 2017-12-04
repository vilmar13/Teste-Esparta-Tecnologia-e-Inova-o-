
public class Euclidean {
	private int N, M;
	
	public Euclidean(int N, int M) {
		this.M = M;
		this.N = N;
	}

	public int solution() {
		int value = 1;
		int x = 0;
		while((x=((x + M)%N))!=0) {
			value++;
		}
		
		return value;
	}
	
	
	
	
	public static void main(String[] args) {
		Euclidean euclidean = new Euclidean(10, 4);
		System.out.println("The number of chocolates that you will eat is: "+euclidean.solution());
	}
}
