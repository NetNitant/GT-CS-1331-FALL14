import java.awt.Rectangle;
import java.util.Random;

/**
 * House Lannister.
 * @author  Nitant Dandekar
 * @version 1.0
 */
public class Lannister extends SouthHouse {
    private static final String IMAGE_FILENAME = "lion.png";

    private static final double STARK_HARM_CHANCE = 0.60;
    private static final double TULLY_HARM_CHANCE = 0.80;

    private static final int MAX_AGE = 50;

    /**
     * Spawns a Lannister.
     * @param x      the x-coordinate this Lannister starts at
     * @param y      the y-coordinate this Lannister starts at
     * @param bounds the grid this Lannister will roam
     */
    protected Lannister(int x, int y, Rectangle bounds) {
        super(IMAGE_FILENAME, x, y, bounds);

        this.maxAge = MAX_AGE;
    }

    /**
     * Can Lannister reproduce with another House?
     *
     * If it's Baratheon or Lannister, sure.
     *
     * @param  otherHouse the House to reproduce with
     * @return            whether Lannister can reproduce with the other
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if ((otherHouse instanceof Baratheon || otherHouse instanceof Lannister)
            && this.reproductionCooldown <= 0
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
     * @return            the child Lannister
     */
    protected House reproduceWithHouse(House otherHouse) {
        this.reproductionCooldown = this.maxReproductionCooldown;

        return new Lannister((int) this.location.getX()
                             , (int) this.location.getY()
                             , new Rectangle(this.grid));
    }

    /**
     * Can Lannister harm another House?
     *
     * Yes, Stark at 60/40 odds and Tully at 80/20 odds.
     *
     * @param  otherHouse the House to harm
     * @return            whether Lannister can harm the other
     */
    protected boolean canHarmHouse(House otherHouse) {
        if (otherHouse instanceof Stark) {
            Random generator = new Random();

            double roll = generator.nextDouble();

            return roll < STARK_HARM_CHANCE;
        } else if (otherHouse instanceof Tully) {
            Random generator = new Random();

            double roll = generator.nextDouble();

            return roll < TULLY_HARM_CHANCE;
        }

        return false;
    }
}
