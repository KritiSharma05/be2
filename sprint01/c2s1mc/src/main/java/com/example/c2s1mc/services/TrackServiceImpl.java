package com.example.c2s1mc.services;

import com.example.c2s1mc.domain.Track;
import com.example.c2s1mc.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TrackServiceImpl implements TrackService {
    private final TrackRepository userRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Track saveUser(Track user)  {
        return userRepository.save(user);
    }

    @Override
    public List<Track> getAllUsers() {
        return (List<Track>) userRepository.findAll();
    }

    @Override
    public Track updateUser(Track user, int tid) {
        Optional<Track> optUser = userRepository.findById(tid);
        if(optUser.isEmpty())
        {
            return null;
        }
        Track existingUser = optUser.get();
        if(user.getTname()!=null){
            existingUser.setTname(user.getTname());
        }
        if(user.getTcom()!=null){
            existingUser.setTcom(user.getTcom());
        }
        if(user.getTrate()!=null){
            existingUser.setTrate(user.getTrate());
        }
        return userRepository.save(existingUser);
    }

    @Override
    public boolean deleteUserByEmail(int tid) {
        userRepository.deleteById(tid);
        return true;
    }




}
