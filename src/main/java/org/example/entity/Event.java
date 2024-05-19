package org.example.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Event {

    private final int EVENT_ID;
    private String eventName;
    private LocalDate eventDate;
    private LocalDateTime eventCreatedAt;
    private LocalDateTime eventLastChange;

    public Event(int EVENT_ID, String eventName, LocalDate eventDate, LocalDateTime eventCreatedAt) {
        this.EVENT_ID = EVENT_ID;
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventCreatedAt = eventCreatedAt;
    }

    public Event(int EVENT_ID, String eventName, String eventDate, String eventCreatedAt, String EventLastChange) {
        this.EVENT_ID = EVENT_ID;
        this.eventName = eventName;
        this.eventDate = LocalDate.parse(eventDate);
        this.eventCreatedAt = LocalDateTime.parse(eventCreatedAt);
        this.eventLastChange = LocalDateTime.parse(EventLastChange);
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

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalDateTime getEventCreatedAt() {
        return eventCreatedAt;
    }

    public void setEventCreatedAt(LocalDateTime eventCreatedAt) {
        this.eventCreatedAt = eventCreatedAt;
    }

    public LocalDateTime getEventLastChange() {
        return eventLastChange;
    }

    public void setEventLastChange(LocalDateTime eventLastChange) {
        this.eventLastChange = eventLastChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return EVENT_ID == event.EVENT_ID && Objects.equals(eventName, event.eventName) && Objects.equals(eventDate, event.eventDate) && Objects.equals(eventCreatedAt, event.eventCreatedAt) && Objects.equals(eventLastChange, event.eventLastChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(EVENT_ID, eventName, eventDate, eventCreatedAt, eventLastChange);
    }

    @Override
    public String toString() {
        return "Event{" +
                "EVENT_ID=" + EVENT_ID +
                ", event_name='" + eventName + '\'' +
                ", event_date=" + eventDate +
                ", athletes_created_at=" + eventCreatedAt +
                ", athletes_last_change=" + eventLastChange +
                '}';
    }
}
