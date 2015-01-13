import java.awt.Rectangle;

/**
 * The basis for southern Houses.
 * @author  Nitant Dandekar
 * @version 1.0
 */
public abstract class SouthHouse extends House {
    protected final Rectangle southHalf;

    /**
     * Spawns a SouthHouse.
     * @param imageFilename the name of the image this SouthHouse uses
     * @param x             the x-coordinate this SouthHouse starts at
     * @param y             the y-coordinate this SouthHouse starts at
     * @param bounds        the grid this SouthHouse will roam
     */
    protected SouthHouse(String imageFilename, int x, int y, Rectangle bounds) {
        super(imageFilename, x, y, bounds);

        this.southHalf = new Rectangle(this.grid);
        this.southHalf.setLocation((int) this.southHalf.getX(),
                                   (int) (this.southHalf.getY()
                                   + (this.southHalf.getHeight() / 2)));
        this.southHalf.setSize((int) this.southHalf.getWidth()
                               , (int) (this.southHalf.getHeight() / 2));
    }

    /**
     * Performs a move action.
     *
     * If in south half, move rate bonuses given.
     */
    @Override
    protected void move() {
        if (this.southHalf.contains(this.location)) {
            this.moveRate = 50;
        } else {
            this.moveRate = 25;
        }

        super.move();
    }
}
