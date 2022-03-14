package fr.maven.exercicemvc.services;

import fr.maven.exercicemvc.entities.Post;
import fr.maven.exercicemvc.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostService implements IPostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> findAll() {
      return postRepository.findAll();
    }

    @Override
    public List<Post> findLatest5() {
        return null;
    }

    @Override
    public Optional<Post> findById(Long id) {
        return postRepository.findById(id);
    }

    @Override
    public Post create(Post post) {
        return null;
    }

    @Override
    public Post edit(Post post) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }
}
