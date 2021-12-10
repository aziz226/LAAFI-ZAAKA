package com.example.laafizaaka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.laafizaaka.Fragments.HopitalFragment;
import com.example.laafizaaka.Fragments.NumeroVertFragment;
import com.example.laafizaaka.Fragments.PharmacieFragment;

public class MainActivity extends AppCompatActivity {

    private ImageView PharBtn, HopBtn, NumVertBtn, PharBtnClick, HopBtnClick, NumVertBtnClick;
    private FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PharBtn= findViewById(R.id.id_pharmacie);
        PharBtnClick= findViewById(R.id.id_pharmacie_clique);
        HopBtn= findViewById(R.id.id_hopital);
        HopBtnClick= findViewById(R.id.id_hopital_click);
        NumVertBtn= findViewById(R.id.id_numero_vert);
        NumVertBtnClick= findViewById(R.id.id_numero_vert_click);


        PharBtn.setOnClickListener(v -> {
            PharBtnClick.setVisibility(View.VISIBLE);
            PharBtn.setVisibility(View.GONE);

            HopBtnClick.setVisibility(View.GONE);
            HopBtn.setVisibility(View.VISIBLE);

            NumVertBtnClick.setVisibility(View.GONE);
            NumVertBtn.setVisibility(View.VISIBLE);

            replaceFragment(new PharmacieFragment());
        });

        HopBtn.setOnClickListener(v -> {
            HopBtnClick.setVisibility(View.VISIBLE);
            HopBtn.setVisibility(View.GONE);

            PharBtnClick.setVisibility(View.GONE);
            PharBtn.setVisibility(View.VISIBLE);

            NumVertBtnClick.setVisibility(View.GONE);
            NumVertBtn.setVisibility(View.VISIBLE);

            replaceFragment(new HopitalFragment());
        });

        NumVertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NumVertBtnClick.setVisibility(View.VISIBLE);
                NumVertBtn.setVisibility(View.GONE);

                HopBtnClick.setVisibility(View.GONE);
                HopBtn.setVisibility(View.VISIBLE);

                PharBtnClick.setVisibility(View.GONE);
                PharBtn.setVisibility(View.VISIBLE);

                replaceFragment(new NumeroVertFragment());
            }
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
    }
}