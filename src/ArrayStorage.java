import com.sun.deploy.util.ArrayUtil;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        for(int i = 0; i < storage.length; i++) storage[i] = null;
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
        Resume r = null;
        for (Resume resume : storage) {
            if (resume.uuid.equals(uuid)) r = resume;
            break;
        }
        return r;
    }

    void delete(String uuid) {
       for(int i = 0; i < storage.length; i++){
           if(storage[i].uuid.equals(uuid)) {
               for(int k = i; k < storage.length; k++){
                   if(storage[k] != null){
                       storage[k] = storage[k+1];
                   } else return;
               }
           }
       }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return storage;
    }

    int size() {
        return storage.length;
    }
}
