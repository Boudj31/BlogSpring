package fr.maven.exercicemvc.repository;

import fr.maven.exercicemvc.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository  extends JpaRepository<Post, Long> {


}
