package edu.javacourse.studentorder.validator;

import edu.javacourse.studentorder.domain.register.CityRegisterResponse;
import edu.javacourse.studentorder.domain.Person;
import edu.javacourse.studentorder.exeption.CityRegisterException;

public class RealCityRegisterChecker implements CityRegisterChecker{
    public CityRegisterResponse checkPerson(Person person) throws CityRegisterException {
        return null;
    }
}
