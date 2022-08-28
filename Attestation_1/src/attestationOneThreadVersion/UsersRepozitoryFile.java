package attestationOneThreadVersion;

public interface UsersRepozitoryFile {
    User findById(int id);
    void create(User user);
    void update(User user);
    void delete(int id);
}
