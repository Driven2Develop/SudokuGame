import java.util.ArrayList;

public class SudokuGrid {
	public int upperBound = 9;
	private SudokuCell[][] grid;

	//default constructor to initialize grid, uses default constructor SudokuCell.
	public SudokuGrid(){
		grid = new SudokuCell[upperBound][upperBound];
		for(int i=0;i<upperBound;i++){
			for(int j=0;j<upperBound;j++){
				grid[i][j] = new SudokuCell();
			}
		}
		//labels quadrants/blocks of sudoku.
		this.initializeQuadrants();
	}
	
	//getters, setters
	public SudokuCell[][] getGrid(){
		return this.grid;
	}
	public void setGrid(SudokuCell[][] g){
		this.grid=g;
	}

	public String toString(){
		StringBuilder s = new StringBuilder();
		for(int i=0;i<upperBound;i++){
			for(int j=0;j<upperBound;j++){
				s.append(grid[i][j].getValue());
			}
			s.append("\n");
		}
		return s.toString();
	}
	
	public boolean solved(){
		boolean flag=true;
		for(int i=0;i<upperBound;i++){
			for(int j=0;j<upperBound;j++){
				if(grid[i][j].getValue()==0)
					flag=false;
			}
		}
		return flag;
	}
	
	public void RemoveEligibleNumbers(){
		for(int i=0;i<upperBound;i++){
			for(int j=0;j<upperBound;j++){
				if(!(grid[i][j].getValue()==0)){
					for(int k=0;k<upperBound;k++){
						if(k==i)
							continue;
							else
							grid[k][j].removeEligibleNumber(grid[i][j].getValue());
					}
					for(int k=0;k<upperBound;k++){
						if(k==j)
							continue;
							else
							grid[i][k].removeEligibleNumber(grid[i][j].getValue());
					}
					for(int a=0;a<upperBound;a++){
						for(int b=0;b<upperBound;b++){
							if(grid[i][j].getQuadrant()==grid[a][b].getQuadrant() &&
									(!(grid[a][b].equals(grid[i][j]))))
								grid[a][b].removeEligibleNumber(grid[i][j].getValue());
						}
					}
				}
			}
		}
	}
	
	public void SelectEligibleNumbers(){
		for(int i=1;i<upperBound+1;i++){
			SelectEligibleNumbersByQuadrant(i);
		}
	}
	
	public void SelectEligibleNumbersByQuadrant(int q){
		ArrayList<SudokuCell> a = new ArrayList<SudokuCell>();
		for(int i=0;i<upperBound;i++){
			for(int j=0;j<upperBound;j++){
				if(grid[i][j].getQuadrant()==q)
					a.add(grid[i][j]);
			}
		}
		int counter=0;
		for(int i=1;i<upperBound+1;i++){
			for(int j=0;j<a.size();j++){
				if(a.get(j).hasEligibleNumber(i))
					counter++;
			}
			if(counter==1)
				SelectByQuadrant(q,i);
			counter=0;
		}
	}
	
	
	//sets the value to i for the cell in quadrant q
	public void SelectByQuadrant(int q, int i){
		for(int j=0;j<upperBound;j++){
			for(int k=0;k<upperBound;k++){
				if(grid[j][k].getQuadrant()==q && grid[j][k].hasEligibleNumber(i))
					grid[j][k].setValue(i);
			}
		}
	}
	/*TEST ME*/
	public void solve(){
		while(!(solved())){
			RemoveEligibleNumbers();
			for(int i=0;i<upperBound;i++){
				for(int j=0;j<upperBound;j++){
					grid[i][j].select();
				}
			}
			SelectEligibleNumbers();
		}
	}
	
	//sets quadrants for grid
	public void initializeQuadrants(){
		//top left quadrant = 1
			for(int j=0;j<3;j++){
				for(int i=0;i<3;i++){
					grid[j][i].setQuadrant(1);
				}
			}
			//top quadrant = 2
			for(int j=0;j<3;j++){
				for(int i=3;i<6;i++){
					grid[j][i].setQuadrant(2);
				}
			}
			//top right quadrant = 3
			for(int j=0;j<3;j++){
				for(int i=6;i<9;i++){
					grid[j][i].setQuadrant(3);
				}
			}
			//middle left quadrant = 4
			for(int j=3;j<6;j++){
				for(int i=0;i<3;i++){
					grid[j][i].setQuadrant(4);
				}
			}
			//middle quadrant = 5
			for(int j=3;j<6;j++){
				for(int i=3;i<6;i++){
					grid[j][i].setQuadrant(5);
				}
			}
			//middle right quadrant = 6
			for(int j=3;j<6;j++){
				for(int i=6;i<9;i++){
					grid[j][i].setQuadrant(6);
				}
			}
			//bottom left quadrant = 7
			for(int j=6;j<9;j++){
				for(int i=0;i<3;i++){
					grid[j][i].setQuadrant(7);
				}
			}
			//bottom middle quadrant = 8
			for(int j=6;j<9;j++){
				for(int i=3;i<6;i++){
					grid[j][i].setQuadrant(8);
				}
			}
			//bottom right quadrant = 9
			for(int j=6;j<9;j++){
				for(int i=6;i<9;i++){
					grid[j][i].setQuadrant(9);
				}
			}
	}
}
