import java.util.Objects;
import java.util.Vector;

//Technically a Graph
public class Tree {
    Vector<Person> people;

    //start with one person
    public Tree(Person rootPerson) {
        people = new Vector<>();
        people.add(rootPerson);
    }

    public Tree(Vector<Person> people) {
        this.people = people;
    }

    public void addPerson(Person personToAdd, Person referencePerson, RelationshipType type) {

        personToAdd.addRelation(referencePerson, type);

        RelationshipType inverseType;

        //Invert the relationType for the other direction of the link
        if(type == RelationshipType.CHILD)
            inverseType = RelationshipType.PARENT;
        else if(type == RelationshipType.PARENT)
            inverseType = RelationshipType.CHILD;
        else
            inverseType = type;

        referencePerson.addRelation(personToAdd, inverseType);

        people.add(personToAdd);

        //UPDATE REFERENCE PERSON IN VECTOR
        people.setElementAt(referencePerson, people.indexOf(referencePerson));
    }

    public Person findPersonByName(String name) {
        for (Person person : people) {
            if(Objects.equals(person.name, name))
                return person;
            else {
                System.out.println("Person named " + name + " does not exist in tree.");
                return null;
            }
        }
        return null;
    }

    public void displayPeople() {
        for(Person person : people) {
            person.displayRelations();
        }
    }
}
