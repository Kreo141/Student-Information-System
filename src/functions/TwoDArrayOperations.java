package functions;

public class TwoDArrayOperations<T> {
	private T[][] array;
	
	public TwoDArrayOperations(T[][] array) {
		this.array = array;
	}
	
	public int findInRow(T target, int rowIndex) {
		for(int column = 0; column < array[rowIndex].length; column++) {
			if(array[rowIndex][column].equals(target)) {
				return column;
			}
		}
		
		return -1;
	}
	
	public int findInColumn(T target, int columnIndex) {
		for(int row = 0; row < array.length; row++) {
			if(array[columnIndex][row].equals(target)) {
				return row;
			}
		}
		return -1;
	}
	
	public int[] findElementAll(T target) {
		for(int row = 0; row < array.length; row++) {
			for(int column = 0; column < array[row].length; column++) {
				if(array[row][column].equals(target)) {
					return new int[] {row, column};
				}
			}
		}

		return new int[] {-1, -1};
	}
}
