package com.archer.monolithic.Trivia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.archer.monolithic.Trivia.Model.QuestionWrapper;
import com.archer.monolithic.Trivia.Model.Questions;
import com.archer.monolithic.Trivia.Model.Response;
import com.archer.monolithic.Trivia.Service.TriviaService;

@RestController
@RequestMapping("trivia")
public class TriviaController {
	
	@Autowired
	TriviaService triviaService;
	
	// 1. Create Trivia
	@PostMapping("create")
	public ResponseEntity<String> createTrivia(@RequestParam String category, @RequestParam int numOfQuestions, @RequestParam String title){
		return triviaService.createTrivia(category, numOfQuestions, title);
	}
	
	// 2. Fetch Questions for Trivia
	@GetMapping("get/{id}")
	public ResponseEntity<List<QuestionWrapper>> getTriviaQuestions(@PathVariable Integer id){
		return triviaService.getTriviaQuestions(id);
	}
	

	//3. Submit Trivia
	@PostMapping("/submit/{id}")
	public ResponseEntity<Integer> submitTrivia(@PathVariable Integer id, @RequestBody List<Response> responses){
		return triviaService.calculateResult(id, responses);
	}
}
