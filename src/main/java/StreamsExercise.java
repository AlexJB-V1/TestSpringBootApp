import com.version1.TestSpringBootApp.model.Person;

import java.util.*;
import java.util.stream.Stream;

public class StreamsExercise {

    public static void main(String[] args) {
        List<Integer> ids = List.of(23, 45, 2, 34, 76, 67, 6, 4);

        // Print all numbers in the number Stream

        //print numbers less than 35

        //print second and third numbers that are greater than 35

        //print first number that's greater than 45, if not found print -1

        //sort numbers in natural order

        //sort in descending order

        //print first names of users
        List<Person> people = Arrays.asList(
                new Person("John", "Doe", 1),
                new Person("Charles", "Dickens", 2),
                new Person("Thomas", "Carroll", 3),
                new Person("Charlotte", "Arnold", 4),
                new Person("James", "Smith", 5),
                new Person("Martin", "Jones", 6),
                new Person("Alex", "Mason", 7),
                new Person("Will", "Anderson", 8)
        );
        List<Integer> numbers = List.of(23, 45, 2, 34, 76, 67, 6, 4);


        //print persons that have Ids from the numberstream

    }
}
