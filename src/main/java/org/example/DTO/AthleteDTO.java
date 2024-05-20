package org.example.DTO;

public class AthleteDTO {

    private final int ATHLETE_ID;
    private String athleteName;
    private String birthday;
    private String athleteCountry;
    private String athleteCreatedAt;
    private String athleteLastChange;


    public AthleteDTO(int ATHLETE_ID, String athleteName, String birthday, String athleteCountry, String athleteCreatedAt, String athleteLastChange) {
        this.ATHLETE_ID = ATHLETE_ID;
        this.athleteName = athleteName;
        this.birthday = birthday;
        this.athleteCountry = athleteCountry;
        this.athleteCreatedAt = athleteCreatedAt;
        this.athleteLastChange = athleteLastChange;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAthleteCountry() {
        return athleteCountry;
    }

    public void setAthleteCountry(String athleteCountry) {
        this.athleteCountry = athleteCountry;
    }

    public String getAthleteCreatedAt() {
        return athleteCreatedAt;
    }

    public void setAthleteCreatedAt(String athleteCreatedAt) {
        this.athleteCreatedAt = athleteCreatedAt;
    }

    public String getAthleteLastChange() {
        return athleteLastChange;
    }

    public void setAthleteLastChange(String athleteLastChange) {
        this.athleteLastChange = athleteLastChange;
    }
}
