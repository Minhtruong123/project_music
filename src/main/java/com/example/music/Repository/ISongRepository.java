package com.example.music.Repository;

import com.example.music.Entity.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public interface ISongRepository extends JpaRepository<Song,Integer> {
    List<Song> findSongByNameSongIsContaining(String search);
}
