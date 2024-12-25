package com.example.demo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class LessonDTO {
    private Integer id;

    @NotNull(message = "Назва уроку не може бути порожньою")
    @Size(min = 2, max = 100, message = "Довжина назви повинна бути від 2 до 100 символів")
    private String name;

    @NotNull(message = "Ім'я викладача не може бути порожнім")
    @Size(min = 2, max = 100, message = "Довжина імені викладача повинна бути від 2 до 100 символів")
    private String teacher;

    @NotNull(message = "День не може бути порожнім")
    @Pattern(regexp = "Monday|Tuesday|Wednesday|Thursday|Friday", message = "День повинен бути одним із: Monday, Tuesday, Wednesday, Thursday, Friday")
    private String day;

    @NotNull(message = "Час не може бути порожнім")
    @Pattern(regexp = "^([01]?\\d|2[0-3]):[0-5]\\d$", message = "Час повинен бути у форматі HH:mm")
    private String time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
