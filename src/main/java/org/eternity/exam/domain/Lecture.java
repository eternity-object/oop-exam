package org.eternity.exam.domain;

import java.time.LocalDate;

public class Lecture {
    private final String title;
    private final LocalDate date;
    private final int days;

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