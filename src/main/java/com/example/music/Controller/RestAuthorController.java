package com.example.music.Controller;

import com.example.music.DTO.AuthorDTO;
import com.example.music.Entity.Author;
import com.example.music.Mapper.IAuthorMapper;
import com.example.music.Service.Impl.AuthorService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class RestAuthorController extends AbstractController{
    private final AuthorService authorService;
    private final IAuthorMapper authorMapper;
    @GetMapping("/author")
    public ResponseEntity<?> findAllAuthor(@RequestParam(defaultValue = "",required = false)String search){
        return ok(authorService.findAllAuthor(search));
    }
    @GetMapping("/author/{id}")
    public ResponseEntity<?> findAuthorById(@PathVariable int id){
        return ok(authorMapper.authorToAuthorDTO(authorService.findAuthorById(id)));
    }
    @PostMapping("/author")
    public ResponseEntity<?> addAuthor(@RequestBody AuthorDTO authorDTO){
        authorService.addAuthor(authorDTO);
        return noContent();
    }
    @PutMapping("/author")
    public ResponseEntity<?> editAuthor(@RequestBody AuthorDTO authorDTO){
        authorService.addAuthor(authorDTO);
        return noContent();
    }
    @DeleteMapping("/author/{id}")
    public ResponseEntity<?> deleteAuthor(@PathVariable int id){
        Author author = authorService.findAuthorById(id);
        authorService.deleteAuthor(author);
        return noContent();
    }
}
