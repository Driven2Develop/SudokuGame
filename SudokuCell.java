
public class SudokuCell {

	private int quadrant; //refers to the block in the overall puzzle
	private int[] eligibleNumbers; //potential number(s) that the cell could be
	private int upperBound = 9; //length of column/row, assuming puzzle is a square
	private int value; //displayed value, narrowed down from eligible numbers

	//default constructor to intialize instance variables
	// assuming 0 constitutes a blank value.
	public SudokuCell(){
		this.quadrant = 0;
		int[] t = {1,2,3,4,5,6,7,8,9};
		this.setEligibleNumbers(t);
		this.value=0;
	}
	
	//getters
	public int getQuadrant(){
		return this.quadrant;
	}
	public int[] getEligibleNumbers(){
		return this.eligibleNumbers;
	}
	public int getValue(){
		return this.value;
	}
	public int getUpperBound(){
		return upperBound;
	}
	
	//setters
	public void setQuadrant(int q){
		this.quadrant = q;
	}
	//in addition to setting the value, also eliminates other eligible numbers.
	public void setValue(int i){
		this.value=i;
		for(int j=0;j<upperBound;j++){
			if(!(eligibleNumbers[j]==i)){
				removeEligibleNumber(j+1);
			}
		}
	}
	public void setEligibleNumbers(int[] t){
		this.eligibleNumbers = t;
	}
	public void setUpperBound(int i){
		upperBound=i;
	}
	
	//returns the number of nonzero elements in eligibleNumbers
	public int SizeOfEligibleNumbers(){
		int counter=0;
		for(int i=0;i<eligibleNumbers.length;i++){
			if(!(eligibleNumbers[i]==0))
				counter++;
		}
		return counter;	
	}
	
	//1<=i<=9, sets the value to 0
	public void removeEligibleNumber(int i){
		eligibleNumbers[i-1]=0;
		}
	
	//when a cell has eligible numbers of size=1, then sets the value to that one eligible number
	public void select(){
		if(SizeOfEligibleNumbers()==1){
			for(int i=0;i<upperBound;i++){
				if(!(eligibleNumbers[i]==0)){
					setValue(eligibleNumbers[i]);
					break;
				}
			}
		}
	}
	
	public String toString(){
		StringBuilder s = new StringBuilder();
		s.append("{");
		s.append("Q:");
		s.append(getQuadrant());
		s.append(", ");
		s.append("V:");
		s.append(getValue());
		s.append("} ");
		s.append("{");
		for(int i=0;i<upperBound;i++){
			s.append(eligibleNumbers[i]);
			s.append(",");
		}
		s.append("}");
		return s.toString();
	}

	//returns true if parent is present in list of eligible numbers, elsewise returns false.
	public boolean hasEligibleNumber(int i) {
		boolean flag=false;
		
		for(int j=0;j<upperBound;j++){
			if(eligibleNumbers[j]==i)
				{flag=true;
				break;}
		}
		return flag;
	}
}
