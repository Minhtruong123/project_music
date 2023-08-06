package com.example.music.Repository;

import com.example.music.Entity.TypeSong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITypeSongRepository extends JpaRepository<TypeSong,Integer> {
    List<TypeSong> findTypeSongByTypeNameIsContaining(String search);
}
