import java.util.List;

public interface CrudHuman {
    List<Human> getAllHumans();

    Human getHumanById(int id);

    void createHuman(Human human);

    void updateHuman(Human human);

    void deleteHuman(Human human);

}
