import java.awt.Rectangle;
import java.util.Random;

/**
 * House Stark.
 * @author  Nitant Dandekar
 * @version 1.0
 */
public class Stark extends NorthHouse {
    private static final String IMAGE_FILENAME = "direwolf.png";

    private static final double HARM_CHANCE = 0.40;

    private static final int MAX_AGE = 70;

    /**
     * Spawns a Stark.
     * @param x      the x-coordinate this Stark starts at
     * @param y      the y-coordinate this Stark starts at
     * @param bounds the grid this Stark will roam
     */
    protected Stark(int x, int y, Rectangle bounds) {
        super(IMAGE_FILENAME, x, y, bounds);

        this.maxAge = MAX_AGE;
    }

    /**
     * Can Stark reproduce with another House?
     *
     * If it's Tully, sure.
     *
     * @param  otherHouse the House to reproduce with
     * @return            whether Stark can reproduce with the other
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if (otherHouse instanceof Tully && this.reproductionCooldown <= 0
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
     * @return            the child Stark
     */
    protected House reproduceWithHouse(House otherHouse) {
        this.reproductionCooldown = this.maxReproductionCooldown;

        return new Stark((int) this.location.getX()
                         , (int) this.location.getY()
                         , new Rectangle(this.grid));
    }

    /**
     * Can Stark harm another House?
     *
     * If Lannister, 40/60 odds.
     *
     * @param  otherHouse the House to harm
     * @return            whether Stark can harm the other
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
