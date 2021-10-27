package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.model.Practice;


@Mapper
public interface PracticeMapper {

    //select１件
    public Practice findOne(String id);

    //select全件
    public List<Practice> find();
    

    //insert
    public void insertOne(Practice u);

    //update
    public void updateOne(@Param("id") String id, @Param("issue") String issue, @Param("level") String level, 
    		@Param("priority") String priority);

    //delete
    public void deleteOne(Practice u);

}