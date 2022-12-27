//This class will contain all the information for a given person in the graph ie: name, DOB, relationships, etc

import java.util.Vector;

public class Person {
    String name;
    //Add other characteristics here

    private Vector<Relationship> relationships;

    public Person(String name) {
        relationships = new Vector<>();

        this.name = name;
    }

    public void addRelation(Person person, RelationshipType type) {
        relationships.add(new Relationship(this, person, type));
    }

    public void displayRelations() {
        System.out.println("Relationships of " + name);

        //check if the person has relationships to display
        if(relationships.isEmpty()) {
            System.out.println(name + " has no relationships");
        }
        else {
            for (Relationship relationship : relationships) {
                System.out.println(relationship.type + " - " + relationship.b.name);
            }
        }
        System.out.println();
    }
}
