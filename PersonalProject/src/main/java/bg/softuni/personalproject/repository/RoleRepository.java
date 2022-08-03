package bg.softuni.personalproject.repository;

import bg.softuni.personalproject.model.entity.RoleEntity;
import bg.softuni.personalproject.model.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Long> {

    RoleEntity findRoleEntityByName(RoleEnum name);


}
