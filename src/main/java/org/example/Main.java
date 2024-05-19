package org.example;

import org.example.DAO.*;
import org.example.connection.toDB.ConnectionToAthletes;
import org.example.entity.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        ConnectionToAthletes connection = new ConnectionToAthletes();

        AthleteDAO athleteDAO = new AthleteDAO(connection);
        System.out.println(athleteDAO.getNumberAthletesFromCountry());
        Athlete athlete = new Athlete(5, "Bruce", LocalDate.of(2014, 2, 19), "Canada", LocalDateTime.from(LocalDate.now()));
        athleteDAO.insertAthlete(athlete);
        athleteDAO.deleteAthleteByID(5);
        athleteDAO.updateNameAndCountryAthleteByID(1, athlete);
        System.out.println(athleteDAO.getAthleteByID(1));
        System.out.println(athleteDAO.getAllAthletes());

        DisciplineDAO disciplineDAO = new DisciplineDAO(connection);
        Discipline discipline = new Discipline(2, "Boxing", LocalDateTime.from(LocalDate.now()));
        disciplineDAO.insertDiscipline(discipline);
        disciplineDAO.deleteDisciplineByName("Chess");
        disciplineDAO.updateDisciplineByName("Boxing", discipline);
        System.out.println(disciplineDAO.getDisciplineByName("Chess"));
        System.out.println(disciplineDAO.getAllDisciplines());

        CategoryDAO categoryDAO = new CategoryDAO(connection);
        System.out.println(categoryDAO.getCategoryByName("Grandmaster"));
        Category category = new Category(2, "international master of sports", LocalDateTime.from(LocalDate.now()));
        categoryDAO.insertCategory(category);
        categoryDAO.deleteCategoryByName("Grandmaster");
        categoryDAO.updateCategoryByName("international master of sports", category);
        System.out.println(categoryDAO.getAllCategories());

        ProfileDAO profileDAO = new ProfileDAO(connection);
        System.out.println(profileDAO.getProfileByAthleteID(1));
        Profile profile = new Profile(444, 1, 2, 2,"was born in Monaco", LocalDateTime.from(LocalDate.now()));
        profileDAO.insertProfile(profile);
        profileDAO.deleteProfileByAthleteID(4);
        profileDAO.updateProfileByProfileID(444, profile);
        System.out.println(profileDAO.getAllProfiles());

        EventDAO eventDAO = new EventDAO(connection);
        System.out.println(eventDAO.getEventByName("European Junior Chess Championship 2024"));
        Event event = new Event(3, "Game of tourist May 2024", LocalDate.of(2014, 5, 4), LocalDateTime.from(LocalDate.now()));
        eventDAO.insertEvent(event);
        eventDAO.deleteAthleteByName("European Junior Chess Championship 2024");
        eventDAO.updateEventByName("international master of sports", event);
        System.out.println(categoryDAO.getAllCategories());

        EventResultDAO eventResultDAO = new EventResultDAO(connection);
        System.out.println(eventResultDAO.getEventResultByAthleteID(2));
        EventResult eventResult = new EventResult(3, 2,1,"Winner", LocalDateTime.from(LocalDate.now()));
        eventResultDAO.insertEventResult(eventResult);
        eventResultDAO.deleteEventResultByAthleteID(2);
        eventResultDAO.updateEventResultByDisciplineID(2, eventResult);
        System.out.println(categoryDAO.getAllCategories());
    }
}