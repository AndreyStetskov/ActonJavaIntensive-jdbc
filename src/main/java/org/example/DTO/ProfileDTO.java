package org.example.DTO;

public class ProfileDTO {
    private final int PROFILE_ID;
    private String name;
    private String birthday;
    private String country;
    private String discipline;
    private String category;
    private String bio;
    private String profileCreatedAt;
    private String profileLastChange;


    public ProfileDTO(int PROFILE_ID, String name, String birthday, String country, String discipline, String category, String bio, String profileCreatedAt, String profileLastChange) {
        this.PROFILE_ID = PROFILE_ID;
        this.name = name;
        this.birthday = birthday;
        this.country = country;
        this.discipline = discipline;
        this.category = category;
        this.bio = bio;
        this.profileCreatedAt = profileCreatedAt;
        this.profileLastChange = profileLastChange;
    }


    public int getPROFILE_ID() {
        return PROFILE_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDiscipline() {
        return discipline;
    }

    public void setDiscipline(String discipline) {
        this.discipline = discipline;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getProfileCreatedAt() {
        return profileCreatedAt;
    }

    public void setProfileCreatedAt(String profileCreatedAt) {
        this.profileCreatedAt = profileCreatedAt;
    }

    public String getProfileLastChange() {
        return profileLastChange;
    }

    public void setProfileLastChange(String profileLastChange) {
        this.profileLastChange = profileLastChange;
    }
}
