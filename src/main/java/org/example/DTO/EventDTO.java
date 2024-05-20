package org.example.DTO;

public class EventDTO {

    private final int EVENT_ID;
    private String eventName;
    private String eventDate;
    private String eventCreatedAt;
    private String eventLastChange;


    public EventDTO(int EVENT_ID, String eventName, String eventDate, String eventCreatedAt, String eventLastChange) {
        this.EVENT_ID = EVENT_ID;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventCreatedAt = eventCreatedAt;
        this.eventLastChange = eventLastChange;
    }


    public int getEVENT_ID() {
        return EVENT_ID;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventCreatedAt() {
        return eventCreatedAt;
    }

    public void setEventCreatedAt(String eventCreatedAt) {
        this.eventCreatedAt = eventCreatedAt;
    }

    public String getEventLastChange() {
        return eventLastChange;
    }

    public void setEventLastChange(String eventLastChange) {
        this.eventLastChange = eventLastChange;
    }
}
