package org.example.DAO;

import org.example.connection.toDB.ConnectionToAthletes;
import org.example.entity.Athlete;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class AthleteDAO {

    private final ConnectionToAthletes CONNECT;
    LocalDateTime today = LocalDateTime.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
    private static final String SELECT_ALL = "SELECT * FROM athletes";
    private static final String NUMBER_OF_ATHLETES_FROM_COUNTRY = "SELECT country, count(*) FROM cars GROUP BY country";


    public AthleteDAO(ConnectionToAthletes CONNECT) {
        this.CONNECT = CONNECT;
    }


    public List<Athlete> getAllAthletes() {

        Connection connection = CONNECT.getConnect();

        List<Athlete> athletes = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()){
                Athlete athlete = new Athlete(resultSet.getInt("ATHLETE_ID"),
                        resultSet.getString("athleteName"),
                        resultSet.getString("athleteBirthday"),
                        resultSet.getString("athleteCountry"),
                        resultSet.getString("athleteCreatedAt"),
                        resultSet.getString("athleteLastChange"));

                athletes.add(athlete);
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select all athletes of them", e);
        }

        return athletes;
    }

    public List<String> getNumberAthletesFromCountry() {

        Connection connection = CONNECT.getConnect();

        List<String> numberAthletesFromCountry = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(NUMBER_OF_ATHLETES_FROM_COUNTRY);

            while (resultSet.next()){
                String country = resultSet.getString(4);
                int count = resultSet.getInt(2);

                String text = String.valueOf(count) + " " + country;

                numberAthletesFromCountry.add(text);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Some error for the count of athlete from countries", e);
        }

        return numberAthletesFromCountry;
    }

    public void insertAthlete(Athlete athlete) {

        Connection connection = CONNECT.getConnect();

        final String INSERT_ATHLETE = "INSERT INTO athletes VALUES (%d, '%s', '%s', '%s', '%s')".formatted(athlete.getATHLETE_ID(),
                athlete.getAthleteName(),
                athlete.getBirthday(),
                athlete.getAthleteCountry(),
                today.format(formatter));

        try(Statement statement = connection.createStatement()) {

            statement.execute(INSERT_ATHLETE);

        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to insert this athlete of them to data base", e);
        }
    }

    public void deleteAthleteByID(int id) {

        Connection connection = CONNECT.getConnect();

        final String DELETE_ATHLETE = "DELETE FROM athletes WHERE ATHLETE_ID = %d".formatted(id);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(DELETE_ATHLETE);

        } catch (SQLException e) {
            throw new RuntimeException("Delete this athlete didn't occur", e);
        }
    }


    public void updateNameAndCountryAthleteByID(int id, Athlete athlete) {

        Connection connection = CONNECT.getConnect();

        final String UPDATE_ATHLETE = "UPDATE athletes SET athleteName = '%s', athleteCountry = '%s' WHERE ATHLETE_ID = %d".formatted(athlete.getAthleteName(), athlete.getAthleteCountry(), id);
        final String LAST_CHANGE = "UPDATE athletes SET athleteLastChange = '%s', WHERE ATHLETE_ID = %d".formatted(today.format(formatter), id);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(UPDATE_ATHLETE);
            statement.executeUpdate(LAST_CHANGE);

        } catch (SQLException e) {
            throw new RuntimeException("Update the athlete failed", e);
        }
    }


    public Athlete getAthleteByID(int id) {

        Connection connection = CONNECT.getConnect();

        Athlete athlete = null;

        final String SELECT_ATHLETE = "SELECT * FROM athletes WHERE ATHLETE_ID = %d".formatted(id);

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ATHLETE);

            while (resultSet.next()){
                if (resultSet.getInt("ATHLETE_ID") == id) {
                    athlete = new Athlete(resultSet.getInt("ATHLETE_ID"),
                            resultSet.getString("athleteName"),
                            resultSet.getString("athleteBirthday"),
                            resultSet.getString("athleteCountry"),
                            resultSet.getString("athleteCreatedAt"),
                            resultSet.getString("athleteLastChange"));
                    break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select this athlete of them", e);
        }

        return athlete;
    }
}
