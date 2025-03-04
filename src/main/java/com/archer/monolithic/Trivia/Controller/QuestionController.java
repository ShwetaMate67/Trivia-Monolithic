package com.archer.monolithic.Trivia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.archer.monolithic.Trivia.Model.Questions;
import com.archer.monolithic.Trivia.Service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	// 1. Find All
	@GetMapping("allQuestions")
	public ResponseEntity<List<Questions>> getAllQuestions() {
		return questionService.getAllQuestions();
	}

	// 2. Filter By Category
	@GetMapping("category/{category}")
	public ResponseEntity<List<Questions>> findByCategory(@PathVariable String category){
		return questionService.findByCategory(category);
	}
	
	// 3. Add Questions
	@PostMapping("add")
	public ResponseEntity<String>  addQuestion(@RequestBody Questions question) {
		return questionService.addQuestion(question);
		
	}
	
	//4. Delete Question
	@DeleteMapping("delete/{id}")
	public ResponseEntity<Void> deleteQuestion(@PathVariable Integer id) throws Exception {
        questionService.deleteQuestion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
