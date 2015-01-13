public class PersonList {
    private Person[] people;
    private int count;

    public PersonList(int maxSize) {
        this.people = new Person[maxSize];
    }

    public void listPeople() {
        for (int i = 0; i < this.count; i++) {
            if (this.people[i] != null) {
                System.out.println(this.people[i].toString());
            }
        }
    }

    public void add(Person p) {
        if (this.count < this.people.length) {
            this.people[this.count] = p;
            this.count++;
        }
    }
}
