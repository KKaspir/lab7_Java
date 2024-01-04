import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем коллекцию для хранения объектов Person и его производных классов
        List<Person> people = new ArrayList<>();
        people.add(new Student("John", "Doe", "01.01.2000", "12345", "egypt@example.com", List.of(new Grade("Math", 85, "01.01.2023"), new Grade("History", 92, "02.01.2023"))));
        people.add(new Student("Alice", "Smith", "01.01.2000", "56789", "egypt@example.com", List.of(new Grade("Math", 85, "01.01.2023"), new Grade("History", 92, "02.01.2023"))));
        people.add(new InternationalStudent("Garas", "Peter", "01.01.2000", "67890", "egypt@example.com", List.of(new Grade("Math", 85, "01.01.2023"), new Grade("History", 92, "02.01.2023")), "Egypt"));
        people.add(new InternationalStudent("Eva", "Lee", "01.01.2000","98765","egypt@example.com", List.of(new Grade("Math", 85, "01.01.2023"), new Grade("History", 92, "02.01.2023")), "Canada"));

        // Используем алгоритм сортировки для сортировки по полному имени
        Collections.sort(people, (p1, p2) -> p1.getFullName().compareTo(p2.getFullName()));

        // Выводим отсортированный список
        System.out.println("Список после сортировки:");
        for (Person person : people) {
            System.out.println(person.getFullName());
        }

        // Используем алгоритм поиска для поиска студента по ID
        String targetID = "67890";
        for (Person person : people) {
            if (person instanceof Student) {
                Student student = (Student) person;
                if (student.getStudentID().equals(targetID)) {
                    System.out.println("\nПоиск по ID\nСтудент с ID " + targetID + " найден: \n" + student.getFullName());
                    break;
                }
            }
        }
    }
}