package repository;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GenericRepository<T> implements Repository<T> {

    protected final List<T> entities = new ArrayList<>();

    @Override
    public void save(T entity) {
        entities.add(entity);
    }

    @Override
    public Optional<T> findById(int id) {

        if (entities.isEmpty()) {
            return Optional.empty();
        }

        return Optional.ofNullable(entities.get(0));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(entities);
    }
}