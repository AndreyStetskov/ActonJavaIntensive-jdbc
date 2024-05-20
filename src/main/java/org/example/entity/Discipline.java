package org.example.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Discipline {

    private final int DISCIPLINE_ID;
    private String disciplineName;
    private LocalDateTime disciplineCreatedAt;
    private LocalDateTime disciplineLastChange;


    public Discipline(int DISCIPLINE_ID, String disciplineName, LocalDateTime disciplineCreatedAt) {
        this.DISCIPLINE_ID = DISCIPLINE_ID;
        this.disciplineName = disciplineName;
        this.disciplineCreatedAt = disciplineCreatedAt;
    }


    public int getDISCIPLINE_ID() {
        return DISCIPLINE_ID;
    }

    public String getDisciplineName() {
        return disciplineName;
    }

    public void setDisciplineName(String disciplineName) {
        this.disciplineName = disciplineName;
    }

    public LocalDateTime getDisciplineCreatedAt() {
        return disciplineCreatedAt;
    }

    public void setDisciplineCreatedAt(LocalDateTime disciplineCreatedAt) {
        this.disciplineCreatedAt = disciplineCreatedAt;
    }

    public LocalDateTime getDisciplineLastChange() {
        return disciplineLastChange;
    }

    public void setDisciplineLastChange(LocalDateTime disciplineLastChange) {
        this.disciplineLastChange = disciplineLastChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Discipline that = (Discipline) o;
        return DISCIPLINE_ID == that.DISCIPLINE_ID && Objects.equals(disciplineName, that.disciplineName) && Objects.equals(disciplineCreatedAt, that.disciplineCreatedAt) && Objects.equals(disciplineLastChange, that.disciplineLastChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(DISCIPLINE_ID, disciplineName, disciplineCreatedAt, disciplineLastChange);
    }

    @Override
    public String toString() {
        return "Discipline{" +
                "DISCIPLINE_ID=" + DISCIPLINE_ID +
                ", disciplineName='" + disciplineName + '\'' +
                ", disciplineCreatedAt=" + disciplineCreatedAt +
                ", disciplineLastChange=" + disciplineLastChange +
                '}';
    }
}
