package org.eternity.exam;

import java.time.LocalDate;

public class Lecture {
    private String title;
    private LocalDate date;
    private int days;

    public Lecture(String title, LocalDate date, int days) {
        this.title = title;
        this.date = date;
        this.days = days;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getDays() {
        return days;
    }
}