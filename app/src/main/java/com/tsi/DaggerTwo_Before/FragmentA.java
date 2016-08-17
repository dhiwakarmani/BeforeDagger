package com.tsi.DaggerTwo_Before;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.tsi.DaggerTwo_Before.R;
import com.tsi.DaggerTwo_Before.extras.Keys;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentA extends Fragment implements View.OnClickListener{

    private SharedPreferences mPreferences;
    private EditText input;
    private Button btn;


    public FragmentA() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }


    private void initViews(View view) {
        input = (EditText) view.findViewById(R.id.input_text);
        btn = (Button) view.findViewById(R.id.btn_store);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        storeTextToPreferences();
    }

    private void storeTextToPreferences() {
        String text = input.getText().toString().trim();
        if (text != null && !text.isEmpty()) {
            mPreferences.edit().putString(Keys.PREF_INPUT, text).apply();
        }
    }
}
