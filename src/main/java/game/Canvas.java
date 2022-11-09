package game;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Canvas extends JPanel {
    private BufferedImage image ;

    AbstractPersonFactory factory;

    AbstractPersonFactory boyFactory;
    AbstractPersonFactory girlFactory;

    private JButton boyButton;
    private JButton girlButton;

    private JButton drink;
    private JButton phone;
    private JButton baseOutfit;

    public AbstractPersonFactory getFactory() {
        return factory;
    }

    public void setFactory(AbstractPersonFactory factory) {
        this.factory = factory;
    }

    public Canvas()  {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        boyFactory=new BoyFactory();
        girlFactory=new GirlFactory();
        factory=boyFactory;
        boyButton = new JButton("Boy");;
        boyButton.setBounds(10, 0, 100, 40);


        add(boyButton);
        girlButton = new JButton("Girl");
        girlButton.setBounds(120, 0, 100, 40);
        add(girlButton);

        boyButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                factory=boyFactory;
                repaint();
            }

        });
        girlButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                factory=girlFactory;
                repaint();
            }

        });

        drink = new JButton("Phone");
        drink.setBounds(310, 200, 100, 40);


        add(drink);
        phone = new JButton("Drink");
        phone.setBounds(420, 200, 100, 40);
        add(phone);

        drink.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    factory.createPhone();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                repaint();
            }

        });
        phone.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    factory.createDrink();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                repaint();
            }

        });

        baseOutfit = new JButton("remove extras");
        baseOutfit.setBounds(370, 250, 140, 40);
        add(baseOutfit);
        baseOutfit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                factory.setBaseOutfit();
                repaint();
            }

        });

        this .setLayout(null );
        this .setBackground(Color.WHITE );


    }
    protected void paintComponent(Graphics g) {
        super .paintComponent(g);
        factory .draw(g);
    }

}