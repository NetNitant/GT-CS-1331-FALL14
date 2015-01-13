import java.awt.Rectangle;

/**
 * The basis for northern Houses.
 * @author  Nitant Dandekar
 * @version 1.0
 */
public abstract class NorthHouse extends House {
    protected final Rectangle northHalf;

    /**
     * Spawns a NorthHouse.
     * @param imageFilename the name of the image this NorthHouse uses
     * @param x             the x-coordinate this NorthHouse starts at
     * @param y             the y-coordinate this NorthHouse starts at
     * @param bounds        the grid this NorthHouse will roam
     */
    protected NorthHouse(String imageFilename, int x, int y, Rectangle bounds) {
        super(imageFilename, x, y, bounds);

        this.northHalf = new Rectangle(this.grid);
        this.northHalf.setSize((int) this.northHalf.getWidth()
                               , (int) (this.northHalf.getHeight() / 2));
    }

    /**
     * Performs a move action.
     *
     * If in north half, health bonuses are given.
     */
    @Override
    protected void move() {
        if (this.northHalf.contains(this.location)) {
            this.moveHealthChange = 2;
        } else {
            this.moveHealthChange = -2;
        }

        super.move();
    }
}
