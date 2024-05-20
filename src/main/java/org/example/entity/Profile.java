package org.example.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Profile {

    private final int PROFILE_ID;
    private final int ATHLETE_ID;
    private int disciplineID;
    private int categoryID;
    private String bio;
    private LocalDateTime profileCreatedAt;
    private LocalDateTime profileLastChange;


    public Profile(int PROFILE_ID, int ATHLETE_ID, int disciplineID, int categoryID, String bio, LocalDateTime profileCreatedAt) {
        this.PROFILE_ID = PROFILE_ID;
        this.ATHLETE_ID = ATHLETE_ID;
        this.disciplineID = disciplineID;
        this.categoryID = categoryID;
        this.bio = bio;
        this.profileCreatedAt = profileCreatedAt;
    }


    public int getPROFILE_ID() {
        return PROFILE_ID;
    }

    public int getATHLETE_ID() {
        return ATHLETE_ID;
    }

    public int getDisciplineID() {
        return disciplineID;
    }

    public void setDisciplineID(int disciplineID) {
        this.disciplineID = disciplineID;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public LocalDateTime getProfileCreatedAt() {
        return profileCreatedAt;
    }

    public void setProfileCreatedAt(LocalDateTime profileCreatedAt) {
        this.profileCreatedAt = profileCreatedAt;
    }

    public LocalDateTime getProfileLastChange() {
        return profileLastChange;
    }

    public void setProfileLastChange(LocalDateTime profileLastChange) {
        this.profileLastChange = profileLastChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return PROFILE_ID == profile.PROFILE_ID && ATHLETE_ID == profile.ATHLETE_ID && disciplineID == profile.disciplineID && categoryID == profile.categoryID && Objects.equals(bio, profile.bio) && Objects.equals(profileCreatedAt, profile.profileCreatedAt) && Objects.equals(profileLastChange, profile.profileLastChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(PROFILE_ID, ATHLETE_ID, disciplineID, categoryID, bio, profileCreatedAt, profileLastChange);
    }

    @Override
    public String toString() {
        return "Profile{" +
                "PROILE_ID=" + PROFILE_ID +
                ", ATHLETE_ID=" + ATHLETE_ID +
                ", discipline_ID=" + disciplineID +
                ", category_ID=" + categoryID +
                ", bio='" + bio + '\'' +
                ", athletes_created_at=" + profileCreatedAt +
                ", athletes_last_change=" + profileLastChange +
                '}';
    }
}
