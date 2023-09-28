import com.version1.TestSpringBootApp.model.Person;

import java.util.*;

public class LambdaExpressionExercise {

    public static void main(String[] args) {


        List<Person> people = Arrays.asList(
                new Person("John", "Doe"),
                new Person("Charles", "Dickens"),
                new Person("Thomas", "Carroll"),
                new Person("Charlotte", "Arnold"),
                new Person("James", "Smith"),
                new Person("Martin", "Jones"),
                new Person("Alex", "Mason"),
                new Person("Will", "Anderson")
        );

        //step 1: Sort the list by the last name

        Collections.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getSurname().compareTo(o2.getSurname());
            }
        });

        //Step 2: method to print the sorted list
        printAll(people);

        //step 3: method to print names with surname starting with "D"
        printNamesStartingWithD(people);

    }

    private static void printNamesStartingWithD(List<Person> people) {
        for(Person p: people) {
            if(p.getSurname().startsWith("D")) {
                System.out.println(p);
            }
        }
    }

    private static void printAll(List<Person> people) {
        for(Person p: people) {
            System.out.println(p);
        }
    }
}
