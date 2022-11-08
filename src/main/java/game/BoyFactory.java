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
    protected BufferedImage tShirtImage ;
    protected BufferedImage tShirtImage1 ;
    protected BufferedImage tShirtImage2 ;

    public BoyFactory(){
        try {
            image = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/boy.jpg")));
            image=resizeImage(image,300,500);
            withoutArm = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/boy-without-arm.jpg")));
            withoutArm=resizeImage(withoutArm,300,500);
            tShirtImage1 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/boy-tshirt1.png")));
            tShirtImage1=resizeImage(tShirtImage1,300,200);
            tShirtImage2 = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/boy-tshirt2.png")));
            tShirtImage2=resizeImage(tShirtImage2,300,200);

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
    void setShirt1() {
        tShirtImage=tShirtImage1;
    }

    @Override
    void setShirt2() {
        tShirtImage=tShirtImage2;
    }

    @Override
    void setBaseOutfit() {
        tShirtImage=null;
    }

    public void draw(Graphics g){
        g.drawImage(image , this .x , this .y , null );
        if(tShirtImage != null) {
            g.drawImage(withoutArm , this .x , this .y , null );
            g.drawImage(tShirtImage, 74, 77, null);
        } else {
            g.drawImage(image , this .x , this .y , null );
        }
    }



}
