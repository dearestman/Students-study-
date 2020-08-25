package edu.javacourse.studentorder;

import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.mail.mailSender;
import edu.javacourse.studentorder.validator.ChildrenValidator;
import edu.javacourse.studentorder.validator.CityRegisterValidator;
import edu.javacourse.studentorder.validator.StudentValidator;
import edu.javacourse.studentorder.validator.WeedingValidator;

public class StudentOrderValidator {


    public static void main(String[] args) {

        checkAll();
    }

    static void checkAll(){
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

    static StudentOrder readStudentOrder(){
        StudentOrder so = new StudentOrder();
        return so;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder so){
        CityRegisterValidator crv1 = new CityRegisterValidator();
        crv1.hostName = "Host1";
//        crv1.login = "login1";
//        crv1.password = "password1";
        CityRegisterValidator crv2 = new CityRegisterValidator();
//        crv2.login = "login2";
        crv2.hostName = "Host2";
//        crv2.password = "password2";
        AnswerCityRegister ans1 = crv1.checkCityRegister(so);
        AnswerCityRegister ans2 = crv2.checkCityRegister(so);

        return ans1;
    }

    static AnswerWeeding checkWedding(StudentOrder so){
        WeedingValidator wd = new WeedingValidator();
        return wd.checkWedding(so);
    }

    static AnswerChildren checkChildren(StudentOrder so){
        ChildrenValidator cv = new ChildrenValidator();
        return cv.checkChildren(so);
    }

    static AnswerStudent checkStudent(StudentOrder so) {
        return new StudentValidator().checkStudent(so);
    }

    static void sendMail(StudentOrder so){
        new mailSender().sendMail(so);
    }
}
