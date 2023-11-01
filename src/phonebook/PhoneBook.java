package phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Note> notes;

    public PhoneBook() {
        notes = new ArrayList<>();
    }

    public void add(Note note) {
        notes.add(note);
    }

    public Note find(String name) {
        for (Note note : notes) {
            if (note.getName().equals(name)) {
                return note;
            }
        }
        return null;
    }

    public List<Note> findAll(String name) {
        List<Note> result = new ArrayList<>();
        for (Note note : notes) {
            if (note.getName().equals(name)) {
                result.add(note);
            }
        }
        return result.isEmpty() ? null : result;
    }
}
