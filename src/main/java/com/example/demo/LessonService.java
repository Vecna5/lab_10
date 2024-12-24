package com.example.demo;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LessonService {
    private final LessonRepository repository;

    public LessonService(LessonRepository repository) {
        this.repository = repository;
    }

    public List<Lesson> getAllLessons() {
        return repository.findAll();
    }

    public Lesson getLessonById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public Lesson addLesson(Lesson lesson) {
        return repository.save(lesson);
    }

    public Lesson updateLesson(Integer id, Lesson updatedLesson) {
        return repository.findById(id).map(lesson -> {
            lesson.setName(updatedLesson.getName());
            lesson.setTeacher(updatedLesson.getTeacher());
            lesson.setDay(updatedLesson.getDay());
            lesson.setTime(updatedLesson.getTime());
            return repository.save(lesson);
        }).orElse(null);
    }

    public void deleteLesson(Integer id) {
        repository.deleteById(id);
    }

    public List<Lesson> getScheduleForDay(String day) {
        return repository.findByDay(day);
    }

    public List<List<Lesson>> getScheduleForWeek() {
        return List.of(
            getScheduleForDay("Monday"),
            getScheduleForDay("Tuesday"),
            getScheduleForDay("Wednesday"),
            getScheduleForDay("Thursday"),
            getScheduleForDay("Friday")
        );
    }
}
