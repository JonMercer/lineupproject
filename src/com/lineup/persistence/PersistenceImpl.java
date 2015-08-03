package persistence;

/**
 * Created by Jon Mercer on 15-08-03.
 */
public class PersistenceImpl implements Persistence {
    @Override
    public boolean accidentalReeboot() {
        return false;
    }

    @Override
    public void saveState(State state) {

    }

    @Override
    public State loadState() {
        return null;
    }
}
