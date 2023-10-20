package com.example.music.Service.Impl;

import com.example.music.DTO.SingerDTO;
import com.example.music.DTO.SongDTO;
import com.example.music.Entity.Author;
import com.example.music.Entity.Playlist;
import com.example.music.Entity.Singer;
import com.example.music.Entity.Song;
import com.example.music.Exception.NotFoundException;
import com.example.music.Mapper.ISongMapper;
import com.example.music.Repository.IAuthorRepository;
import com.example.music.Repository.IPlaylistRepository;
import com.example.music.Repository.ISingerRepository;
import com.example.music.Repository.ISongRepository;
import com.example.music.Service.ISongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SongService implements ISongService {
    private final ISongRepository songRepository;
    private final ISongMapper songMapper;
    private final ISingerRepository singerRepository;
    private final IPlaylistRepository playlistRepository;
    private final IAuthorRepository authorRepository;

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
        Set<Singer> singerSet = new HashSet<>();
        for (Singer sing: songDTO.getSingerSet()){
            Singer singer = singerRepository.findById(index).orElse(null);
            if (singer != null){
                singerSet.add(singer);
            }
        }
        Set<Playlist> playlistSet = new HashSet<>();
        for (int index: songDTO.getPlaylistSet()){
            Playlist playlist = playlistRepository.findById(index).orElse(null);
            if (playlist != null){
                playlistSet.add(playlist);
            }
        }

        Set<Author> authorSet = new HashSet<>();
        for (int index: songDTO.getAuthorSet()){
            Author author = authorRepository.findById(index).orElse(null);
            if (author != null){
                authorSet.add(author);
            }
        }

        Song song = songMapper.songDTOToSong(songDTO);
        song.setSingerSet(singerSet);
        song.setAuthorSet(authorSet);
        song.setPlaylistSet(playlistSet);

        songRepository.save(song);
    }
}
