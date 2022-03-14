package fr.maven.exercicemvc.services;
import fr.maven.exercicemvc.entities.User;
import fr.maven.exercicemvc.form.LoginForm;

import java.util.Optional;

public interface IUserService {

    User register(User user) throws Exception;
    //boolean login(String email, String password) throws Exception;
    User checkLogin(LoginForm login) throws Exception;
    User findById(long id);
    User updateProfil(User user);
    void deleteProfil(long id);
    User updateProfile(User user) throws Exception;
}
