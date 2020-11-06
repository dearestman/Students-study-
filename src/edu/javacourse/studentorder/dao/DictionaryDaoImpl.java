package edu.javacourse.studentorder.dao;

import edu.javacourse.studentorder.StudentOrderValidator;
import edu.javacourse.studentorder.config.Config;
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
}
