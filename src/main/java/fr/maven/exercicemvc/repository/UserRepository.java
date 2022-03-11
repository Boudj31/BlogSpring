package fr.maven.exercicemvc.repository;

import fr.maven.exercicemvc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("FROM User u where u.email= :email")
    User findByEmail(@Param("email") String email);

}
