import java.util.Scanner;

class Grade implements Cloneable{
    private String subject;
    private double score;
    private String date;

    public Grade(String subject, double score, String date) {
        this.subject = subject;
        this.score = score;
        this.date = date;
    }

    public void printGrade() {
        System.out.println("Предмет: " + subject);
        System.out.println("Оценка: " + score);
        System.out.println("Дата: " + date);
    }

    public static Grade inputFromConsole() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите предмет: ");
        String subject = scanner.next();

        // try-блок
        try {
            System.out.print("Введите оценку: ");
            double score = scanner.nextDouble();
            System.out.print("Введите дату: ");
            String date = scanner.next();

            // throw для вызова исключения
            if ((score < 0.0) || (score > 100.0)) {
                throw new IllegalArgumentException("Оценка должна быть в диапазоне [0, 100]");
            }

            return new Grade(subject, score, date);
        } catch (Exception e) {
            // Перехватываем исключение и выводим сообщение об ошибке
            System.err.println("Ошибка ввода: " + e.getMessage());
            return null;
        }
    }

    public double getScore() {
        return score;
    }

    // теперь clone вызывает super.clone() для глубокого клонирования
    @Override
    protected Grade clone() throws CloneNotSupportedException {
        return (Grade) super.clone();
    }
}