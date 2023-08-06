package com.example.music.Controller;

import com.example.music.DTO.SingerDTO;
import com.example.music.Entity.Singer;
import com.example.music.Mapper.ISingerMapper;
import com.example.music.Service.Impl.SingerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class SingerRestControlelr extends AbstractController{
    private final SingerService singerService;
    private final ISingerMapper singerMapper;
    @GetMapping("/singer")
    public ResponseEntity<?> findAllSinger(@RequestParam(defaultValue = "",required = false)String search){
        return ok(singerService.findAllSinger(search));
    }
    @GetMapping("/singer/{id}")
    public ResponseEntity<?> findSingerById(@PathVariable int id){
        return ok(singerMapper.singerToSingerDTO(singerService.findSingerById(id)));
    }
    @PostMapping("/singer")
    public ResponseEntity<?> addSinger(@RequestBody SingerDTO singerDTO){
        singerService.addSinger(singerDTO);
        return noContent();
    }
    @PutMapping("/singer")
    public ResponseEntity<?> editSinger(@RequestBody SingerDTO singerDTO){
        singerService.addSinger(singerDTO);
        return noContent();
    }
    @DeleteMapping("/singer/{id}")
    public ResponseEntity<?> deleteSinger(@PathVariable int id){
        Singer singer = singerService.findSingerById(id);
        singerService.deleteSinger(singer);
        return noContent();
    }
}
