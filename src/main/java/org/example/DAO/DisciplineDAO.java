package org.example.DAO;

import org.example.connection.toDB.ConnectionToAthletes;
import org.example.entity.Discipline;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class DisciplineDAO {

    private final ConnectionToAthletes CONNECT;
    LocalDateTime today = LocalDateTime.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
    private static final String SELECT_ALL = "SELECT * FROM disciplines";


    public DisciplineDAO(ConnectionToAthletes CONNECT) {
        this.CONNECT = CONNECT;
    }


    public List<Discipline> getAllDisciplines() {

        Connection connection = CONNECT.getConnect();

        List<Discipline> disciplines = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()){
                Discipline discipline = new Discipline(resultSet.getInt("DISCIPLINE_ID"),
                        resultSet.getString("disciplineName"),
                        resultSet.getString("disciplineCreatedAt"),
                        resultSet.getString("disciplineLastChange"));

                disciplines.add(discipline);
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select all disciplines of them", e);
        }

        return disciplines;
    }

    public void insertDiscipline(Discipline discipline) {

        Connection connection = CONNECT.getConnect();

        final String INSERT_DISCIPLINE = "INSERT INTO disciplines VALUES (%d, '%s', '%s')".formatted(discipline.getDISCIPLINE_ID(),
                discipline.getDisciplineName(),
                today.format(formatter));

        try(Statement statement = connection.createStatement()) {

            statement.execute(INSERT_DISCIPLINE);

        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to insert this discipline of them to data base", e);
        }
    }

    public void deleteDisciplineByName(String name) {

        Connection connection = CONNECT.getConnect();

        final String DELETE_DISCIPLINE = "DELETE FROM disciplines WHERE disciplineName = %s".formatted(name);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(DELETE_DISCIPLINE);

        } catch (SQLException e) {
            throw new RuntimeException("Delete this discipline didn't occur", e);
        }
    }


    public void updateDisciplineByName(String name, Discipline discipline) {

        Connection connection = CONNECT.getConnect();

        final String UPDATE_DISCIPLINE = "UPDATE disciplines SET disciplineName = '%s', WHERE disciplineName = %s".formatted(discipline.getDisciplineName(), name);
        final String LAST_CHANGE = "UPDATE disciplines SET disciplineLastChange = '%s', WHERE disciplineName = %s".formatted(today.format(formatter), name);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(UPDATE_DISCIPLINE);
            statement.executeUpdate(LAST_CHANGE);

        } catch (SQLException e) {
            throw new RuntimeException("Update the discipline failed", e);
        }
    }


    public Discipline getDisciplineByName(String name) {

        Connection connection = CONNECT.getConnect();

        Discipline discipline = null;

        final String SELECT_EVENT = "SELECT * FROM disciplines WHERE disciplineName = %s".formatted(name);

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_EVENT);

            while (resultSet.next()){
                if (resultSet.getString("disciplineName").equals(name)) {
                    discipline = new Discipline(resultSet.getInt("DISCIPLINE_ID"),
                            resultSet.getString("disciplineName"),
                            resultSet.getString("disciplineCreatedAt"),
                            resultSet.getString("disciplineLastChange"));
                    break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select this discipline of them", e);
        }

        return discipline;
    }
}
