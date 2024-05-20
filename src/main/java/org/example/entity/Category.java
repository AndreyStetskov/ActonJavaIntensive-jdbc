package org.example.entity;

import java.time.LocalDateTime;
import java.util.Objects;

public class Category {

    private final int CATEGORY_ID;
    private String categoryName;
    private LocalDateTime categoryCreatedAt;
    private LocalDateTime categoryLastChange;

    public Category(int CATEGORY_ID, String categoryName, LocalDateTime categoryCreatedAt) {
        this.CATEGORY_ID = CATEGORY_ID;
        this.categoryName = categoryName;
        this.categoryCreatedAt = categoryCreatedAt;
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

    public LocalDateTime getCategoryCreatedAt() {
        return categoryCreatedAt;
    }

    public void setCategoryCreatedAt(LocalDateTime categoryCreatedAt) {
        this.categoryCreatedAt = categoryCreatedAt;
    }

    public LocalDateTime getCategoryLastChange() {
        return categoryLastChange;
    }

    public void setCategoryLastChange(LocalDateTime categoryLastChange) {
        this.categoryLastChange = categoryLastChange;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return CATEGORY_ID == category.CATEGORY_ID && Objects.equals(categoryName, category.categoryName) && Objects.equals(categoryCreatedAt, category.categoryCreatedAt) && Objects.equals(categoryLastChange, category.categoryLastChange);
    }

    @Override
    public int hashCode() {
        return Objects.hash(CATEGORY_ID, categoryName, categoryCreatedAt, categoryLastChange);
    }

    @Override
    public String toString() {
        return "Category{" +
                "CATEGORY_ID=" + CATEGORY_ID +
                ", category_name='" + categoryName + '\'' +
                ", athletes_created_at=" + categoryCreatedAt +
                ", athletes_last_change=" + categoryLastChange +
                '}';
    }
}
