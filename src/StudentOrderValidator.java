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
                System.out.println("не Success!");
                continue;//следующая итерация
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
        return null;
//        return so;
    }

    static AnswerCityRegister checkCityRegister(StudentOrder so){
        return CityRegisterValidator.checkCityRegister(so);
    }

    static AnswerWeeding checkWedding(StudentOrder so){
        return WeedingValidator.checkWedding(so);
    }

    static AnswerChildren checkChildren(StudentOrder so){
        return ChildrenValidator.checkChildren(so);
    }

    static AnswerStudent checkStudent(StudentOrder so) {
        return StudentValidator.checkStudent(so);
    }

    static void sendMail(StudentOrder so){
        System.out.println("mail is sending!");
    }
}
