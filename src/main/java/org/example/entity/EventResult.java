package org.example.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class EventResult {

    private final int EVENT_RESULT_ID;
    private int disciplineID;
    private int athleteID;
    private String result;
    private LocalDateTime eventResultCreatedAt;
    private LocalDateTime eventResultLastChange;


    public EventResult(int EVENT_RESULT_ID, int disciplineID, int athleteID, String result, LocalDateTime eventResultCreatedAt) {
        this.EVENT_RESULT_ID = EVENT_RESULT_ID;
        this.disciplineID = disciplineID;
        this.athleteID = athleteID;
        this.result = result;
        this.eventResultCreatedAt = eventResultCreatedAt;
    }

    public EventResult(int EVENT_RESULT_ID, int disciplineID, int athleteID, String result, String eventResultCreatedAt, String eventResultLastChange) {
        this.EVENT_RESULT_ID = EVENT_RESULT_ID;
        this.disciplineID = disciplineID;
        this.athleteID = athleteID;
        this.result = result;
        this.eventResultCreatedAt = LocalDateTime.parse(eventResultCreatedAt);
        this.eventResultLastChange = LocalDateTime.parse(eventResultLastChange);
    }

    public int getEVENT_RESULT_ID() {
        return EVENT_RESULT_ID;
    }

    public int getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(int disciplineID) {
        this.disciplineID = disciplineID;
    }

    public int getAthleteID() {
        return athleteID;
    }

    public void setAthleteID(int athleteID) {
        this.athleteID = athleteID;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public LocalDateTime getEventResultCreatedAt() {
        return eventResultCreatedAt;
    }

    public void setEventResultCreatedAt(LocalDateTime eventResultCreatedAt) {
        this.eventResultCreatedAt = eventResultCreatedAt;
    }

    public LocalDateTime getEventResultLastChange() {
        return eventResultLastChange;
    }

    public void setEventResultLastChange(LocalDateTime eventResultLastChange) {
        this.eventResultLastChange = eventResultLastChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventResult that = (EventResult) o;
        return EVENT_RESULT_ID == that.EVENT_RESULT_ID && disciplineID == that.disciplineID && athleteID == that.athleteID && Objects.equals(result, that.result) && Objects.equals(eventResultCreatedAt, that.eventResultCreatedAt) && Objects.equals(eventResultLastChange, that.eventResultLastChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EVENT_RESULT_ID, disciplineID, athleteID, result, eventResultCreatedAt, eventResultLastChange);
    }

    @Override
    public String toString() {
        return "EventResult{" +
                "EVENT_RESULT_ID=" + EVENT_RESULT_ID +
                ", disciplineID=" + disciplineID +
                ", athleteID=" + athleteID +
                ", result='" + result + '\'' +
                ", eventResultCreatedAt=" + eventResultCreatedAt +
                ", eventResultLastChange=" + eventResultLastChange +
                '}';
    }
}
