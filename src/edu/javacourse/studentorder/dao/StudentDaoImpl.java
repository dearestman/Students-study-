package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.config.Config;
import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.domain.StudentOrder;
import edu.javacourse.studentorder.domain.StudentOrderStatus;
import edu.javacourse.studentorder.exeption.DaoExeption;

import java.sql.*;

public class StudentDaoImpl implements StudentOrderDao{

     public static final String INSERT_ORDER =
             "INSERT INTO js_student_order(student_order_status, student_order_date, h_sur_name, " +
                     "h_given_name, h_patronymic, h_date_of_birth, h_passport_serial, h_passport_number, h_passport_date, h_passport_office_id, h_post_index, h_street_code, h_building, h_extension, h_apartment, w_sur_name, w_given_name, w_patronymic, w_date_of_birth, w_passport_serial, w_passport_number, w_passport_date, w_passport_office_id, w_post_index, w_street_code, w_building, w_extension, w_apartment, certificate_id, register_office_id, marriage_date) " +
             "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    // TODO refactoring- make one method
    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN), Config.getProperty(Config.DB_PASSWORD)
        );
        return  con;
    }

    @Override
    public Long saveStudentOrder(StudentOrder so) throws DaoExeption {


        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_ORDER)){
            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2, Timestamp.valueOf(so.getStudentOrderDate()));
            stmt.setString(3,so.getHusband().getSurName());
            stmt.setString(4,so.getHusband().getGivenName());
            stmt.setString(4,so.getHusband().getPatronymic());
            stmt.setDate(5, Date.valueOf(so.getHusband().getDateOfBirth()));
            stmt.setString(5, so.getHusband().getPassportSerial());
            stmt.setString(5, so.getHusband().getPassportSerial());
            stmt.setString(5, so.getHusband().getPassportNumber());
            stmt.setString(5, so.getHusband().getPassportNumber());
//            stmt.setDate(5, so.getHusband().get());



        }
        catch (SQLException ex){
            throw new DaoExeption(ex);
        }

        return null;
    }
}
