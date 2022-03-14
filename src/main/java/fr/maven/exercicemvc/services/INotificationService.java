package fr.maven.exercicemvc.services;

public interface INotificationService {
    void addInfoMessage(String msg);
    void addErrorMessage(String msg);
}
