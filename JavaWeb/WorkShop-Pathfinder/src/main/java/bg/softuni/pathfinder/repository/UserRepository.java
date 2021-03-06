package bg.softuni.pathfinder.repository;

import bg.softuni.pathfinder.model.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    boolean existsByUsername(String username);

    boolean existsByUsernameAndPassword(String username, String password);

    UserEntity findByUsernameAndPassword(String userName, String password);
}
