package edu.jsu.mcis;

public class TicTacToeController {

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView();
        
    }

    public void start() {
    
        while(model.isGameover() == false)
        {
            view.showBoard(model.toString());
            TicTacToeMove Move = view.getNextMove(model.isXTurn());
            if (model.makeMark(Move.getRow(), Move.getCol()))
            {
                
            }
            else{
                view.showInputError();
            }
        }

        view.showBoard(model.toString());

        view.showResult(model.getResult().toString());
        
    }

}
