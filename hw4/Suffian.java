import java.awt.Rectangle;
import java.util.Random;

/**
 * House Suffian.
 * @author  Nitant Dandekar
 * @version 1.0
 */
public class Suffian extends NorthHouse {
    private static final String IMAGE_FILENAME = "suffian.png";

    private double chance = 0.25;

    /**
     * Spawns a Suffian.
     * @param x      the x-coordinate this Suffian starts at
     * @param y      the y-coordinate this Suffian starts at
     * @param bounds the grid this Suffian will roam
     */
    protected Suffian(int x, int y, Rectangle bounds) {
        super(IMAGE_FILENAME, x, y, bounds);
    }

    /**
     * Can Suffian reproduce with another House?
     * @param  otherHouse the House to reproduce with
     * @return            whether Suffian can reproduce with the other
     */
    protected boolean canReproduceWithHouse(House otherHouse) {
        if (this.reproductionCooldown <= 0
            && otherHouse.reproductionCooldown <= 0) {
            Random generator = new Random();

            double roll = generator.nextDouble();

            if (roll < this.chance) {
                this.increaseAllStats();
                return true;
            } else {
                return false;
            }
        }

        return false;
    }

    /**
     * Reproduces with another House.
     * @param  otherHouse the House to reproduce with
     * @return            the child Suffian
     */
    protected House reproduceWithHouse(House otherHouse) {
        this.reproductionCooldown = this.maxReproductionCooldown;

        return new Suffian((int) this.location.getX()
                           , (int) this.location.getY()
                           , new Rectangle(this.grid));
    }

    /**
     * Can Suffian harm another House?
     * @param  otherHouse the House to harm
     * @return            whether Suffian can harm the other
     */
    protected boolean canHarmHouse(House otherHouse) {
        Random generator = new Random();

        double roll = generator.nextDouble();

        if (roll < this.chance) {
            this.increaseAllStats();
            return true;
        } else {
            return false;
        }
    }

    /**
     * Increases all stats.
     *
     * Being successful makes the next success even more likely!
     */
    private void increaseAllStats() {
        this.chance += 0.05;
        this.health += 50;
        this.moveHealthChange += 1;
        this.attackDamage += 10;
        this.maxAge += 10;
        this.reproductionRate += 0.05;
        this.maxReproductionCooldown -= 2;
    }
}
