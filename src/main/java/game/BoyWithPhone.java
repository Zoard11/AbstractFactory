package game;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

import static game.Resize.resizeImage;

public class BoyWithPhone extends PhoneAccessory {


    public BoyWithPhone() throws IOException {
        phoneImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/boy-tshirt1.png")));
        phoneImage =resizeImage(phoneImage,300,200);
    }
    public void draw(Graphics g){

        g.drawImage(phoneImage, 74, 77, null);

    }
}
