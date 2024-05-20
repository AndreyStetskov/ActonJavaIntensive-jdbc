package org.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Athlete {

    private final int ATHLETE_ID;
    private String athleteName;
    private LocalDate birthday;
    private String athleteCountry;
    private LocalDateTime athleteCreatedAt;
    private LocalDateTime athleteLastChange;

    public Athlete(int ATHLETE_ID, String athleteName, LocalDate birthday, String athleteCountry, LocalDateTime athleteCreatedAt) {
        this.ATHLETE_ID = ATHLETE_ID;
        this.athleteName = athleteName;
        this.birthday = birthday;
        this.athleteCountry = athleteCountry;
        this.athleteCreatedAt = athleteCreatedAt;
    }


    public int getATHLETE_ID() {
        return ATHLETE_ID;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAthleteCountry() {
        return athleteCountry;
    }

    public void setAthleteCountry(String athleteCountry) {
        this.athleteCountry = athleteCountry;
    }

    public LocalDateTime getAthleteCreatedAt() {
        return athleteCreatedAt;
    }

    public void setAthleteCreatedAt(LocalDateTime athleteCreatedAt) {
        this.athleteCreatedAt = athleteCreatedAt;
    }

    public LocalDateTime getAthleteLastChange() {
        return athleteLastChange;
    }

    public void setAthleteLastChange(LocalDateTime athleteLastChange) {
        this.athleteLastChange = athleteLastChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Athlete athlete = (Athlete) o;
        return ATHLETE_ID == athlete.ATHLETE_ID && Objects.equals(athleteName, athlete.athleteName) && Objects.equals(birthday, athlete.birthday) && Objects.equals(athleteCountry, athlete.athleteCountry) && Objects.equals(athleteCreatedAt, athlete.athleteCreatedAt) && Objects.equals(athleteLastChange, athlete.athleteLastChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ATHLETE_ID, athleteName, birthday, athleteCountry, athleteCreatedAt, athleteLastChange);
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "ATHLETE_ID=" + ATHLETE_ID +
                ", athlete_name='" + athleteName + '\'' +
                ", athlete_birthday=" + birthday +
                ", athlete_country='" + athleteCountry + '\'' +
                ", athlete_created_at=" + athleteCreatedAt +
                ", athlete_last_change=" + athleteLastChange +
                '}';
    }
}
