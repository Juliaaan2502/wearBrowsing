package de.juliaaan2502.wearbrowsing;

import android.app.Activity;
import android.os.Bundle;

import de.juliaaan2502.wearbrowsing.databinding.ActivityMainBinding;

public class SettingsActivity extends Activity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}