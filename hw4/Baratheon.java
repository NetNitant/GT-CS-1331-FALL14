import java.awt.Rectangle;
import java.util.Random;

/**
 * House Baratheon.
 * @author  Nitant Dandekar
 * @version 1.0
 */

public class Baratheon extends SouthHouse {
    private static final String IMAGE_FILENAME = "stag.png";

    private static final int MAX_AGE = 60;

    /**
     * Spawns a Baratheon.
     * @param x      the x-coordinate this Baratheon starts at
     * @param y      the y-coordinate this Baratheon starts at
     * @param bounds the grid this Baratheon will roam
     */
    protected Baratheon(int x, int y, Rectangle bounds) {
        super(IMAGE_FILENAME, x, y, bounds);

        this.maxAge = MAX_AGE;
    }

    /**
     * Can Baratheon reproduce with another House?
     *
     * If it's Lannister.
     *
     * @param  otherHouse the House to reproduce with
     * @return            whether Baratheon can reproduce with the other
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if (otherHouse instanceof Lannister && this.reproductionCooldown <= 0
            && otherHouse.reproductionCooldown <= 0) {
            Random generator = new Random();

            double roll = generator.nextDouble();

            return roll < this.reproductionRate;
        }

        return false;
    }

    /**
     * Reproduces with another House.
     * @param  otherHouse the House to reproduce with
     * @return            the child Baratheon
     */
    protected House reproduceWithHouse(House otherHouse) {
        this.reproductionCooldown = this.maxReproductionCooldown;

        return new Baratheon((int) this.location.getX()
                             , (int) this.location.getY()
                             , new Rectangle(this.grid));
    }

    /**
     * Can Baratheon harm another House?
     *
     * If it's Targaryan.
     *
     * @param  otherHouse the House to harm
     * @return            whether Baratheon can harm the other
     */
    protected boolean canHarmHouse(House otherHouse) {
        return otherHouse instanceof Targaryan;
    }
}
