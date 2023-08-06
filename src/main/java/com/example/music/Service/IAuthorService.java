package com.example.music.Service;

import com.example.music.DTO.AuthorDTO;
import com.example.music.Entity.Author;

import java.util.List;

public interface IAuthorService {
    List<AuthorDTO> findAllAuthor(String search);
    Author findAuthorById(int id);
    void addAuthor(AuthorDTO authorDTO);
    void deleteAuthor(Author author);
}
