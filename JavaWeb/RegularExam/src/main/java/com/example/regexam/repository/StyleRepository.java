package com.example.regexam.repository;

import com.example.regexam.model.entity.StyleEntity;
import com.example.regexam.model.enums.StyleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<StyleEntity,Long> {

    StyleEntity findByStyleName(StyleEnum styleName);
}
