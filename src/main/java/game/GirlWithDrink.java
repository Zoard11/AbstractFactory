package game;

import java.awt.Graphics;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

import static game.Resize.resizeImage;

public class GirlWithDrink extends DrinkAccessory {
    public GirlWithDrink() throws IOException {
        drinkImage = ImageIO.read(Objects.requireNonNull(getClass().getResource("/images/girl-tshirt1.png")));
        drinkImage=resizeImage(drinkImage,230,153);
    }
    public void draw(Graphics g){

        g.drawImage(drinkImage, 50, 82, null);

    }
}
