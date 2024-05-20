package org.example.DAO;

import org.example.DTO.ProfileDTO;
import org.example.connection.toDB.ConnectionToAthletes;
import org.example.entity.Profile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO {

    private final ConnectionToAthletes CONNECT;
    LocalDateTime today = LocalDateTime.now();
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss:SSS");
    private static final String SELECT_ALL = "SELECT * FROM profiles p LEFT JOIN athletes a ON p.ATHLETE_ID = a.ATHLETE_ID" +
            "LEFT JOIN disciplines d ON p.DISCIPLINE_ID = d.DISCIPLINE_ID" +
            "LEFT JOIN categories c ON p.CATEGORY_ID = c.CATEGORY_ID";


    public ProfileDAO(ConnectionToAthletes CONNECT) {
        this.CONNECT = CONNECT;
    }


    public List<ProfileDTO> getAllProfiles() {

        Connection connection = CONNECT.getConnect();

        List<ProfileDTO> profiles = new ArrayList<>();

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_ALL);

            while (resultSet.next()){
                ProfileDTO profileDTO = new ProfileDTO(resultSet.getInt("PROFILE_ID"),
                        resultSet.getString("name"),
                        resultSet.getString("birthday"),
                        resultSet.getString("country"),
                        resultSet.getString("discipline"),
                        resultSet.getString("category"),
                        resultSet.getString("bio"),
                        resultSet.getString("profileCreatedAt"),
                        resultSet.getString("profileLastChange"));

                profiles.add(profileDTO);
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select all profiles of them", e);
        }

        return profiles;
    }

    public void insertProfile(Profile profile) {

        Connection connection = CONNECT.getConnect();

        final String INSERT_PROFILE = "INSERT INTO profiles VALUES (%d, %d, '%d', '%d', '%s', '%s')".formatted(profile.getPROFILE_ID(),
                profile.getATHLETE_ID(),
                profile.getDisciplineID(),
                profile.getCategoryID(),
                profile.getBio(),
                today.format(formatter));

        try(Statement statement = connection.createStatement()) {

            statement.execute(INSERT_PROFILE);

        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to insert this profile of them to data base", e);
        }
    }

    public void deleteProfileByAthleteID(int id) {

        Connection connection = CONNECT.getConnect();

        final String DELETE_PROFILE = "DELETE FROM profiles WHERE ATHLETE_ID = %d".formatted(id);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(DELETE_PROFILE);

        } catch (SQLException e) {
            throw new RuntimeException("Delete this profile didn't occur", e);
        }
    }


    public void updateProfileByProfileID(int id, Profile profile) {

        Connection connection = CONNECT.getConnect();

        final String UPDATE_PROFILE = "UPDATE profiles SET disciplineID = '%d', categoryID = '%d', bio = '%s', WHERE PROFILE_ID = %d".formatted(profile.getDisciplineID(), profile.getCategoryID(), profile.getBio(), id);
        final String LAST_CHANGE = "UPDATE profiles SET eventResultLastChange = '%s', WHERE PROFILE_ID = %d".formatted(today.format(formatter), id);

        try(Statement statement = connection.createStatement()) {

            statement.executeUpdate(UPDATE_PROFILE);
            statement.executeUpdate(LAST_CHANGE);

        } catch (SQLException e) {
            throw new RuntimeException("Update the profile failed", e);
        }
    }


    public ProfileDTO getProfileByAthleteID(int id) {

        Connection connection = CONNECT.getConnect();

        ProfileDTO profileDTO = null;

        final String SELECT_EVENT_RESULT = ("SELECT * FROM profiles p LEFT JOIN athletes a ON p.ATHLETE_ID = a.ATHLETE_ID" +
                "LEFT JOIN disciplines d ON p.DISCIPLINE_ID = d.DISCIPLINE_ID" +
                "LEFT JOIN categories c ON p.CATEGORY_ID = c.CATEGORY_ID" +
                "WHERE ATHLETE_ID = %d").formatted(id);

        try(Statement statement = connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery(SELECT_EVENT_RESULT);

            while (resultSet.next()){
                if (resultSet.getInt("ATHLETE_ID") == id) {
                    profileDTO = new ProfileDTO(resultSet.getInt("PROFILE_ID"),
                            resultSet.getString("name"),
                            resultSet.getString("birthday"),
                            resultSet.getString("country"),
                            resultSet.getString("discipline"),
                            resultSet.getString("category"),
                            resultSet.getString("bio"),
                            resultSet.getString("profileCreatedAt"),
                            resultSet.getString("profileLastChange"));
                    break;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("It's not possible to select this profile of them", e);
        }

        return profileDTO;
    }
}
