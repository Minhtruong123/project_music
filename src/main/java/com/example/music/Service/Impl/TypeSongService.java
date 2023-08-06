package com.example.music.Service.Impl;

import com.example.music.DTO.TypeSongDTO;
import com.example.music.Entity.TypeSong;
import com.example.music.Exception.NotFoundException;
import com.example.music.Mapper.ITypeSongMapper;
import com.example.music.Repository.ITypeSongRepository;
import com.example.music.Service.ITypeSongService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TypeSongService implements ITypeSongService {
    private final ITypeSongRepository typeSongRepository;

    private final ITypeSongMapper typeSongMapper;

    @Override
    public List<TypeSongDTO> listAllTypeSongDTO(String search) {
        return typeSongRepository.findTypeSongByTypeNameIsContaining(search).stream().map(typeSongMapper::typeSongToTypeSongDTO).collect(Collectors.toList());
    }

    @Override
    public TypeSong findTypeSongById(int id) {
        TypeSong typeSong = typeSongRepository.findById(id).orElse(null);
        if (typeSong == null){
            throw new NotFoundException(String.format("Not found request application by id %d", id));
        }
        return typeSong;
    }

    @Override
    public void addTypeSong(TypeSongDTO typeSongDTO) {
        TypeSong typeSong = typeSongMapper.typeSongDTOToTypeSong(typeSongDTO);
        typeSongRepository.save(typeSong);
    }

    @Override
    public void deleteTypeSong(TypeSong typeSong) {
        typeSongRepository.delete(typeSong);
    }
}
