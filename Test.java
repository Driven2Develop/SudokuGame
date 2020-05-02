
public class Test {

	public static void main(String args[]){
		/*SudokuCell test = new SudokuCell();
		//System.out.println(test.toString());
		
		test.setValue(9);
		test.setQuadrant(4);
		System.out.println(test.toString());
		System.out.println(Integer.toString(test.SizeOfEligibleNumbers()));
		for(int i=1;i<=test.getUpperBound();i++){
			System.out.println(test.hasEligibleNumber(i));
		}
		
		SudokuCell test2 = new SudokuCell();
		test2.removeEligibleNumber(9);
		test2.removeEligibleNumber(8);
		test2.removeEligibleNumber(5);
		System.out.println(test2.toString());
		System.out.println(Integer.toString(test2.SizeOfEligibleNumbers()));
		
		test2.removeEligibleNumber(2);
		test2.removeEligibleNumber(3);
		test2.removeEligibleNumber(4);
		test2.removeEligibleNumber(6);
		test2.removeEligibleNumber(7);
		System.out.println(test2.toString());
		System.out.println(Integer.toString(test2.SizeOfEligibleNumbers()));
		test2.select();
		System.out.println(test2.toString());
		System.out.println(gridTest.toString());
		System.out.println(gridTest.solved());
		for(int i=0;i<gridTest.upperBound;i++){
			for(int j=0;j<gridTest.upperBound;j++){
				gridTest.getGrid()[i][j].setValue(1);
			}
		}*/
		
		SudokuGrid gridTest = new SudokuGrid();

		gridTest.getGrid()[0][0].setValue(3);
		gridTest.getGrid()[0][8].setValue(2);
		gridTest.getGrid()[8][0].setValue(1);
		gridTest.getGrid()[1][2].setValue(6);
		gridTest.getGrid()[1][5].setValue(9);
		gridTest.getGrid()[2][3].setValue(4);
		gridTest.getGrid()[2][4].setValue(2);
		gridTest.getGrid()[2][6].setValue(7);
		gridTest.getGrid()[2][7].setValue(8);
		gridTest.getGrid()[3][0].setValue(8);
		gridTest.getGrid()[3][5].setValue(5);
		gridTest.getGrid()[4][2].setValue(9);
		gridTest.getGrid()[4][4].setValue(4);
		gridTest.getGrid()[4][6].setValue(1);
		gridTest.getGrid()[5][3].setValue(2);
		gridTest.getGrid()[5][8].setValue(4);
		gridTest.getGrid()[6][1].setValue(2);
		gridTest.getGrid()[6][2].setValue(5);
		gridTest.getGrid()[6][4].setValue(9);
		gridTest.getGrid()[6][5].setValue(1);
		gridTest.getGrid()[7][3].setValue(5);
		gridTest.getGrid()[7][6].setValue(3);
		gridTest.getGrid()[8][0].setValue(1);
		gridTest.getGrid()[2][3].setValue(4);
		gridTest.getGrid()[8][8].setValue(5);
		gridTest.getGrid()[3][1].setValue(4);
		gridTest.getGrid()[1][0].setValue(2);
		
		System.out.println(gridTest.toString());
		gridTest.solve();
		System.out.println(gridTest.toString());

		/*gridTest.RemoveEligibleNumbers();
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				gridTest.getGrid()[i][j].select();
			}
		}
		System.out.println(gridTest.toString());
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(gridTest.getGrid()[i][j].getQuadrant()==5)
					System.out.println(gridTest.getGrid()[i][j].toString());
			}
		}
		gridTest.SelectEligibleNumbersByQuadrant(5);
		System.out.println(gridTest.toString());
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				if(gridTest.getGrid()[i][j].getQuadrant()==5)
					System.out.println(gridTest.getGrid()[i][j].toString());
			}
		}
		
		gridTest.RemoveEligibleNumbers();
		for(int i=0;i<gridTest.getGrid()[0][0].getUpperBound();i++){
			System.out.println(gridTest.getGrid()[0][i].toString());
		}*/
	}
}
