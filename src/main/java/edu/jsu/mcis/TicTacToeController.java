package edu.jsu.mcis;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TicTacToeController implements ActionListener{

    private final TicTacToeModel model;
    private final TicTacToeView view;
    
    /* CONSTRUCTOR */

    public TicTacToeController(int width) {
        
        /* Initialize model, view, and width */

        model = new TicTacToeModel(width);
        view = new TicTacToeView(this, width);
        
    }

    public String getMarkAsString(int row, int col) {        
        return (model.getMark(row, col).toString());        
    }
    
    public TicTacToeView getView() {        
        return view;        
    }

    @Override
    public void actionPerformed(ActionEvent event) 
    {
        JButton pressed = (JButton)event.getSource();

        int row = (int) (pressed.getName().charAt(6) - 48);
        int col = (int) (pressed.getName().charAt(7) - 48);
        if(!model.isGameover())
        {
            model.makeMark(row, col);
            pressed.setText(model.getMark(row, col).toString());

        if(model.getResult().toString() == "X" || model.getResult().toString() == "O" || model.getResult().toString() == "TIE")
        {
            view.showResult(model.getResult().toString().toUpperCase());
        }
        }       
    }

}
