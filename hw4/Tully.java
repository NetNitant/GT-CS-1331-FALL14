import java.awt.Rectangle;
import java.util.Random;

/**
 * House Tully.
 * @author  Nitant Dandekar
 * @version 1.0
 */
public class Tully extends NorthHouse {
    private static final String IMAGE_FILENAME = "trout.png";

    private static final double HARM_CHANCE = 0.20;

    private static final int MAX_AGE = 80;

    /**
     * Spawns a Tully.
     * @param x      the x-coordinate this Tully starts at
     * @param y      the y-coordinate this Tully starts at
     * @param bounds the grid this Tully will roam
     */
    protected Tully(int x, int y, Rectangle bounds) {
        super(IMAGE_FILENAME, x, y, bounds);

        this.maxAge = MAX_AGE;
    }

    /**
     * Can Tully reproduce with another House?
     *
     * If it's Stark.
     *
     * @param  otherHouse the House to reproduce with
     * @return            whether Tully can reproduce with the other
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if (otherHouse instanceof Stark && this.reproductionCooldown <= 0
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
     * @return            the child Tully
     */
    protected House reproduceWithHouse(House otherHouse) {
        this.reproductionCooldown = this.maxReproductionCooldown;

        return new Stark((int) this.location.getX()
                         , (int) this.location.getY()
                         , new Rectangle(this.grid));
    }

    /**
     * Can Tully harm another House?
     *
     * If it's Lannister, 20/80 odds.
     *
     * @param  otherHouse the House to harm
     * @return            whether Tully can harm the other
     */
    protected boolean canHarmHouse(House otherHouse) {
        if (otherHouse instanceof Lannister) {
            Random generator = new Random();

            double roll = generator.nextDouble();

            return roll < HARM_CHANCE;
        }

        return false;
    }
}
