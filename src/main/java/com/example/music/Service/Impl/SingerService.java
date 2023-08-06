package com.example.music.Service.Impl;

import com.example.music.DTO.SingerDTO;
import com.example.music.Entity.Singer;
import com.example.music.Exception.NotFoundException;
import com.example.music.Mapper.ISingerMapper;
import com.example.music.Repository.ISingerRepository;
import com.example.music.Service.ISingerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
@Service
public class SingerService implements ISingerService {
    private final ISingerRepository singerRepository;
    private final ISingerMapper singerMapper;

    @Override
    public List<SingerDTO> findAllSinger(String search) {
        return singerRepository.findSingerByNameSingerIsContaining(search).stream().map(singerMapper::singerToSingerDTO).collect(Collectors.toList());
    }

    @Override
    public Singer findSingerById(int id) {
        Singer singer = singerRepository.findById(id).orElse(null);
        if (singer == null){
            throw new NotFoundException(String.format("Not found request application by id %d", id));
        }
        return singer;
    }

    @Override
    public void addSinger(SingerDTO singerDTO) {
        Singer singer = singerMapper.singerDTOToSinger(singerDTO);
        singerRepository.save(singer);
    }

    @Override
    public void deleteSinger(Singer singer) {
        singerRepository.delete(singer);
    }
}
