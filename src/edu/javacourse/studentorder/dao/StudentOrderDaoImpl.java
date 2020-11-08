package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.config.Config;
import edu.javacourse.studentorder.domain.*;
import edu.javacourse.studentorder.exeption.DaoExeption;

import java.sql.*;
import java.time.LocalDateTime;

public class StudentOrderDaoImpl implements StudentOrderDao{

     public static final String INSERT_ORDER =
             "INSERT INTO js_student_order(student_order_status, student_order_date, h_sur_name, " +
                     "h_given_name, h_patronymic, h_date_of_birth, h_passport_serial, h_passport_number, " +
                     "h_passport_date, h_passport_office_id, h_post_index, h_street_code, h_building, h_extension, " +
                     "h_apartment, w_sur_name, w_given_name, w_patronymic, w_date_of_birth, w_passport_serial, w_passport_number, " +
                     "w_passport_date, w_passport_office_id, w_post_index, w_street_code, w_building, w_extension, w_apartment, " +
                     "certificate_id, register_office_id, marriage_date) " +
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

        Long result = -1L;


        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(INSERT_ORDER, new String[] {"student_order_id"})){

            stmt.setInt(1, StudentOrderStatus.START.ordinal());
            stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));

            //husband and wife
            setParamsForAdult(stmt, 3, so.getHusband());
            setParamsForAdult(stmt, 16, so.getWife());

            //marry info
            stmt.setString(29, so.getMarriageCertificateId());
            stmt.setLong(30, so.getMarriageOffice().getOfficeId());
            stmt.setDate(31, Date.valueOf(so.getMarriageDate()));

            stmt.executeUpdate();

            ResultSet gkRs = stmt.getGeneratedKeys();
            if (gkRs.next()){
                result = gkRs.getLong(1);
            }
            gkRs.close();


        }
        catch (SQLException ex){
            throw new DaoExeption(ex);
        }

        return result;
    }

    private void setParamsForAdult(PreparedStatement stmt, int start, Adult adult) throws SQLException {
        stmt.setString(start,adult.getSurName());
        stmt.setString(start+1,adult.getGivenName());
        stmt.setString(start+2,adult.getPatronymic());
        stmt.setDate(start+3, Date.valueOf(adult.getDateOfBirth()));
        stmt.setString(start+4, adult.getPassportSerial());
        stmt.setString(start+5, adult.getPassportNumber());
        stmt.setDate(start+6, Date.valueOf(adult.getIssueDate()));
        stmt.setLong(start+7, adult.getIssueDepartment().getOfficeId());
        //husband address
        Address h_address = adult.getAddress();
        stmt.setString(start+8, h_address.getPostCode());
        stmt.setLong(start+9, h_address.getStreet().getStreetCode());
        stmt.setString(start+10, h_address.getBuilding());
        stmt.setString(start+11, h_address.getExtension());
        stmt.setString(start+12, h_address.getApartment());
    }
}
