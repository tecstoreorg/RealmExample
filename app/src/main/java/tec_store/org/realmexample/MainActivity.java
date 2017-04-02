package tec_store.org.realmexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {
    Realm realm;
    FloatingActionButton fab;
    NoteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        realm = Realm.getDefaultInstance();

        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddNoteActivity.class));
            }
        });


        RealmResults<Note> results = realm.where(Note.class).findAll();


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        adapter = new NoteAdapter(this, results);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();

    }

    private void logRes() {
        RealmResults<Note> results = realm.where(Note.class).findAll();
        for (Note note1 : results) {
            Log.d("3llomi", "id" + note1.getId() + " note title " + note1.getNoteTitle() + " note content " + note1.getNoteContent());

        }
    }


}
