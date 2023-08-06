package com.example.music.Mapper;

import com.example.music.DTO.AlbumDTO;
import com.example.music.Entity.Album;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IAlbumMapper {
    AlbumDTO albumToAlbumDTO(Album album);
    Album albumDTOToAlbum(AlbumDTO albumDTO);
}
