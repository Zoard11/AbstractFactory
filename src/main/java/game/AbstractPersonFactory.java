package game;

import java.awt.Graphics;

public abstract class AbstractPersonFactory {
    abstract void setShirt1();
    abstract void setShirt2();

    abstract void setBaseOutfit();

    public void draw(Graphics g) {
    }
}
