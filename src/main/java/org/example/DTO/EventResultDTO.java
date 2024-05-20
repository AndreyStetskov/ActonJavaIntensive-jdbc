package org.example.DTO;

public class EventResultDTO {

    private final int EVENT_RESULT_ID;
    private String discipline;
    private String athleteName;
    private String athleteCountry;
    private String result;
    private String eventResultCreatedAt;
    private String eventResultLastChange;


    public int getEVENT_RESULT_ID() {
        return EVENT_RESULT_ID;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public void setAthleteName(String athleteName) {
        this.athleteName = athleteName;
    }

    public String getAthleteCountry() {
        return athleteCountry;
    }

    public void setAthleteCountry(String athleteCountry) {
        this.athleteCountry = athleteCountry;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getEventResultCreatedAt() {
        return eventResultCreatedAt;
    }

    public void setEventResultCreatedAt(String eventResultCreatedAt) {
        this.eventResultCreatedAt = eventResultCreatedAt;
    }

    public String getEventResultLastChange() {
        return eventResultLastChange;
    }

    public void setEventResultLastChange(String eventResultLastChange) {
        this.eventResultLastChange = eventResultLastChange;
    }

    public EventResultDTO(int EVENT_RESULT_ID, String discipline, String athleteName, String athleteCountry, String result, String eventResultCreatedAt, String eventResultLastChange) {
        this.EVENT_RESULT_ID = EVENT_RESULT_ID;
        this.discipline = discipline;
        this.athleteName = athleteName;
        this.athleteCountry = athleteCountry;
        this.result = result;
        this.eventResultCreatedAt = eventResultCreatedAt;
        this.eventResultLastChange = eventResultLastChange;
    }
}
