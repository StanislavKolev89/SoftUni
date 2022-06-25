package com.example.regexam.repository;

import com.example.regexam.model.entity.SongEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<SongEntity,Long> {
   @Query("select s FRom SongEntity s Where s.style.styleName='POP'")
    List<SongEntity> findPopSongs();
    @Query("select s FRom SongEntity s Where s.style.styleName='ROCK'")
    List<SongEntity> findRockSongs();
    @Query("select s FRom SongEntity s Where s.style.styleName='JAZZ'")
    List<SongEntity> findJazzSongs();

    @Query(value = "SELECT * FROM 'songs_users' WHERE 'users_id'=:id ",nativeQuery = true)
    List<SongEntity> findAllByUserId(@Param("id")Long id);
}
