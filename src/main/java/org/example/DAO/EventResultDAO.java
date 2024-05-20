package org.example.DAO;

import org.example.DTO.EventResultDTO;
import org.example.connection.toDB.ConnectionToAthletes;
import org.example.entity.EventResult;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventResultDAO {

    private final ConnectionToAthletes CONNECT;
    LocalDateTime today = LocalDateTime.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
    private static final String SELECT_ALL = "SELECT * FROM eventResults er LEFT JOIN events e у ON er.EVENT_ID = e.EVENT_ID" +
            "LEFT JOIN disciplines d ON er.DISCIPLINE_ID = d.DISCIPLINE_ID" +
            "er LEFT JOIN athletes a ON p.ATHLETE_ID = a.ATHLETE_ID";


    public EventResultDAO(ConnectionToAthletes CONNECT) {
        this.CONNECT = CONNECT;
    }


    public List<EventResultDTO> getAllEventResults() {

        Connection connection = CONNECT.getConnect();

        List<EventResultDTO> eventResults = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()){
                EventResultDTO eventResult = new EventResultDTO(resultSet.getInt("EVENT_ID"),
                        resultSet.getString("discipline"),
                        resultSet.getString("athleteName"),
                        resultSet.getString("athleteCountry"),
                        resultSet.getString("result"),
                        resultSet.getString("eventResultCreatedAt"),
                        resultSet.getString("eventResultLastChange"));

                eventResults.add(eventResult);
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select all event results of them", e);
        }

        return eventResults;
    }

    public void insertEventResult(EventResult eventResult) {

        Connection connection = CONNECT.getConnect();

        final String INSERT_EVENT_RESULT = "INSERT INTO eventResults VALUES (%d, %d, '%d', '%s', '%s')".formatted(eventResult.getEVENT_ID(),
                eventResult.getDisciplineID(),
                eventResult.getAthleteID(),
                eventResult.getResult(),
                today.format(formatter));

        try(Statement statement = connection.createStatement()) {

            statement.execute(INSERT_EVENT_RESULT);

        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to insert this event result of them to data base", e);
        }
    }

    public void deleteEventResultByAthleteID(int id) {

        Connection connection = CONNECT.getConnect();

        final String DELETE_EVENT_RESULT = "DELETE FROM eventResults WHERE athleteID = %d".formatted(id);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(DELETE_EVENT_RESULT);

        } catch (SQLException e) {
            throw new RuntimeException("Delete this event result didn't occur", e);
        }
    }


    public void updateEventResultByDisciplineID(int id, EventResult eventResult) {

        Connection connection = CONNECT.getConnect();

        final String UPDATE_EVENT_RESULT = "UPDATE eventResults SET disciplineID = '%d', WHERE disciplineID = %d".formatted(eventResult.getDisciplineID(), id);
        final String LAST_CHANGE = "UPDATE eventResults SET eventResultLastChange = '%s', WHERE disciplineID = %d".formatted(today.format(formatter), id);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(UPDATE_EVENT_RESULT);
            statement.executeUpdate(LAST_CHANGE);

        } catch (SQLException e) {
            throw new RuntimeException("Update the event result failed", e);
        }
    }


    public EventResultDTO getEventResultByAthleteID(int id) {

        Connection connection = CONNECT.getConnect();

        EventResultDTO eventResult = null;

        final String SELECT_EVENT_RESULT = ("SELECT * FROM eventResults er LEFT JOIN events e у ON er.EVENT_ID = e.EVENT_ID" +
                "LEFT JOIN disciplines d ON er.DISCIPLINE_ID = d.DISCIPLINE_ID" +
                "er LEFT JOIN athletes a ON p.ATHLETE_ID = a.ATHLETE_ID" +
                "WHERE athleteID = %d").formatted(id);

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_EVENT_RESULT);

            while (resultSet.next()){
                if (resultSet.getInt("athleteID") == id) {
                    eventResult = new EventResultDTO(resultSet.getInt("EVENT_RESULT_ID"),
                            resultSet.getString("discipline"),
                            resultSet.getString("athleteName"),
                            resultSet.getString("athleteCountry"),
                            resultSet.getString("result"),
                            resultSet.getString("eventResultCreatedAt"),
                            resultSet.getString("eventResultLastChange"));
                    break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select this event result of them", e);
        }

        return eventResult;
    }
}
