package com.archer.monolithic.Trivia.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.archer.monolithic.Trivia.Model.Trivia;

public interface TriviaDao extends JpaRepository<Trivia, Integer> {

}
