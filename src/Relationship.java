public class Relationship {
    Person a, b;

    RelationshipType type;

    //eventually make type an enum. Marriage, Sibling, Parental
    public Relationship(Person a, Person b, RelationshipType type) {
        if(a==b) {
            System.out.println("Relationship must have 2 different people");
            return;
        }
        this.a = a;
        this.b = b;
        this.type = type;
    }
}
