package com.example.music.Controller;

import com.example.music.DTO.PlaylistDTO;
import com.example.music.Entity.Playlist;
import com.example.music.Mapper.IPlaylistMapper;
import com.example.music.Service.Impl.AuthorService;
import com.example.music.Service.Impl.PlaylistService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequiredArgsConstructor
@Slf4j
public class RestPlaylistController extends AbstractController{
    private final PlaylistService playlistService;
    private final IPlaylistMapper playlistMapper;
    @GetMapping("/playlist")
    public ResponseEntity<?> findAllPlaylist(@RequestParam(defaultValue = "",required = false)String search){
        return ok(playlistService.findAllPlaylistDTO(search));
    }
    @GetMapping("/playlist/{id}")
    public ResponseEntity<?> findPlaylistById(@PathVariable int id){
        return ok(playlistMapper.playlistToPlaylistDTO(playlistService.findPlayListById(id)));
    }
    @PostMapping("/playlist")
    public ResponseEntity<?> addPlaylist(@RequestBody PlaylistDTO playlistDTO){
        playlistService.addPlaylist(playlistDTO);
        return noContent();
    }
    @PutMapping("/playlist")
    public ResponseEntity<?> editPlaylist(@RequestBody PlaylistDTO playlistDTO){
        playlistService.addPlaylist(playlistDTO);
        return noContent();
    }
    @DeleteMapping("/playlist/{id}")
    public ResponseEntity<?> deletePlaylist(@PathVariable int id){
        Playlist playlist = playlistService.findPlayListById(id);
        playlistService.deletePlaylist(playlist);
        return noContent();
    }
}
