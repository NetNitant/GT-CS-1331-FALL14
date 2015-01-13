public class GraduateStudent extends Student {
    public GraduateStudent(String firstName, String lastName, int intelligence,
                           int motivation) {
        super(firstName, lastName, intelligence, motivation);
    }

    public String toString() {
        return "Hi, my name is " + this.firstName + " " + this.lastName + ". "
               + "My intelligence is " + this.intelligence + "/10 and my "
               + "motivation is " + this.motivation + "/10. "
               + "I’m stressed out AND broke.";
    }
}
