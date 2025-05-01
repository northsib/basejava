import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] resumes = new Resume[10000];
    private int resumesCount = 0;

    void clear() {
        Arrays.fill(resumes, 0, resumesCount - 1, null);
        resumesCount = 0;
    }

    void save(Resume resume) {
        if (resumesCount < 10000) {
            resumes[resumesCount] = resume;
            resumesCount++;
            return;
        }
        System.out.println("Резюме не сохранено, превышен лимит хранения резюме в памяти");
    }

    Resume get(String uuid) {
        for (int i = 0; i < resumesCount; i++) {
            if (uuid.equals(resumes[i].toString())) {
                return resumes[i];
            }
        }
        System.out.println("Резюме не найдено");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < resumesCount; i++) {
            if (resumes[i].toString().equals(uuid)) {
                System.arraycopy(resumes, i + 1, resumes, i, resumesCount - i - 1);
                resumesCount--;
                resumes[resumesCount] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(resumes, resumesCount);
    }

    int size() {
        return resumesCount;
    }
}
