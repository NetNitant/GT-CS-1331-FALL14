public class House {
    private String owner;
    private int bedrooms;
    private double bathrooms;
    private boolean garage;

    private static int totalHouses;

    public House(String owner, int bedrooms, double bathrooms, boolean garage) {
        this.setOwner(owner);
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.garage = garage;

        totalHouses++;
    }

    public String getOwner() {
        return new String(this.owner);
    }

    public void setOwner(String owner) {
        if (owner == null || owner.equals("")) {
            this.owner = "HOMEOWNER";
        } else {
            this.owner = owner;
        }
    }

    public void buildBedroom() {
        this.bedrooms++;
    }

    public String toString() {
        String description = "House owned by " + this.getOwner();
        description += ", " + this.bedrooms + " bed";
        description += "/" + this.bathrooms + " bath";
        description += ", garage: " + this.garage;
        description += ", total houses: " + House.totalHouses;

        return description;
    }
}
