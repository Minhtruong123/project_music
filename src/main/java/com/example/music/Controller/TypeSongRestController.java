package com.example.music.Controller;

import com.example.music.DTO.TypeSongDTO;
import com.example.music.Entity.TypeSong;
import com.example.music.Mapper.ITypeSongMapper;
import com.example.music.Service.Impl.TypeSongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class TypeSongRestController extends AbstractController{
    private final TypeSongService typeSongService;
    private final ITypeSongMapper typeSongMapper;
    @GetMapping("/typesong")
    public ResponseEntity<?> findAllTypeSong(@RequestParam(required = false, defaultValue = "")String search){
        return ok(typeSongService.listAllTypeSongDTO(search));
    }
    @GetMapping("/typesong/{id}")
    public ResponseEntity<?> findAllTypeSongByID(@PathVariable int id){
        return ok(typeSongMapper.typeSongToTypeSongDTO(typeSongService.findTypeSongById(id)));
    }
    @PostMapping("/typesong")
    public ResponseEntity<?> addTypeSong(@RequestBody TypeSongDTO typeSongDTO){
        typeSongService.addTypeSong(typeSongDTO);
        return noContent();
    }
    @PutMapping("/typesong")
    public ResponseEntity<?> editTypeSong(@RequestBody TypeSongDTO typeSongDTO){
        typeSongService.addTypeSong(typeSongDTO);
        return noContent();
    }
    @DeleteMapping ("/typesong/{id}")
    public ResponseEntity<?> deleteTypeSong(@PathVariable int id){
        TypeSong typeSong = typeSongService.findTypeSongById(id);
        typeSongService.deleteTypeSong(typeSong);
        return noContent();
    }
}
