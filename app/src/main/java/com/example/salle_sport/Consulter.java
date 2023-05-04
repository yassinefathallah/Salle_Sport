package com.example.salle_sport;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Consulter extends AppCompatActivity {

    /*ListView lst;
    ArrayList<String> allClient = new ArrayList<>();
    ArrayList<String> det = new ArrayList<>();
    String[] allTopics = {"user", "email", "date", "pass"};
    String selectedClient;

    AutoCompleteTextView autoSaisie;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.consulter);

        this.autoSaisie = findViewById(R.id.saisieAuto);
        databaseReference = FirebaseDatabase.getInstance().getReference("Client");
        autoSaisie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selectedClient = ((TextView) view).getText().toString();
                getClient(selectedClient);
            }
        });

        adapter = new MyAdapter(Consulter.this, det);
        lst.setAdapter(adapter);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                String selectedTopic = allTopics[i];
                TextView txt = (TextView) view.findViewById(R.id.att);
                Double att = Double.parseDouble(txt.getText().toString());
            }
        });
    }

    public void getClient(final String clientName) {
        det.clear();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Client s = snapshot.child(clientName).getValue(Client.class);

                det.add(s.getEmail());
                det.add(String.valueOf(s.getTel()));
                det.add(s.getDaten());
                det.add(s.getRole());
                det.add(s.getUser());

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(Consulter.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();

        getsClientName();

        ArrayAdapter ar = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, this.allClient);

        autoSaisie.setAdapter(ar);



    }
    private void getsClientName() {
        this.allClient.clear();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot ds : snapshot.getChildren()) {

                    Client s = ds.getValue(Client.class);

                    allClient.add(s.getTel());

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(Consulter.this, "Fail to get data.", Toast.LENGTH_SHORT).show();
            }
        });

    }*/
}
