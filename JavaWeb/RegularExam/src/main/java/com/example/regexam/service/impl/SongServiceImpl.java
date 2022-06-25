package com.example.regexam.service.impl;

import com.example.regexam.model.entity.SongEntity;
import com.example.regexam.model.service.AddSongService;
import com.example.regexam.repository.SongRepository;
import com.example.regexam.service.SongService;
import com.example.regexam.service.StyleService;
import com.example.regexam.service.UserService;
import com.example.regexam.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SongServiceImpl implements SongService {

    private final ModelMapper modelMapper;
    private final SongRepository songRepository;
    private final StyleService styleService;
    private final CurrentUser currentUser;
    private final UserService userService;



    public SongServiceImpl(ModelMapper modelMapper, SongRepository songRepository, StyleService styleService, CurrentUser currentUser, UserService userService, UserService userService1) {
        this.modelMapper = modelMapper;
        this.songRepository = songRepository;
        this.styleService = styleService;
        this.currentUser = currentUser;

        this.userService = userService1;
    }

    @Override
    public List<SongEntity> findJazzSongs() {
        return songRepository.findJazzSongs();
    }

    @Override
    public void saveSong(AddSongService song) {
        SongEntity songEntity = modelMapper.map(song, SongEntity.class);
        songEntity.setStyle(styleService.findByStyleEnum(song.getStyle()));
        songEntity.getUsers().add(userService.findById(currentUser.getId()));
        songRepository.save(songEntity);

    }

    @Override
    public List<SongEntity> findPopSongs() {
        return songRepository.findPopSongs();
    }

    @Override
    public List<SongEntity> findRockSongs() {
        return songRepository.findRockSongs();
    }

    @Override
    public SongEntity findById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public String findAllTime() {
        int v = songRepository.findAll().stream().mapToInt(song -> song.getDuration()).reduce((a, b) -> a + b).orElse(0);
        int min=v/60;
        int sec = v%60;
        return String.format("%d:%d",min,sec);
    }

    @Override
    public List<SongEntity> findUserSongs(Long id) {
        return songRepository.findAllByUserId(id);
    }

    private List<SongEntity> addSongs(String id) {
        List<SongEntity> songEntities = null;
        switch (id) {
            case "POP" -> songEntities = songRepository.findPopSongs();
            case "JAZZ" -> songEntities = songRepository.findJazzSongs();
            case "ROCK" -> songEntities = songRepository.findRockSongs();
        }
        return songEntities;
    }


}
