package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.exeption.DaoExeption;

public interface StudentOrderDao {
    Long saveStudentOrder(StudentOrder so) throws DaoExeption;
}
