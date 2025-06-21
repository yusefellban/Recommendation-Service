package com.MAHD.Recommendation.Service.model.userTop5models;

import java.util.List;

public class Data {
    private List<courses> courses;
    private long totalCourses;
    private int offset;
    private int limit;

    public List<com.MAHD.Recommendation.Service.model.userTop5models.courses> getCourses() {
        return courses;
    }

    public void setCourses(List<com.MAHD.Recommendation.Service.model.userTop5models.courses> courses) {
        this.courses = courses;
    }

    public long getTotalCourses() {
        return totalCourses;
    }

    public void setTotalCourses(long totalCourses) {
        this.totalCourses = totalCourses;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
