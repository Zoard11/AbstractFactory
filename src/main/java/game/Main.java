package game;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.BorderLayout;

public class Main {



    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        Canvas canvas = new Canvas();
        frame.add(canvas, BorderLayout.CENTER );
        frame.setSize(600, 700);


        canvas.setFocusable(true );
        frame.setVisible(true );
        canvas.requestFocus();


    }

}