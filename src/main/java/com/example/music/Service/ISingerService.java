package com.example.music.Service;

import com.example.music.DTO.SingerDTO;
import com.example.music.Entity.Singer;

import java.util.List;

public interface ISingerService {
    List<SingerDTO> findAllSinger(String search);
    Singer findSingerById(int id);
    void addSinger(SingerDTO singerDTO);
    void deleteSinger(Singer singer);
}
