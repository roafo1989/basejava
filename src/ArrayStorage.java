
/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        int i = 0;
        while (storage[i] != null){
            storage[i] = null;
            i++;
        }
    }

    void save(Resume r) {
        for(int i = 0; i < storage.length; i++){
            if(storage[i]==null){
                storage[i] = r;
                return;
            }
        }
    }

    Resume get(String uuid) {
        int i = 0;
        while (storage[i] != null){
            if(storage[i].uuid.equals(uuid)){
                return storage[i];
            }
            i++;
        }
        return null;
    }

    void delete(String uuid) {
        int i = 0;
        while (storage[i] != null){
            if(storage[i].uuid.equals(uuid)){
                int k = i;
                while (storage[k] != null){
                    storage[k] = storage[k+1];
                    k++;
                }
                return;
            }
            i++;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int lenght = 0;
        for(int i = 0; i < storage.length; i++){
            if(storage[i]==null){
                lenght = i;
                break;
            }
        }
        Resume[] resumes = new Resume[lenght];
        System.arraycopy(storage, 0, resumes, 0, resumes.length);
        return resumes;
    }

    int size() {
        return storage.length;
    }
}
