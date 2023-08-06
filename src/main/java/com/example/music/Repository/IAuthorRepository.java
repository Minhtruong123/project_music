package com.example.music.Repository;

import com.example.music.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAuthorRepository extends JpaRepository<Author,Integer> {
    List<Author> findAuthorByNameAuthorIsContaining(String search);
}
