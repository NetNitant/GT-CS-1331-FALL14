/**
 * Represents a Pokemon object. Each has a number, a name, and two elemental
 * types, chosen from the PokemonType enumeration.
 *
 * @author Joe Rossi, Nitant Dandekar
 * @version 2.0
 */
public class Pokemon implements Comparable<Pokemon> {

    private int num;
    private String name;
    private PokemonType primaryType;
    private PokemonType secondaryType;

    /**
     * Constructs a Pokemon object
     *
     * @param num   this Pokemon's unique number
     * @param name  this Pokemon's name
     * @param p this Pokemon's primary type
     * @param s this Pokemon's secondary type
     */
    public Pokemon(int num, String name, PokemonType p, PokemonType s) {
        this.num = num;
        this.name = name;
        this.primaryType = p;
        this.secondaryType = s;
    }

    @Override
    public int compareTo(Pokemon o) {
        return getNumber() - o.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (this == o) {
            return true;
        }

        if (!(o instanceof Pokemon)) {
            return false;
        }

        return getNumber() == ((Pokemon) o).getNumber();
    }

    @Override
    public int hashCode() {
        return getNumber();
    }

    @Override
    public String toString() {
        return String.format(
            "# %4d: %-11s Primary Type: %-10s Secondary Type: %s"
            , getNumber(), getName(), getPrimaryType(), getSecondaryType());
    }

    /**
     * @return  the name of this Pokemon
     */
    public String getName() {
        return name;
    }

    /**
     * @return  the unique number of this Pokemon
     */
    public int getNumber() {
        return num;
    }

    /**
     * @return  the primary type of this Pokemon
     */
    public PokemonType getPrimaryType() {
        return primaryType;
    }

    /**
     * @return  the secondary type of this Pokemon
     */
    public PokemonType getSecondaryType() {
        return secondaryType;
    }
}
