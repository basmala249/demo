package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Classes.book;

@Repository
public interface BookRepository extends JpaRepository<book, Integer> {
    
}
