
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];


    void clear() {
        int size = size();
        for (int i = 0; i < size; i++){
            storage[i] = null;
        }
    }

    void save(Resume r) {
        storage[size()] = r;
    }

    Resume get(String uuid) {
        int size = size();
        for(int i = 0; i < size; i++) {
            if (storage[i].uuid.equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        int size = size();
        for(int i = 0; i < size; i++){
            if(storage[i].uuid.equals(uuid)){
                int k = i;
                while (storage[k] != null){
                    storage[k] = storage[k+1];
                    k++;
                }
                return;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        System.arraycopy(storage, 0, resumes, 0, resumes.length);
        return resumes;
    }

    int size() {
        int i = 0;
        while (storage[i] != null){
            i++;
        }
        return i;
    }
}
