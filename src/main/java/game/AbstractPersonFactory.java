package game;

import java.awt.Graphics;
import java.io.IOException;

public abstract class AbstractPersonFactory {
    abstract void createPhone() throws IOException;
    abstract void createDrink() throws IOException;

    abstract void setBaseOutfit();

    public void draw(Graphics g) {
    }
}
