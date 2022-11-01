package com.zybooks.lightsoutnav;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridLayout;


public class GameFragment extends Fragment {
    private final String GAME_STATE = "gameState";
    private LightsOutGame mGame;
    private GridLayout mLightGrid;
    private int mLightOnColor;
    private int mLightoffColor;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View parentView = inflater.inflate(R.layout.fragment_game, container, false);

        mLightGrid = parentView.findViewById(R.id.light_grid);
        for (int i = 0; i < mLightGrid.getChildCount(); i++){
            Button gridButton = (Button) mLightGrid.getChildAt(i);
            gridButton.setOnClickListener(this::onLightButtonClick);
        }

        Button newGameBtn = parentView.findViewById(R.id.new_game_button);
        newGameBtn.setOnClickListener(v -> startGame());

        SharedPreferences sharedPref = this.requireActivity().getPreferences(Context.MODE_PRIVATE);

        return;
    }
}