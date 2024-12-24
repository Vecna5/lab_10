package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {
    private final LessonService service;

    public ScheduleController(LessonService service) {
        this.service = service;
    }

    @GetMapping("/day")
    public List<Lesson> getScheduleForDay(@RequestParam String day) {
        return service.getScheduleForDay(day);
    }

    @GetMapping("/week")
    public List<List<Lesson>> getScheduleForWeek() {
        return service.getScheduleForWeek();
    }
}
