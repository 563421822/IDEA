package service;

public interface ILoginService {
    int login(String username, String password, String role) throws Exception;
}
