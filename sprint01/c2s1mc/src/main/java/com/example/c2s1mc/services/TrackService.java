package com.example.c2s1mc.services;

import com.example.c2s1mc.domain.Track;

import java.util.List;

public interface TrackService {
    Track saveUser(Track track) ;
    List<Track> getAllUsers();
    Track updateUser(Track track, int tid );
    boolean deleteUserByEmail(int tid);


}
