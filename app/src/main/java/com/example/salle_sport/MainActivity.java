package com.example.salle_sport;

import static com.google.firebase.database.FirebaseDatabase.getInstance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText username;
    EditText password;
    Button loginButton;
    Button signupButton;
    DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);
        signupButton = findViewById(R.id.signupbtn);
        database = FirebaseDatabase.getInstance().getReference("Client");

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                database.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        // Cette méthode est appelée lorsque les données sont récupérées avec succès
                        // dataSnapshot contient les données du nœud "Client"
                        for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                            // Parcourt tous les enfants du nœud "Client"
                            Client user = userSnapshot.getValue(Client.class);
                            // Convertit chaque enfant en objet de la classe Client
                            // où Client est une classe Java qui correspond à la structure des données
                            // stockées dans le nœud "Client"

                            // Compare le nom d'utilisateur et le mot de passe fournis avec ceux stockés dans Firebase
                            if (username.getText().toString().equals(user.getUser()) && password.getText().toString().equals(user.getPass())) {
                                // Les informations d'identification sont correctes, l'utilisateur est authentifié
                                // Faites quelque chose ici, par exemple, ouvrez l'activité principale de l'application
                                Intent intent2 = new Intent(MainActivity.this, Choix.class);
                                startActivity(intent2);
                                return;
                            }
                        }
                        // Les informations d'identification sont incorrectes, affichez un message d'erreur approprié
                        Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Cette méthode est appelée lorsque la récupération des données échoue
                        // Affichez un message d'erreur approprié
                        Toast.makeText(MainActivity.this, "Failed to retrieve data from database", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Sing_up.class);
                startActivity(intent);
            }
        });
    }

    public void goToAdd(View v) {
        Intent i = new Intent(this, Sing_up.class);
        i.putExtra("child_name", "Client");
        startActivityForResult(i, 1);
    }
}
