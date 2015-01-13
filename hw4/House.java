import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

/**
 * The abstract House for the Game of Thrones simulation
 * @author  Nitant Dandekar
 * @version 2.0
 */
public abstract class House {
    protected ImageIcon image;
    protected String imageFilename;

    protected final Rectangle grid;
    protected Rectangle location;
    protected int moveRate = 50;

    protected int maxHealth = 100;
    protected int health = 100;
    protected int moveHealthChange = -2;
    protected int attackDamage = 20;

    protected int age;
    protected int maxAge = 40;

    protected int maxReproductionCooldown = 20;
    protected int reproductionCooldown = 20;
    protected double reproductionRate = 0.10;

    /**
     * Spawns a House.
     * @param imageFilename the name of the image this House uses
     * @param x             the x-coordinate this House starts at
     * @param y             the y-coordinate this House starts at
     * @param bounds        the grid this House will roam
     */
    protected House(String imageFilename, int x, int y, Rectangle bounds) {
        this.imageFilename = imageFilename;
        this.image = new ImageIcon(imageFilename);

        this.grid = bounds;
        this.location = new Rectangle(x, y, this.image.getIconWidth()
                                      , this.image.getIconHeight());

        if (!this.grid.contains(this.location)) {
            if (this.location.getX() < this.grid.getX()) {
                this.location.setLocation((int) this.grid.getX()
                                          , (int) this.location.getY());
            } else if (this.location.getMaxX() > this.grid.getMaxX()) {
                this.location.setLocation((int) (this.grid.getMaxX()
                                          - this.image.getIconWidth())
                                          , (int) this.location.getY());
            }

            if (this.location.getY() < this.grid.getY()) {
                this.location.setLocation((int) this.location.getX()
                                          , (int) this.grid.getY());
            } else if (this.location.getMaxY() > this.grid.getMaxY()) {
                this.location.setLocation((int) this.location.getX()
                                          , (int) (this.grid.getMaxY()
                                          - this.image.getIconHeight()));
            }
        }
    }

    /**
     * Performs a move action.
     */
    protected void move() {
        Random generator = new Random();

        Rectangle newLocation = new Rectangle(this.location);

        boolean movedX = false;

        while (!movedX) {
            int moveX = generator.nextBoolean()
                        ? generator.nextInt(this.moveRate + 1)
                        : -1 * generator.nextInt(this.moveRate + 1);

            newLocation.setLocation((int) (newLocation.getX() + moveX)
                                    , (int) newLocation.getY());

            if (!this.grid.contains(newLocation)) {
                newLocation.setLocation((int) (newLocation.getX() - moveX)
                                        , (int) newLocation.getY());
            } else {
                movedX = true;
            }
        }

        boolean movedY = false;
        int maxMoveAmountY = this.moveRate;

        while (!movedY) {
            int moveY = generator.nextBoolean()
                        ? generator.nextInt(this.moveRate + 1)
                        : -1 * generator.nextInt(this.moveRate + 1);

            newLocation.setLocation((int) newLocation.getX()
                                    , (int) (newLocation.getY() + moveY));

            if (!this.grid.contains(newLocation)) {
                newLocation.setLocation((int) newLocation.getX()
                                        , (int) (newLocation.getY() - moveY));
            } else {
                movedY = true;
            }
        }

        this.location = newLocation;

        this.health += this.moveHealthChange;

        if (this.health > maxHealth) {
            this.health = maxHealth;
        }

        this.age++;

        this.reproductionCooldown--;
    }

    /**
     * Is this House colliding with another House?
     * @param  otherHouse the House to check for collisions
     * @return            whether this House is colliding with the other
     */
    protected boolean collidesWithHouse(House otherHouse) {
        if (otherHouse == null) {
            return false;
        }

        return this.location.intersects(otherHouse.location);
    }

    /**
     * Can this House reproduce with another House?
     * @param  otherHouse the House to reproduce with
     * @return            whether this House can reproduce with the other
     */
    abstract boolean canReproduceWithHouse(House otherHouse);

    /**
     * Reproduce with another House.
     * @param  otherHouse the House to reproduce with
     * @return            the child House
     */
    abstract House reproduceWithHouse(House otherHouse);

    /**
     * Is this House old?
     * @return whether this House is old
     */
    protected boolean isOld() {
        return this.age > this.maxAge;
    }

    /**
     * Can this House harm another House?
     * @param  otherHouse the House to harm
     * @return            whether this House can harm the other
     */
    abstract boolean canHarmHouse(House otherHouse);

    /**
     * Harms another House.
     * @param otherHouse the House to harm
     */
    protected void harmHouse(House otherHouse) {
        otherHouse.health -= this.attackDamage;

        if (otherHouse.isDead()) {
            otherHouse.die();
        }
    }

    /**
     * Makes the House die.
     */
    protected void die() {
        health = 0;
    }

    /**
     * Is this House dead?
     * @return whether it's dead
     */
    protected boolean isDead() {
        return (health <= 0);
    }

    /**
     * Should draw the House at its location.
     * @param g the Graphics object to draw with
     */
    protected void draw(Graphics g) {
        image.paintIcon(null, g, (int) this.location.getX()
                        , (int) this.location.getY());
    }
}
