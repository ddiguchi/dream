package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Practice;
import com.example.demo.repository.PracticeMapper;

@Service
public class PracticeService {

    @Autowired
    PracticeMapper mapper;
    @Transactional
    //select１件
    public Practice getUserOne(String id) {
        return mapper.findOne(id);
    }
    //select全件
    public List<Practice> getList() {
        return mapper.find();
    }

    //insert
    
    public void insertOne(Practice u) {
        mapper.insertOne(u);
    }

    //update
    public void updateOne(String id, String issue, String level, String priority) {
        mapper.updateOne(id, issue, level, priority);
    }

    //delete
    public void deleteOne(Practice u) {
        mapper.deleteOne(u);
    }
    


}