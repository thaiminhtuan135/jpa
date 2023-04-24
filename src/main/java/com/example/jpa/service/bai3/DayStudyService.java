package com.example.jpa.service.bai3;

import com.example.jpa.model.bai3.DayStudy;

public interface DayStudyService {
    DayStudy save(DayStudy dayStudy);

    void deleteCourse(int id);
}
