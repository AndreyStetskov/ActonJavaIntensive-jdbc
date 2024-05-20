package org.example.DTO;

public class DisciplineDTO {

    private final int DISCIPLINE_ID;
    private String disciplineName;
    private String disciplineCreatedAt;
    private String disciplineLastChange;


    public DisciplineDTO(int DISCIPLINE_ID, String disciplineName, String disciplineCreatedAt, String disciplineLastChange) {
        this.DISCIPLINE_ID = DISCIPLINE_ID;
        this.disciplineName = disciplineName;
        this.disciplineCreatedAt = disciplineCreatedAt;
        this.disciplineLastChange = disciplineLastChange;
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

    public String getDisciplineCreatedAt() {
        return disciplineCreatedAt;
    }

    public void setDisciplineCreatedAt(String disciplineCreatedAt) {
        this.disciplineCreatedAt = disciplineCreatedAt;
    }

    public String getDisciplineLastChange() {
        return disciplineLastChange;
    }

    public void setDisciplineLastChange(String disciplineLastChange) {
        this.disciplineLastChange = disciplineLastChange;
    }
}
