package com.example.c2s3mc.services;

import com.example.c2s3mc.domain.Music;
import com.example.c2s3mc.exception.MusicNotFound;

import java.util.List;

public interface MusicService {
    Music saveMusic(Music music);
    List<Music> getAllMusicData() throws MusicNotFound;
    public boolean deleteMusic(int trackId) throws MusicNotFound;
    List<Music> getAllMusicByTrackRating(int trackRating) throws MusicNotFound;
    List<Music> getAllMusicByArtistName(String artistName) throws MusicNotFound;
}