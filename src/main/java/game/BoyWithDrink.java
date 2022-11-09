package game;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

import static game.Resize.resizeImage;

public class BoyWithDrink extends DrinkAccessory {
    public BoyWithDrink() throws IOException {
        drinkImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/boy-tshirt2.png")));
        drinkImage =resizeImage(drinkImage,300,200);
    }
    public void draw(Graphics g){

        g.drawImage(drinkImage, 74, 77, null);

    }
}
