package com.dev_candra.example_fragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    // Inisiasi UI yang ada di layout main activity
    private FrameLayout frameLayout1,frameLayout2;
    private Button button1,button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Melanjutkan inisasi UI yang ada di framelayout
        frameLayout1 = findViewById(R.id.layout_fragment_one);
        frameLayout2 = findViewById(R.id.layout_fragment_two);

        // Melanjutkan inisasi UI yang ada di button
        button1 = findViewById(R.id.button_fragment_one);
        button2 = findViewById(R.id.button_fragment_two);

        // buat method aksi untuk melakukan aksi pada ui yang dibuat
        Aksi();

    }

    private void Aksi(){
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat framelayout muncul
                frameLayout1.setVisibility(View.VISIBLE);
                frameLayout2.setVisibility(View.GONE);
                // Melakukan aksi agar button dapat diklik dan memunculkan fragment
                setNewFragmentOne(new fragment_one());
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Membuat framelayout2 muncul
                frameLayout1.setVisibility(View.GONE);
                frameLayout2.setVisibility(View.VISIBLE);
                // Melakukan aksi agar button dapat diklik dan memunculkan fragment
                setNewFragmentTwo(new fragment_two());
            }
        });

    }

    private void setNewFragmentTwo(fragment_two fragment_two) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout2.getId(),fragment_two);
        fragmentTransaction.commit();
    }

    private void setNewFragmentOne(Fragment fragmentOne){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(frameLayout1.getId(),fragmentOne);
        fragmentTransaction.commit();
    }
}
