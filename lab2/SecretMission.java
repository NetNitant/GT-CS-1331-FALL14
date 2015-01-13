/**
 * Secret Mission
 *
 * you may ADD to this class header, but do not change the
 * visibility or class name
 */
public class SecretMission extends Mission {
    public static final String CLASSIFIED_STRING = "This information "
        + "is Classified.";

    private boolean locked;
    private SecurityClearance requiredClearance;

    public SecretMission(String title, String description
                         , SecurityClearance requiredClearance) {
        super(title, description);

        this.requiredClearance = requiredClearance;
        this.locked = true;
    }

    /**
     * unlocks the mission's info, given some security clearance
     * should check the given clearance against the mission's clearance and
     * throw an AccessDeniedException if it is insufficient clearance.
     *
     * You may (must) ADD to this method header, but do not change the
     * visibility, return type, or method name.
     */
    public void unlockInfo(SecurityClearance clearance)
        throws AccessDeniedException {
        if (clearance.ordinal() >= requiredClearance.ordinal()) {
            locked = false;
        } else {
            throw new AccessDeniedException(requiredClearance);
        }
    }

    /*
        HINT
        the .ordinal() method on an enum value gives you its position relative
        to the other values.
        For example, you can compare like so:
        someClearance.ordinal() < anotherClearance.ordinal()
        someClearance.ordinal() >= anotherClearance.ordinal()
        someClearance.ordinal() == anotherClearance.ordinal()

        e.g, SecurityClearance.CONFIDENTIAL.ordinal() > SecurityClearance.
            SECRET.ordinal() would return true
    */

    public void setDescription(String description) {
        if (!locked) {
            super.setDescription(description);
        }
    }

    public String toString() {
        if (!locked) {
            return super.toString();
        } else {
            return CLASSIFIED_STRING;
        }
    }
}
