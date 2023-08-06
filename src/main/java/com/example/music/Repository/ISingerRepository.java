package com.example.music.Repository;

import com.example.music.Entity.Singer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISingerRepository extends JpaRepository<Singer,Integer> {
    List<Singer> findSingerByNameSingerIsContaining(String search);
}
