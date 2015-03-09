package Arrays;

public class ArrayStructures {

	private static int[] theArray = new int[50];

	private static int arraySize = 10;

	public void generateRandomArray(){
		for(int i = 0; i < arraySize; i++){
			theArray[i] = (int)(Math.random()*10) + 10;
		}
	}

	public static void printArray(){
		System.out.println("----------");
		for (int i = 0; i < arraySize; i++){
			System.out.print("| " + i + " | ");
			System.out.println(theArray[i] + " |");
		}
		System.out.println("----------");
	}

	public static int getValueAtIndex(int index){
		if(index < arraySize) return theArray[index];

		return 0;
	}

	public static boolean doesArrayContainValue(int value){
		boolean valueInArray = false;

		for (int i = 0; i < theArray.length; i++) {
			if(theArray[i] == value){
				valueInArray = true;
			}
		}
		return valueInArray;
	}

	public static void deleteIndex(int index){
		if(index < arraySize){
			for (int i = 0; i < (arraySize - 1); i++) {
				theArray[i] = theArray[i + 1];
			}

			arraySize--;
		}
	}

	public static void insertValue(int value){
		if(arraySize < 50){
			theArray[arraySize] = value;
			arraySize++;
		}
	}

	public static String linearSearchForValue(int value){
		boolean valueInArray = false;
		String indexsWithValue = "";

		for (int i = 0; i < arraySize; i++) {
			if(theArray[i] == value){
				valueInArray = true;
				System.out.print(i + " ");
				indexsWithValue += i + " ";
			}
			
			printHorzArray(i, -1);
		}

		System.out.println("The value was found in the following indexes..." + indexsWithValue);
		if(!valueInArray){
			indexsWithValue = "None";
			System.out.println(indexsWithValue);
		}
		System.out.println("");
		return indexsWithValue;
	}
	
	public static void bubbleSort(){
		for(int i = arraySize - 1; i > 1; i--){
			
			for(int j = 0; j < i; j++){
				
				if(theArray[j] > theArray[j+1]){
					swapValues(j, j+1);
					printHorzArray(i, j);
				}
				printHorzArray(i, j);
				
			}
			
		}
	}
	
	public void binarySearchForValue(int value){
		
		int lowIndex = 0;
		int highIndex = arraySize - 1;
		
		while(lowIndex <= highIndex){
			int middleIndex = (highIndex + lowIndex) / 2;
			
			if(theArray[middleIndex] < value){
				lowIndex = middleIndex + 1;
			} else if (theArray[middleIndex] > value){
				highIndex = middleIndex - 1;
			} else {
				System.out.println("\nFound a match at index " + middleIndex);
				
				lowIndex = highIndex + 1;
			}
			
			printHorzArray(middleIndex, -1);
		}
	}
	
	public void selectionSort(){
		for(int x = 0; x < arraySize; x++){
			int minimum = x;
			
			for(int y = x; y < arraySize; y++){
				if(theArray[minimum] > theArray[y]){
					minimum = y;
				}
			}
			
			swapValues(x, minimum);
			printHorzArray(x,-1);
		}
	}
	
	public static void insertionSort(){
		for(int i = 1; i < arraySize; i++){
			int j = i;
			int toInsert = theArray[i];
			
			while((j > 0) && (theArray[j-1] > toInsert)){
				theArray[j] = theArray[j-1];
				j--;
				
				printHorzArray(i, j);
			}
			theArray[j] = toInsert;
			printHorzArray(i, j);
			System.out.println("\nArray[i] = " + theArray[i]  + 
							  " Array[j] = " + theArray[j] + " toInsert = " + toInsert);
		}
	}


	private static void swapValues(int indexOne, int indexTwo) {
		int temp = theArray[indexOne];
		theArray[indexOne] = theArray[indexTwo];
		theArray[indexTwo] = temp; 
	}

	public static void main(String[] args) {
		ArrayStructures newArray = new ArrayStructures();
		newArray.generateRandomArray();
//		newArray.selectionSort();		
		newArray.insertionSort();
	}

	public static void printHorzArray(int i, int j){

		for(int n = 0; n < 51; n++)System.out.print("-");

		System.out.println();

		for(int n = 0; n < arraySize; n++){

			System.out.print("| " + n + "  ");

		}

		System.out.println("|");

		for(int n = 0; n < 51; n++)System.out.print("-");

		System.out.println();

		for(int n = 0; n < arraySize; n++){

			System.out.print("| " + theArray[n] + " ");

		}

		System.out.println("|");

		for(int n = 0; n < 51; n++)System.out.print("-");

		System.out.println();

		// END OF FIRST PART


		// ADDED FOR BUBBLE SORT

		if(j != -1){

			// ADD THE +2 TO FIX SPACING

			for(int k = 0; k < ((j*5)+2); k++)System.out.print(" ");

			System.out.print(j);

		}


		// THEN ADD THIS CODE

		if(i != -1){

			// ADD THE -1 TO FIX SPACING

			for(int l = 0; l < (5*(i - j)-1); l++)System.out.print(" ");

			System.out.print(i);

		}

		System.out.println();

	}

}
