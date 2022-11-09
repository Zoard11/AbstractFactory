package game;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

import static game.Resize.resizeImage;

public class GirlWithPhone extends PhoneAccessory {


    public GirlWithPhone() throws IOException {
        phoneImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/girl-tshirt2.png")));
        phoneImage=resizeImage(phoneImage,246,164);
    }
    public void draw(Graphics g){

        g.drawImage(phoneImage, 50, 82, null);

    }
}
