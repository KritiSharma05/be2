package com.example.c2s3mc.controller;

import com.example.c2s3mc.domain.Music;
import com.example.c2s3mc.exception.MusicAlreadyExistException;
import com.example.c2s3mc.exception.MusicNotFound;
import com.example.c2s3mc.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/musicdata/v1")
public class MusicController {
    MusicService musicService;

    @Autowired
    public MusicController(MusicService musicService){
        this.musicService = musicService;
    }
    @PostMapping("/postdata")
    public ResponseEntity<?> saveMusicData(@RequestBody Music music) throws MusicAlreadyExistException {
        return new ResponseEntity<>(musicService.saveMusic(music), HttpStatus.CREATED);

    }

    @GetMapping("/getdata")
    public ResponseEntity<?> fetchAllMusic() throws Exception {
        return new ResponseEntity<>(musicService.getAllMusicData(), HttpStatus.FOUND);
    }


    @DeleteMapping("/deleteData/{trackId}")
    public ResponseEntity<?> deleteData(@PathVariable int trackId) throws MusicNotFound, Exception {
        return new ResponseEntity<>(musicService.deleteMusic(trackId), HttpStatus.OK);
    }


    @GetMapping("/getDataByRating/{trackRating}")
    public ResponseEntity<?> getAllMusicByTrackRating(@PathVariable int  trackRating) throws MusicNotFound,Exception{
        return new ResponseEntity<>(musicService.getAllMusicByTrackRating(trackRating),HttpStatus.FOUND);
    }
    @GetMapping("/getDataByArtist/{artistName}")
    public ResponseEntity<?> getAllMusicByTrackRating(@PathVariable String  artistName) throws MusicNotFound,Exception{
        return new ResponseEntity<>(musicService.getAllMusicByArtistName(artistName),HttpStatus.FOUND);
    }
}