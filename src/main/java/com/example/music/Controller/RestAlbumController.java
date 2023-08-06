package com.example.music.Controller;

import com.example.music.DTO.AlbumDTO;
import com.example.music.Entity.Album;
import com.example.music.Mapper.IAlbumMapper;
import com.example.music.Service.Impl.AlbumService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class RestAlbumController extends AbstractController{
    private final AlbumService albumService;
    private final IAlbumMapper albumMapper;
    @GetMapping("/album")
    public ResponseEntity<?> findAllAlbum(@RequestParam(required = false, defaultValue = "")String search){
        return ok(albumService.findAllAlbum(search));
    }
    @GetMapping("/album/{id}")
    public ResponseEntity<?> findAlbumById(@PathVariable int id){
        return ok(albumMapper.albumToAlbumDTO(albumService.findAlbumById(id)));
    }
    @PostMapping("/album")
    public ResponseEntity<?> addAlbum(@RequestBody AlbumDTO albumDTO){
        albumService.addAlbum(albumDTO);
        return noContent();
    }
    @PutMapping("/album")
    public ResponseEntity<?> editAlbum(@RequestBody AlbumDTO albumDTO){
        albumService.addAlbum(albumDTO);
        return noContent();
    }
    @DeleteMapping("/album/{id}")
    public ResponseEntity<?> deleteAlbum(@PathVariable int id){
        Album album = albumService.findAlbumById(id);
        albumService.deleteAlbum(album);
        return noContent();
    }
}
