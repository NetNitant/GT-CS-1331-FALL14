import java.awt.Rectangle;
import java.util.Random;

/**
 * House Targaryan.
 * @author  Nitant Dandekar
 * @version 1.0
 */

public class Targaryan extends House {
    private static final String IMAGE_FILENAME = "dragon.png";

    /**
     * Spawns a Targaryan.
     * @param x      the x-coordinate this Targaryan starts at
     * @param y      the y-coordinate this Targaryan starts at
     * @param bounds the grid this Targaryan will roam
     */
    protected Targaryan(int x, int y, Rectangle bounds) {
        super(IMAGE_FILENAME, x, y, bounds);
    }

    /**
     * Can Targaryan reproduce with another House?
     *
     * If it's a Targaryan, yes.
     *
     * @param  otherHouse the House to reproduce with
     * @return            whether Targaryan can reproduce with the other
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if (otherHouse instanceof Targaryan && this.reproductionCooldown <= 0
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
     * @return            the child Targaryan
     */
    protected House reproduceWithHouse(House otherHouse) {
        this.reproductionCooldown = this.maxReproductionCooldown;

        return new Targaryan((int) this.location.getX()
                             , (int) this.location.getY()
                             , new Rectangle(this.grid));
    }

    /**
     * Is this House old?
     *
     * Of course not.
     *
     * @return whether this House is old
     */
    @Override
    protected boolean isOld() {
        return false;
    }

    /**
     * Can Targaryan harm another House?
     *
     * If it's not Targaryan or Baratheon, sure.
     *
     * @param  otherHouse the House to harm
     * @return            whether Targaryan can harm the other
     */
    protected boolean canHarmHouse(House otherHouse) {
        return !(otherHouse instanceof Targaryan)
               && !(otherHouse instanceof Baratheon);
    }
}
