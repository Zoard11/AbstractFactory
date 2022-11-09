package game;

import javax.imageio.ImageIO;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

import static game.Resize.resizeImage;


public class BoyFactory extends AbstractPersonFactory {
    protected int x = 50;
    protected int y = 0;
    protected BufferedImage image ;
    protected BufferedImage withoutArm ;

    protected DrinkAccessory drinkAccessory = null;
    protected PhoneAccessory phoneAccessory = null ;

    public BoyFactory(){
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/boy.jpg")));
            image=resizeImage(image,300,500);
            withoutArm = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/boy-without-arm.jpg")));
            withoutArm=resizeImage(withoutArm,300,500);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Dimension getPreferredSize() {
        return new Dimension(300,500);
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    void createPhone() throws IOException {
        phoneAccessory = new BoyWithPhone();
        drinkAccessory = null;
    }

    @Override
    void createDrink() throws IOException {
        drinkAccessory = new BoyWithDrink();
        phoneAccessory = null;
    }

    @Override
    void setBaseOutfit() {
        drinkAccessory = null;
        phoneAccessory = null;
    }

    public void draw(Graphics g){
        g.drawImage(image , this .x , this .y , null );

        if(drinkAccessory != null || phoneAccessory != null) {
            g.drawImage(withoutArm , this .x , this .y , null );
            if(drinkAccessory != null) {
                drinkAccessory.draw(g);
            } else {
                phoneAccessory.draw(g);
            }
        } else {
            g.drawImage(image , this .x , this .y , null );
        }
    }



}
