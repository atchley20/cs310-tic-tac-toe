package edu.jsu.mcis;

public class TicTacToeModel {
    
    private Mark[][] board; /* Game board */
    private boolean xTurn;  /* True if X is current player */
    private int width;      /* Size of game board */
    
    /* ENUM TYPE DEFINITIONS */
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a TIE,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("TIE"), 
        NONE("NONE");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        this(TicTacToe.DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create board (width x width) as a 2D Mark array */
        
        board = new Mark[width][width];

        /* Initialize board by filling every square with empty marks */
        
        for (int i = 0; i < width; ++i)
        {
            for (int j = 0; j < width; ++j)
            {
                board[i][j] = Mark.EMPTY;
            }
        }
        
    }
	
    public boolean makeMark(int row, int col)
    {
        if(isValidSquare(row,col) && isSquareMarked(row, col) == false){
            if(xTurn == true){
                board[row][col] = Mark.X;
                xTurn = false;
                return true;
            }
            else{
                board[row][col] = Mark.O;
                xTurn = true;
                return true;
            }
        }
        else{
            return false;
        }
    }
	
    private boolean isValidSquare(int row, int col)
    {
        
        if(row >= 0 && row < width && col >= 0 && col < width)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
	
    private boolean isSquareMarked(int row, int col)
    {
        /* Return TRUE if the square at specified location is marked */
        return getMark(row,col) == Mark.X || getMark(row,col) == Mark.O;
    }
	
    public Mark getMark(int row, int col)
    {
        return board[row][col] ;
    }
	
    public Result getResult()
    {
        
        if(isMarkWin(Mark.X))
        {
            return Result.X;
        }
        else if(isMarkWin(Mark.O))
        {
            return Result.O;
        }
        else if(isTie())
        {
            return Result.TIE;
        }
        else
        {
            return Result.NONE;
        }
        
    }
	
    private boolean isMarkWin(Mark mark)
    {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */
        int consecutive_marks = 0;
        for( int i = 0; i < width; ++i)
        {
            for( int j = 0; j < width; ++j)
            {
                if( board[i][j] == mark )
                {
                    consecutive_marks += 1;
                    if( consecutive_marks == width )
                    {
                        return true;
                    }
                }
                
                else
                {
                    consecutive_marks = 0;
                    break;
                }
            }

        }
        consecutive_marks = 0;
        for(int i = 0; i < width; ++i)
        {
            for(int j = 0; j < width; ++j)
            {
                if( board[j][i] == mark )
                {
                    consecutive_marks += 1;
                    if( consecutive_marks == width )
                    {
                        return true;
                    }
                }
                else
                {
                    consecutive_marks = 0;
                    break;
                }
            }
        }
        consecutive_marks = 0;
        for(int i = 0; i < width; ++i )
        {
            if(board[i][i] == mark)
            {
                consecutive_marks += 1;
                if(consecutive_marks == width)
                {
                    return true;
                }
            }
            else
            {
                consecutive_marks = 0;
            }
        }
        
        consecutive_marks = 0;
        for(int i = 0; i < width; ++i)
        {
            if(board[i][width - 1 - i] == mark)
            {
                consecutive_marks += 1;
                if(consecutive_marks == width)
                {
                    return true;
                }
            }
            else
            {
                consecutive_marks = 0;
            }
            
        }
        
        return false;
        
        
    }

    private boolean isTie()
    {
        
        for(int i = 0; i < width; ++i)
        {
            for(int j = 0; j < width; ++j)
            {
                if(getMark(i,j) == Mark.EMPTY)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isGameover()
    {
        
        /* Return TRUE if the game is over */
        
        return (Result.NONE != getResult());
        
    }

    public boolean isXTurn()
    {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth()
    {
        
        /* Getter for width */
        
        return width;
        
    }
    
    @Override
    public String toString()
    {
        
        StringBuilder output = new StringBuilder("  ");
        
        /* Output the board contents as a string (see examples) */
        for (int i = 0; i < this.width; i++)
        {
            output.append(i);
        }
        output.append("\n");
        for (int j = 0; j < this.width; j++)
        {
            output.append(j);
            output.append(" ");
            for(int k = 0; k < this.width; k++)
            {
                output.append(board[j][k]);
            }
            output.append("\n");
        }
        return output.toString();
        
    }
    
}
