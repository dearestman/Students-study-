//Класс студенческого заявления
public class SaveStudentOrder {
    public static void main(String[] args) {
        StudentOrder so = new StudentOrder();
        so.hFirstName = "Алексей";
        so.hFLastName = "Петров";
        so.wFirstName = "Галина";
        so.wFLastName = "Петровна";

        long ans = saveStudentOrder(so);
        System.out.println(ans);
    }
    static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199;
        System.out.println("saveStudentOrder: " + studentOrder.hFLastName);
        return answer;
    }
}
