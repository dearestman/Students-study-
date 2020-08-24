public class CityRegisterValidator {

    String hostName;

    static AnswerCityRegister checkCityRegister(StudentOrder so){
        System.out.println("checkCityRegister is working!");
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success=false;
        return ans;
    }
}