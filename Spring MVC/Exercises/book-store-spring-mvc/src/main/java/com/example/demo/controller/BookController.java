package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;
import java.util.random.RandomGenerator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.dto.AddBookForm;

@RequestMapping("/books")
@Controller
public class BookController {
	
	public static List<Book> NEW_BOOKS = new ArrayList<Book>() {
		{
			add(new Book(0, "Spring in Action", 100));
			add(new Book(1, "Spring Cloud", 80));
			add(new Book(3, "Docker for Beginners", 30));
		}
	};
	
	@GetMapping
	private String getAll(Model model) {
		model.addAttribute("books", NEW_BOOKS);
		model.addAttribute("addBookForm", new AddBookForm());
		return "books";

	}
	
	@PostMapping(path = "/add")
	private void add(@ModelAttribute AddBookForm addBookForm, Model model) {
		model.addAttribute("books", NEW_BOOKS);
		
		NEW_BOOKS.add(new Book(RandomGenerator.getDefault().nextInt(100), addBookForm.getTitle(), addBookForm.getPrice()));
		throw new MyException();
		//return "books";
	}

}
