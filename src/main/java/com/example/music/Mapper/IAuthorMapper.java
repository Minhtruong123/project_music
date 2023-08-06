package com.example.music.Mapper;

import com.example.music.DTO.AuthorDTO;
import com.example.music.Entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAuthorMapper {
    AuthorDTO authorToAuthorDTO(Author author);
    Author authorDTOToAuthor(AuthorDTO authorDTO);
}
