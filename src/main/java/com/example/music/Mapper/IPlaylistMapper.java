package com.example.music.Mapper;

import com.example.music.DTO.PlaylistDTO;
import com.example.music.Entity.Playlist;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IPlaylistMapper {
    PlaylistDTO playlistToPlaylistDTO(Playlist playlist);
    Playlist playListDTOToPlayList(PlaylistDTO playlistDTO);
}
