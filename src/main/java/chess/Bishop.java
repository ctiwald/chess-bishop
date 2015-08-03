package chess;

import java.util.HashSet;
import java.util.Set;

/**
 * This class provides a basic description of a Bishop chess piece.
 */
public class Bishop {

    /**
     * This method should retrieve the possible positions of a piece on a chess board.
     */
    public Set<Position> getNextPositions(Position origin) {

    	//Initialize set of possible position objects
    	Set<Position> possPositions = new HashSet<Position>();

    	int[] possRows = new int[8];
    	char[] possCols = new char[8];

    	//Get current column and row
    	char currCol = origin.getColumn();
    	int currRow = origin.getRow();
    	//Get all possible positions from current (all diagonals), using
    	//Position.MIN_ROW, MAX_ROW, MIN_COLUMN, MAX_COLUMN
    	int currColIndex = 0;
    	int currRowIndex = 0;

    	while( currCol <= Position.MAX_COLUMN ) {
    		possCols[currColIndex] = currCol++; //Need to add to character
    		System.out.println(currCol);
    		currColIndex++;
    	}
    	currCol = origin.getColumn();
    	while( currCol > Position.MIN_COLUMN ) {
    		possCols[currColIndex] = currCol--;
    		System.out.println(currCol);
    		currColIndex++;
    	}
    	while( currRow <= Position.MAX_ROW ) {
    		possRows[currRowIndex] = currRow++;
    		currRowIndex++;
    	}
    	currRow = origin.getRow();
    	while( currRow > Position.MIN_ROW ) {
    		possRows[currRowIndex] = currRow--;
    		currRowIndex++;
    	}

    	//create set of possible positions
    	for( int indexRow = 0; indexRow < 8; indexRow++ ) {
    		for( int indexCol = 0; indexCol < 8; indexCol++) {
    			possPositions.add(new Position(possCols[indexCol], possRows[indexRow]));
    		}
    	}

    	//Edge cases:
    	//  - in corner of board
    	//  - at edge of board (left, right, top, bottom)
        return possPositions;
    }
}
