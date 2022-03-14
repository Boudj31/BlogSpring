package fr.maven.exercicemvc.services;

import fr.maven.exercicemvc.entities.User;
import fr.maven.exercicemvc.form.LoginForm;
import fr.maven.exercicemvc.repository.UserRepository;
import fr.maven.exercicemvc.tools.HashTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService{

    @Autowired
    private UserRepository userRepository;


    @Override
    public User register(User user) throws Exception {
        user.setPassword(HashTools.hashSHA512(user.getPassword()));
      return userRepository.saveAndFlush(user);
    }

    @Override
    public User checkLogin(LoginForm login) throws Exception {
        User u = userRepository.findByEmail(login.getEmail());
        if(u != null && u.getPassword().equals(HashTools.hashSHA512(login.getPassword()))) {
            return u;
        }

        else {

            return null;
        }

    }

    @Override
    public User findById(long id) {
      return  userRepository.getById(id);
    }

    @Override
    public User updateProfil(User user) {
        return null;
    }

    @Override
    public void deleteProfil(long id) {
       userRepository.deleteById(id);

    }

    @Override
    public User updateProfile(User user) throws Exception {
      //  Optional<User> userExist = userRepository.findById(user.getId());
        //if(userExist.isPresent()) {
         //   user.setPassword(HashTools.hashSHA512(user.getPassword()));
      //  } else {
      //      throw new Exception("the User doesn't exist in Database");
      //  }
        userRepository.saveAndFlush(user);
        return user;
    }


}
