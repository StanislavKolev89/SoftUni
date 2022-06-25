package com.example.regexam.service;

import com.example.regexam.model.entity.SongEntity;
import com.example.regexam.model.service.AddSongService;

import java.util.List;

public interface SongService {


    List<SongEntity> findJazzSongs();

    void saveSong(AddSongService map);

    List<SongEntity> findPopSongs();

    List<SongEntity> findRockSongs();


    SongEntity findById(Long id);

    String findAllTime();

    List<SongEntity> findUserSongs(Long id);
}
