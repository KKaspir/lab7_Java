import java.util.List;


class InternationalStudent extends Student {
    private String country;


    public InternationalStudent(String firstName, String lastName, String dateOfBirth, String studentID, String email, List<Grade> grades, String country) {
        super(firstName, lastName, dateOfBirth, studentID, email, grades);
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public void printStudent() {
        super.printStudent();
        System.out.println("Страна: " + country);
    }

    @Override
    protected void printFullNameAndEmail() {
        super.printFullNameAndEmail();
        System.out.println("Страна: " + country);
    }

    protected void printFullNameAndEmailWithCountry() {
        System.out.println("Полное имя: " + getFullName());
        System.out.println("Email: " + getEmail());
        System.out.println("Страна: " + country);
    }
}
