public class alphabeta implements Player {
	int id; 
	int opponent_id;
    int cols; 
    
    @Override
    public String name() {
        return "Minnie";
    }

    @Override
    public void init(int id, int msecPerMove, int rows, int cols) {
    	this.id = id; //id is your player's id, opponent's id is 3-id
    	this.cols = cols;
    	opponent_id = 3-id;
    }

    @Override
    public void calcMove(
        Connect4Board board, int oppMoveCol, Arbitrator arb) 
        throws TimeUpException {
        // Make sure there is room to make a move.
        if (board.isFull()) {
            throw new Error ("Complaint: The board is full!");
        }
        
        int move = 0; 
        int maxDepth = 1;
        
        // while there's time left and maxDepth <= number of moves remaining
        while(!arb.isTimeUp() && maxDepth <= board.numEmptyCells()) {
        	// do minimax search
        	// start the first level of minimax, set move as you're finding the bestScore
        	int bestScore = -1000;
        	for (cols = 0; cols < 7; cols++) {
        		if(board.isValidMove(cols)) {
        			board.move(cols,  opponent_id);
        			int score = alphaBeta(board, maxDepth - 1, false, arb);
        			if(score > bestScore) {
        				bestScore = score;
        				move = cols;	
        			}
        		board.unmove(cols,  opponent_id);
        		}
        	}
        
            arb.setMove(move);
            maxDepth++;
        }        

    }
    
    public int alphaBeta(board do, maxDepth, alpha, beta, maximizingPlayer) {
    	if(depth == 0 || node == terminalNode) {
    		return node;
    	}
    	if(maximixingPlayer == true) {
    		value = -1000;
    	}
    	for(node do == true) {
			value = Math.max(value, alphabeta(do, depth-1, alpha, beta, false));
			alpha = Math.max(alpha, value);
			if(alpha >= beta) {
				break;
				return value;
			} else {
				value = +1000;
				for(node do == true) {
					value = Math.max(value, alphabet(do, depth-1, alpha, beta, true));
					beta = Math.min(beta, value);
					if(alpha >= beta) {
						break;
						return value;
					}
				}
			}
		}
    }

    
    // your score - opponent's score
    public int score(Connect4Board board) {
    	return calcScore(board, id) - calcScore(board, opponent_id);
    }
    
    
	// Return the number of connect-4s that player #id has.
	public int calcScore(Connect4Board board, int id)
	{
		final int rows = board.numRows();
		final int cols = board.numCols();
		int score = 0;
		// Look for horizontal connect-4s.
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c <= cols - 4; c++) {
				if (board.get(r, c + 0) != id) continue;
				if (board.get(r, c + 1) != id) continue;
				if (board.get(r, c + 2) != id) continue;
				if (board.get(r, c + 3) != id) continue;
				score++;
			}
		}
		// Look for vertical connect-4s.
		for (int c = 0; c < cols; c++) {
			for (int r = 0; r <= rows - 4; r++) {
				if (board.get(r + 0, c) != id) continue;
				if (board.get(r + 1, c) != id) continue;
				if (board.get(r + 2, c) != id) continue;
				if (board.get(r + 3, c) != id) continue;
				score++;
			}
		}
		// Look for diagonal connect-4s.
		for (int c = 0; c <= cols - 4; c++) {
			for (int r = 0; r <= rows - 4; r++) {
				if (board.get(r + 0, c + 0) != id) continue;
				if (board.get(r + 1, c + 1) != id) continue;
				if (board.get(r + 2, c + 2) != id) continue;
				if (board.get(r + 3, c + 3) != id) continue;
				score++;
			}
		}
		for (int c = 0; c <= cols - 4; c++) {
			for (int r = rows - 1; r >= 4 - 1; r--) {
				if (board.get(r - 0, c + 0) != id) continue;
				if (board.get(r - 1, c + 1) != id) continue;
				if (board.get(r - 2, c + 2) != id) continue;
				if (board.get(r - 3, c + 3) != id) continue;
				score++;
			}
		}
		return score;
	}

}

