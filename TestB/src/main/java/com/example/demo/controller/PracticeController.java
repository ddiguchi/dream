package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.form.Form;
import com.example.demo.model.Practice;
import com.example.demo.service.PracticeService;


@Controller
@RequestMapping("/practice")
@Transactional
public class PracticeController {

    @Autowired
    private PracticeService service;

    //select全件表示
    @GetMapping("/list")
    public String getUserList(Model model) {
        List<Practice> userList =  service.getList();
        model.addAttribute("practice", userList);
        return "practice/list";
    }   


    //トップページ top.html表示
    @GetMapping("")
    public String top(Model model, @ModelAttribute Practice u) {
        model.addAttribute("practice", service.getList()) ;
        return "practice/top";
    }


    //top→[詳細]押下　select１件
    @GetMapping("details/id={id}")
    public String details(@PathVariable("id") String id, Model model) {
        model.addAttribute("practice", service.getUserOne(id));
        return "practice/details";
    }


    //top→[新規作成]押下 th:hrefにより生成されたURLをGETで表示
    @GetMapping("/register")
    public String registerUser(Model model, @ModelAttribute Practice u) {
        model.addAttribute("practice", u);
        return "practice/register";
    }
    //register.html内の <form method="post"> で↓へ飛ぶ
    @PostMapping("/register")
    public String create(Model model,@Validated @ModelAttribute Practice u, BindingResult result) {
        if (result.hasErrors()) {
        	System.out.println("エラー発生！BindingResult内容↓↓↓");
            System.out.println(result);
            System.out.println("エラー発生！BindingResult内容↑↑↑");
            model.addAttribute("Practice", u);
            return "practice/register";
        }
        service.insertOne(u);
        return "redirect:/practice";
    }


    //top→[変更]押下時にchange.htmlを表示するGET
    @GetMapping("change/id={id}")
    public String change(@PathVariable("id") String id, Model model) {
        model.addAttribute("practice", service.getUserOne(id));
        return "practice/change";
    }
    @PostMapping("change/id={id}")
    public String update(Model model,@Validated @ModelAttribute Practice u, BindingResult result) {
    	if (result.hasErrors()) {
        	System.out.println("エラー発生！BindingResult内容↓↓↓");
            System.out.println(result);
            System.out.println("エラー発生！BindingResult内容↑↑↑");
            model.addAttribute("Practice", u);
            return "practice/change";
    	}
        service.updateOne(u.getId(), u.getIssue(), u.getLevel(), u.getPriority());
        return "redirect:/practice";
    }

    //top→[削除]押下時
    @PostMapping("delete/id={id}")
    public String delete(@PathVariable String id, @ModelAttribute Practice u) {
        service.deleteOne(u);
        return "redirect:/practice";
    }
    //number型のテキストボックスからの数値を[記録する]を押下時に[○○Pt]と表示
    @RequestMapping("/practice")
    public String form(Model model){
      model.addAttribute("form", new Form());
      return "practice/top";
    }
    @RequestMapping(value="/practice", method = RequestMethod.POST)
    public String sumTotal(@ModelAttribute Form form, Model model){
  	       form.sumTotal();
  	      model.addAttribute("form", model);
  	       return "practice/top";
  	       }

}