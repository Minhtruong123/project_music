package com.example.music.Controller;

import com.example.music.DTO.SongDTO;
import com.example.music.Entity.Song;
import com.example.music.Mapper.ISongMapper;
import com.example.music.Service.Impl.SongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class RestSongController extends AbstractController{
    private final SongService songService;
    private final ISongMapper songMapper;
    @GetMapping("/song")
    public ResponseEntity<?> findAllSongs(@RequestParam(defaultValue = "", required = false)String search){
        return  ok(songService.findAllSong(search));
    }
    @GetMapping("/song/{id}")
    public ResponseEntity<?> findSongById(@PathVariable int id){
        return  ok(songMapper.songToSongDTO(songService.findSongById(id)));
    }
    @PostMapping("/song")
    public ResponseEntity<?> addSong(@RequestBody SongDTO songDTO){
        songService.addSong(songDTO);
        return noContent();
    }
    @PutMapping("/song")
    public ResponseEntity<?> editSong(@RequestBody SongDTO songDTO){
        songService.addSong(songDTO);
        return noContent();
    }
}
