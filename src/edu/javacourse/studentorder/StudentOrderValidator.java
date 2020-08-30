package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.MailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeedingValidator;

public class StudentOrderValidator {

    private CityRegisterValidator cityRegisterVal;
    private WeedingValidator weedingVal;
    private ChildrenValidator childrenVal;
    private StudentValidator studentVal;
    private MailSender mailSender;

    public StudentOrderValidator(){
        cityRegisterVal = new CityRegisterValidator();
        weedingVal = new WeedingValidator();
        childrenVal = new ChildrenValidator();
        studentVal = new StudentValidator();
        mailSender = new MailSender();
    }
    public static void main(String[] args) {
        StudentOrderValidator sov = new StudentOrderValidator();
        sov.checkAll();
    }

    public void checkAll(){
//

        while (true){

            StudentOrder so = readStudentOrder();
            if(so==null){
                break;//Прерывание цикла
            }
                AnswerCityRegister citiAnswer = checkCityRegister(so);
            if (!citiAnswer.success){
//                continue;//следующая итерация

                break;
            }
                AnswerWeeding wedAnswer = checkWedding(so);
                AnswerChildren childAnswer = checkChildren(so);
                AnswerStudent studentAnswer = checkStudent(so);

                sendMail(so);
                so=readStudentOrder();
        }
    }

    public StudentOrder readStudentOrder(){
        StudentOrder so = new StudentOrder();
        return so;
    }

    public AnswerCityRegister checkCityRegister(StudentOrder so){
        return cityRegisterVal.checkCityRegister(so);
    }

    public AnswerWeeding checkWedding(StudentOrder so){
        return weedingVal.checkWedding(so);
    }

    public AnswerChildren checkChildren(StudentOrder so){
        return childrenVal.checkChildren(so);
    }

    public AnswerStudent checkStudent(StudentOrder so) {
        return studentVal.checkStudent(so);
    }

    public void sendMail(StudentOrder so){
        mailSender.sendMail(so);
    }
}
