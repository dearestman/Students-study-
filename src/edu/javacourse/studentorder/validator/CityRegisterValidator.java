package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.AnswerCityRegister;
import edu.javacourse.studentorder.domain.StudentOrder;

public class CityRegisterValidator {

    public String hostName;
    protected int port;
    private String login;
    String password;

    public AnswerCityRegister checkCityRegister(StudentOrder so){
        System.out.println("checkCityRegister is working!"
                +hostName+", "+login+", "+password);
        AnswerCityRegister ans = new AnswerCityRegister();
        ans.success=false;
        return ans;
    }
}