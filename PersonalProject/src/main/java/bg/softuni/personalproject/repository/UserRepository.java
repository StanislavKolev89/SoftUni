package bg.softuni.personalproject.repository;

import bg.softuni.personalproject.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByEmail(String email);

    UserEntity findByUsername(String value);

    Optional<UserEntity> findById(Long id);
}
