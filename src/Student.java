import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface HasEmail {
    String getEmail();
}


class Student extends Person implements HasEmail, Cloneable{

    public String studentID;
    public String email;
    public List<Grade> grades;

    public Student(String firstName, String lastName, String dateOfBirth, String studentID, String email, List<Grade> grades) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.studentID = studentID;
        this.email = email;
        this.grades = grades;
    }

    public double avgGrade() {
        if (grades.isEmpty()) {
            return 0.0;
        }
        double totalScore = 0.0;
        for (Grade grade : grades) {
            totalScore += grade.getScore();
        }
        return totalScore / grades.size();
    }

    public void printStudent() {
        System.out.println("Имя: " + firstName);
        System.out.println("Фамилия: " + lastName);
        System.out.println("Дата рождения: " + dateOfBirth);
        System.out.println("Номер студенческого билета: " + studentID);
        System.out.println("Email: " + email);

        System.out.println("\nОценки:");
        for (Grade grade : grades) {
            grade.printGrade();
            System.out.println();
        }
    }

    public static Student inputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите имя: ");
        String firstName = scanner.next();
        System.out.print("Введите фамилию: ");
        String lastName = scanner.next();
        System.out.print("Введите дату рождения: ");
        String dateOfBirth = scanner.next();
        System.out.print("Введите номер студенческого билета: ");
        String studentID = scanner.next();
        System.out.print("Введите email: ");
        String email = scanner.next();

        List<Grade> grades = new ArrayList<>();
        char addGrade;
        do {
            Grade grade = Grade.inputFromConsole();
            grades.add(grade);

            System.out.print("Добавить еще одну оценку? (y/n): ");
            addGrade = scanner.next().charAt(0);
        } while (addGrade == 'y' || addGrade == 'Y');

        return new Student(firstName, lastName, dateOfBirth, studentID, email, grades);
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getEmailDomain() {
        int atIndex = this.email.indexOf('@');
        if (atIndex != -1) {
            return this.email.substring(atIndex + 1);
        }
        return "";
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    protected void printFullNameAndEmail() {
        System.out.println("Полное имя: " + getFullName());
        System.out.println("Email: " + email);
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Имя: ").append(firstName).append("\n");
        result.append("Фамилия: ").append(lastName).append("\n");
        result.append("Дата рождения: ").append(dateOfBirth).append("\n");
        result.append("Номер студенческого билета: ").append(studentID).append("\n");
        result.append("Email: ").append(email).append("\n\nОценки:\n");

        for (Grade grade : grades) {
            result.append(grade.toString()).append("\n");
        }

        return result.toString();
    }

    @Override
    public String getEmail() {
        return email;
    }

    /* 8) Клонирование */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student clonedStudent = (Student) super.clone();
        // Глубокое клонирование grades
        clonedStudent.grades = new ArrayList<>(this.grades.size());
        for (Grade grade : this.grades) {
            clonedStudent.grades.add((Grade) grade.clone());
        }
        return clonedStudent;
    }

}