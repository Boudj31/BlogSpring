package fr.maven.exercicemvc.services;

import fr.maven.exercicemvc.entities.Post;

import java.util.List;
import java.util.Optional;

public interface IPostService {

    List<Post> findAll();
    List<Post> findLatest5();
    Optional<Post> findById(Long id);
    Post create(Post post);
    Post edit(Post post);
    void deleteById(Long id);
}
