package com.example.music.Repository;

import com.example.music.Entity.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IAlbumRepository extends JpaRepository<Album,Integer> {
    List<Album> findAlbumByNameAlbumIsContaining(String search);
}
