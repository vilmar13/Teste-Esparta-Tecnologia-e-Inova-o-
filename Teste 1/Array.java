
public class Array {

	private int[] array;
	
	public Array(int[] array) {
		this.array = array;
	}
	
	public int solution() {
		
		for(int i = 0; i < array.length - 1; i++) {
			for(int j = 0; j < array.length; j++) {
				if(i == (j + 1))
					continue;
				else
					if(j == array.length - 1)
						return array[i];
					else
						if(array[i] == array[j + 1])
							break;
						
			}
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		Array array = new Array(new int[]{9,3,9,3,1,9,7,9,7,8,8,1,45,6,7,6,3,7,54,1000000000,54,45});
		int solution = array.solution();
		
		if(solution != -1)
			System.out.println("Unpaired Element: " + solution);
		else
			System.out.println("Unpaired Element can not be found");
	}
}
