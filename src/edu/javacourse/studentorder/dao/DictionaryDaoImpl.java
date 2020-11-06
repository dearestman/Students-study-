package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.StudentOrderValidator;
import edu.javacourse.studentorder.config.Config;
import edu.javacourse.studentorder.domain.PassportOffice;
import edu.javacourse.studentorder.domain.RegisterOffice;
import edu.javacourse.studentorder.domain.Street;
import edu.javacourse.studentorder.exeption.DaoExeption;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DictionaryDaoImpl implements DictionaryDao{
    private static final String GET_STREET = "" +
            "SELECT street_code, street_name " +
            "FROM js_street " +
            "WHERE upper(street_name) like upper(?)";

    private static final String GET_PASSPORT = "SELECT * FROM js_passport_office WHERE p_office_area_id = ?";
    private static final String GET_REGISTER = "SELECT * FROM js_register_office WHERE r_office_area_id = ?";
    private Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(
                Config.getProperty(Config.DB_URL),
                Config.getProperty(Config.DB_LOGIN), Config.getProperty(Config.DB_PASSWORD)
        );
        return  con;
    }

    public List<Street> findStreets(String pattern) throws DaoExeption {
        List<Street> result = new LinkedList<>();

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_STREET)){
            stmt.setString(1, "%"+pattern+"%"); //парамметр в запрос так как prepareStatement
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Street str = new Street(rs.getLong("street_code"), rs.getString("street_name"));
                result.add(str);
            }
            return result;
        }
        catch (SQLException ex){
            throw new DaoExeption(ex);
        }
    }

    @Override
    public List<PassportOffice> findPassportOffices(String areaId) throws DaoExeption {
        List<PassportOffice> result = new LinkedList<>();

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_PASSPORT)){
            stmt.setString(1, areaId); //парамметр в запрос так как prepareStatement
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                PassportOffice str = new PassportOffice(
                        rs.getLong("p_office_id"),
                        rs.getString("p_office_area_id"),
                        rs.getString("p_office_name")
                        );
                result.add(str);
            }
            return result;
        }
        catch (SQLException ex){
            throw new DaoExeption(ex);
        }
    }

    @Override
    public List<RegisterOffice> findRegisterOffices(String areaId) throws DaoExeption {
        List<RegisterOffice > result = new LinkedList<>();

        try (Connection con = getConnection();
             PreparedStatement stmt = con.prepareStatement(GET_REGISTER)){
            stmt.setString(1, areaId); //парамметр в запрос так как prepareStatement
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                RegisterOffice str = new RegisterOffice(
                        rs.getLong("r_office_id"),
                        rs.getString("r_office_area_id"),
                        rs.getString("r_office_name")
                );
                result.add(str);
            }
            return result;
        }
        catch (SQLException ex){
            throw new DaoExeption(ex);
        }
    }
}