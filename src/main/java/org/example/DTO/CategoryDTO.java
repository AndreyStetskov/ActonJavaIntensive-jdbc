package org.example.DTO;

public class CategoryDTO {

    private final int CATEGORY_ID;
    private String categoryName;
    private String categoryCreatedAt;
    private String categoryLastChange;


    public CategoryDTO(int CATEGORY_ID, String categoryName, String categoryCreatedAt, String categoryLastChange) {
        this.CATEGORY_ID = CATEGORY_ID;
        this.categoryName = categoryName;
        this.categoryCreatedAt = categoryCreatedAt;
        this.categoryLastChange = categoryLastChange;
    }


    public int getCATEGORY_ID() {
        return CATEGORY_ID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryCreatedAt() {
        return categoryCreatedAt;
    }

    public void setCategoryCreatedAt(String categoryCreatedAt) {
        this.categoryCreatedAt = categoryCreatedAt;
    }

    public String getCategoryLastChange() {
        return categoryLastChange;
    }

    public void setCategoryLastChange(String categoryLastChange) {
        this.categoryLastChange = categoryLastChange;
    }
}
