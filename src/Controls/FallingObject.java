package Controls;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.ImageIcon;

import viewers.outdoorFrame;

public class FallingObject {
    private int x;
	private int y;
    int width, height;
    private Image image;
    boolean collected = false;

    public FallingObject(int x, int y, int width, int height, Image image) {
        this.setObjX(x);
        this.setObjY(y);
        this.width = width;
        this.height = height;
        this.setImage(image);
    }

    public Rectangle getBounds() {
        return new Rectangle(getObhX(), getObjY(), width, height);
    }

	public int getObjY() {
		return y;
	}

	public void setObjY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public int getObhX() {
		return x;
	}

	public void setObjX(int x) {
		this.x = x;
	}
}
