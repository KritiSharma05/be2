package com.example.c2s1mc.repository;

import com.example.c2s1mc.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track,Integer> {
}
