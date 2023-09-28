import com.version1.TestSpringBootApp.model.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LambdaExpressionExerciseJava8version {

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

        Collections.sort(people, (o1, o2) -> o1.getSurname().compareTo(o2.getSurname()));

        //Step 2: method to print the sorted list
        printConditionally(people, (p) -> true);

        //step 3: method to print names with surname starting with "D"
        printConditionally(people, (p) -> p.getSurname().startsWith("D"));

        printUsingConsumer(people, (p) -> System.out.println(p));

    }

    private static void printUsingConsumer(List<Person> people, Consumer<Person> consumer) {
        for (Person p: people) {
            consumer.accept(p);
        }
    }

    private static void print(Person p) {
        p.setSurname("Doe");
        System.out.println(p);
    }

    private static void printConditionally(List<Person> people, Predicate<Person> condition) {
        for(Person p: people) {
            //if (p.getSurname().startsWith("D")
            if(condition.test(p)) {
                System.out.println(p);
            }
        }
    }
}
