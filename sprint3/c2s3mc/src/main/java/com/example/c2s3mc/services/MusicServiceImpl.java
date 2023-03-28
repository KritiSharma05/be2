package com.example.c2s3mc.services;

import com.example.c2s3mc.domain.Music;
import com.example.c2s3mc.exception.MusicNotFound;
import com.example.c2s3mc.repository.MusicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicServiceImpl implements MusicService{

    MusicRepository musicRepository;
    public MusicServiceImpl(MusicRepository musicRepository){
        this.musicRepository = musicRepository;
    }

    @Override
    public Music saveMusic(Music music) {
        return musicRepository.save(music);
    }

    @Override
    public List<Music> getAllMusicData() throws MusicNotFound {
        return musicRepository.findAll();
    }

    @Override
    public boolean deleteMusic(int trackId) throws MusicNotFound {
        boolean result = false;
        if(musicRepository.findById(trackId).isEmpty()){
            throw new MusicNotFound();
        }else{
            musicRepository.deleteById(trackId);
            result = true;
        }
        return result;
    }


    @Override
    public List<Music> getAllMusicByTrackRating(int trackRating) throws MusicNotFound {
        if(musicRepository.findAllMusicFromTrackRating(trackRating).isEmpty()){
            throw  new MusicNotFound();
        }
        return musicRepository.findAllMusicFromTrackRating(trackRating);
    }

    @Override
    public List<Music> getAllMusicByArtistName(String artistName) throws MusicNotFound {
        if(musicRepository.findAllMusicFromArtistName(artistName).isEmpty()){
            throw  new MusicNotFound();
        }
        return musicRepository.findAllMusicFromArtistName(artistName);
    }
}
