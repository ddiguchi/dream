package com.example.demo.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Practice {
    
    @NotEmpty(message = "IDを入力してください")
    private String id;

    @NotEmpty(message = "課題を入力してください")
    private String issue;


    @NotEmpty(message = "難易度を入力してください")
    @Size(min=1, max=3, message="難易度、優先度は1~3文字の☆記号で入力してください")
    @Pattern(regexp="[☆]*", message="難易度、優先度は1~3文字の☆記号で入力してください")
    private String level;


    @NotEmpty(message = "優先度を入力してください")
    @Size(min=1, max=3, message="難易度、優先度は1~3文字の☆記号で入力してください")
    @Pattern(regexp="[☆]*", message="難易度、優先度は1~3文字の☆記号で入力してください")
    private String priority;
}
