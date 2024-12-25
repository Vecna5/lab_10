package com.example.demo;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Validated
@RequestMapping("/api/lessons")
public class LessonController {
    private final LessonService service;

    public LessonController(LessonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Lesson> getAllLessons() {
        return service.getAllLessons();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Integer id) {
        Lesson lesson = service.getLessonById(id);
        return lesson != null ? ResponseEntity.ok(lesson) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<LessonDTO> addLesson(@RequestBody @Valid LessonDTO lessonDTO) {
        Lesson lesson = service.addLesson(convertToEntity(lessonDTO));
        return ResponseEntity.ok(convertToDTO(lesson));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<LessonDTO> updateLesson(@PathVariable Integer id, @RequestBody @Valid LessonDTO lessonDTO) {
        Lesson lesson = service.updateLesson(id, convertToEntity(lessonDTO));
        return lesson != null ? ResponseEntity.ok(convertToDTO(lesson)) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Integer id) {
        service.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
    private Lesson convertToEntity(LessonDTO dto) {
        Lesson lesson = new Lesson();
        lesson.setId(dto.getId());
        lesson.setName(dto.getName());
        lesson.setTeacher(dto.getTeacher());
        lesson.setDay(dto.getDay());
        lesson.setTime(dto.getTime());
        return lesson;
    }
    
    private LessonDTO convertToDTO(Lesson lesson) {
        LessonDTO dto = new LessonDTO();
        dto.setId(lesson.getId());
        dto.setName(lesson.getName());
        dto.setTeacher(lesson.getTeacher());
        dto.setDay(lesson.getDay());
        dto.setTime(lesson.getTime());
        return dto;
    }
}

