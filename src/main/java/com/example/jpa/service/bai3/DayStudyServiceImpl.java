package com.example.jpa.service.bai3;

import com.example.jpa.model.bai3.DayStudy;
import com.example.jpa.repository.bai3.DayStudyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DayStudyServiceImpl implements DayStudyService{

    @Autowired
    private DayStudyRepository dayStudyRepository;
    @Override
    public DayStudy save(DayStudy dayStudy) {
        return dayStudyRepository.save(dayStudy);
    }

    @Override
    public void deleteCourse(int id) {
        dayStudyRepository.deleteById(id);
    }

}
