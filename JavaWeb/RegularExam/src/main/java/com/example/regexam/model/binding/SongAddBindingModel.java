package com.example.regexam.model.binding;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class SongAddBindingModel {

    @NotBlank
    @Size(min=3,max=20,message = "Performer name length must be between 3 and 20 characters(inclusive 3 and 20).")
    private String performer;

    @NotBlank
    @Size(min=2,max=20,message = "Title length must be between 2 and 20 characters(inclusive 2 and 20). ")
    private String title;

    @PastOrPresent(message = "The date cannot be in the future!")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;

    @Positive(message = "Duration must be positive")
    private int duration;

    @NotBlank(message = "you must select a style!")
    private String style;

    public SongAddBindingModel() {
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
