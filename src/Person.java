abstract class Person {
    protected String firstName;
    protected String lastName;
    protected String dateOfBirth;

    //базовый метод который будет нужен для сортировки по имени
    public String getFullName() {
        return firstName + " " + lastName;
    }
}

