
public class alphabeta {
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
	        	
	        
	            arb.setMove(move);
	            maxDepth++;
	        }        

	    }
	    public int alphabeta(node, dpeth, α, β, maximizingPlayer);
	    
	    function alphabeta(node, depth, α, β, maximizingPlayer);
	    	if depth = 0 or node is a terminal node then
	    	return the heuristic value of node
	    	if maximizingPlayer then
	    	value = −∞
	    	for each child of node do
	    	value = max(value, alphabeta(child, depth − 1, α, β, FALSE)) 
	    	α = max(α, value)
	    	if α ≥ β then
	    	break /* β cut-off */
	    	return value
	    	else
	    	value = +∞
	    	for each child of node do
	    	value = min(value, alphabeta(child, depth − 1, α, β, TRUE)) 
	    	β = min(β, value)
	    	if α ≥ β then
	    	break /* α cut-off */
	    	return value
	    			
	    			
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

