package tec_store.org.realmexample;

import io.realm.RealmObject;

/**
 * Created by devlomi on 3/31/17.
 */

public class Note extends RealmObject {

    private int id;
    private String noteTitle, noteContent;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNoteTitle() {
        return noteTitle;
    }

    public void setNoteTitle(String noteTitle) {
        this.noteTitle = noteTitle;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }
}
