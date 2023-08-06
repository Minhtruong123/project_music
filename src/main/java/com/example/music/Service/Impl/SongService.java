package com.example.music.Service.Impl;

import com.example.music.DTO.SongDTO;
import com.example.music.Entity.Song;
import com.example.music.Exception.NotFoundException;
import com.example.music.Mapper.ISongMapper;
import com.example.music.Repository.ISongRepository;
import com.example.music.Service.ISongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SongService implements ISongService {
    private final ISongRepository songRepository;
    private final ISongMapper songMapper;

    @Override
    public List<SongDTO> findAllSong(String search) {
        return songRepository.findSongByNameSongIsContaining(search).stream().map(songMapper::songToSongDTO).collect(Collectors.toList());
    }

    @Override
    public Song findSongById(int id) {
        Song song = songRepository.findById(id).orElse(null);
        if (song == null){
            throw new NotFoundException(String.format("Not found request application by id %d", id));
        }
        return song;
    }

    @Override
    public void addSong(SongDTO songDTO) {
        Song song = songMapper.songDTOToSong(songDTO);
        songRepository.save(song);
    }
}
