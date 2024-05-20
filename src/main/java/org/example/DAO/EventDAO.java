package org.example.DAO;

import org.example.DTO.EventDTO;
import org.example.connection.toDB.ConnectionToAthletes;
import org.example.entity.Event;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    private final ConnectionToAthletes CONNECT;
    LocalDateTime today = LocalDateTime.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
    private static final String SELECT_ALL = "SELECT * FROM events";


    public EventDAO(ConnectionToAthletes CONNECT) {
        this.CONNECT = CONNECT;
    }


    public List<EventDTO> getAllEvent() {

        Connection connection = CONNECT.getConnect();

        List<EventDTO> events = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()){
                EventDTO event = new EventDTO(resultSet.getInt("EVENT_ID"),
                        resultSet.getString("eventName"),
                        resultSet.getString("eventDate"),
                        resultSet.getString("eventCreatedAt"),
                        resultSet.getString("eventLastChange"));

                events.add(event);
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select all events of them", e);
        }

        return events;
    }

    public void insertEvent(Event event) {

        Connection connection = CONNECT.getConnect();

        final String INSERT_EVENT = "INSERT INTO events VALUES (%d, '%s', '%s', '%s')".formatted(event.getEVENT_ID(),
                event.getEventName(),
                event.getEventDate(),
                today.format(formatter));

        try(Statement statement = connection.createStatement()) {

            statement.execute(INSERT_EVENT);

        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to insert this event of them to data base", e);
        }
    }

    public void deleteAthleteByName(String name) {

        Connection connection = CONNECT.getConnect();

        final String DELETE_EVENT = "DELETE FROM events WHERE eventName = %s".formatted(name);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(DELETE_EVENT);

        } catch (SQLException e) {
            throw new RuntimeException("Delete this event didn't occur", e);
        }
    }


    public void updateEventByName(String name, Event event) {

        Connection connection = CONNECT.getConnect();

        final String UPDATE_EVENT = "UPDATE events SET eventName = '%s', WHERE eventName = %s".formatted(event.getEventName(), name);
        final String LAST_CHANGE = "UPDATE events SET eventLastChange = '%s', WHERE eventName = %s".formatted(today.format(formatter), name);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(UPDATE_EVENT);
            statement.executeUpdate(LAST_CHANGE);

        } catch (SQLException e) {
            throw new RuntimeException("Update the event failed", e);
        }
    }


    public EventDTO getEventByName(String name) {

        Connection connection = CONNECT.getConnect();

        EventDTO event = null;

        final String SELECT_EVENT = "SELECT * FROM events WHERE eventName = %s".formatted(name);

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_EVENT);

            while (resultSet.next()){
                if (resultSet.getString("eventName").equals(name)) {
                    event = new EventDTO(resultSet.getInt("EVENT_ID"),
                            resultSet.getString("eventName"),
                            resultSet.getString("eventDate"),
                            resultSet.getString("eventCreatedAt"),
                            resultSet.getString("eventLastChange"));
                    break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select this event of them", e);
        }

        return event;
    }
}
