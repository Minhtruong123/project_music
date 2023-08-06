package com.example.music.Service.Impl;

import com.example.music.DTO.AuthorDTO;
import com.example.music.Entity.Author;
import com.example.music.Exception.NotFoundException;
import com.example.music.Mapper.IAuthorMapper;
import com.example.music.Repository.IAuthorRepository;
import com.example.music.Service.IAuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorService implements IAuthorService {
    private final IAuthorRepository authorRepository;
    private final IAuthorMapper authorMapper;

    @Override
    public List<AuthorDTO> findAllAuthor(String search) {
        return authorRepository.findAuthorByNameAuthorIsContaining(search).stream().map(authorMapper::authorToAuthorDTO).collect(Collectors.toList());
    }

    @Override
    public Author findAuthorById(int id) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author == null){
            throw new NotFoundException(String.format("Not found request application by id %d", id));
        }
        return author;
    }

    @Override
    public void addAuthor(AuthorDTO authorDTO) {
        Author author = authorMapper.authorDTOToAuthor(authorDTO);
        authorRepository.save(author);
    }

    @Override
    public void deleteAuthor(Author author) {
        authorRepository.delete(author);
    }
}
