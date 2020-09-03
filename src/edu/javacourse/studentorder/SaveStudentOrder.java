package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.domain.other.Adult;
import edu.javacourse.studentorder.domain.StudentOrder;

//Класс студенческого заявления
public class SaveStudentOrder {
    public static void main(String[] args) {
//        buildStudentOrder();


//        StudentOrder so = new StudentOrder();
//        long ans = saveStudentOrder(so);
//        System.out.println(ans);
    }
     static long saveStudentOrder(StudentOrder studentOrder) {
        long answer = 199 ;
        System.out.println("saveStudentOrder: ");

        return answer;
    }

    public static StudentOrder buildStudentOrder(long id){

        StudentOrder so = new StudentOrder();
        so.setStudentOrderId(id);

        Adult husband = new Adult("Васильев","Андрей","Петрович",null);

        return so;
    }
}
