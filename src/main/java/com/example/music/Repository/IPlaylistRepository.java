package com.example.music.Repository;

import com.example.music.Entity.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IPlaylistRepository extends JpaRepository<Playlist,Integer> {
    List<Playlist> findPlaylistByNamePlaylistIsContaining(String search);
}
