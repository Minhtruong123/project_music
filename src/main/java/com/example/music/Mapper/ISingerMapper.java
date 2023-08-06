package com.example.music.Mapper;

import com.example.music.DTO.SingerDTO;
import com.example.music.Entity.Singer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ISingerMapper {
    SingerDTO singerToSingerDTO(Singer singer);
    Singer singerDTOToSinger(SingerDTO singerDTO);
}
