package com.ejnkns.Melodown.ui.editor;

import android.content.Context;
import android.media.Image;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.util.Log;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ejnkns.Melodown.R;

public class EditorFragment extends Fragment {

    private EditorViewModel editorViewModel;
    private View root;
    private ConstraintLayout clEditor;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        editorViewModel = new ViewModelProvider(this).get(EditorViewModel.class);
        root = inflater.inflate(R.layout.fragment_editor, container, false);

        final EditText lyricsEditText = root.findViewById(R.id.lyrics_edit_text);

        editorViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                lyricsEditText.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.d("EditorFragment", "onActivityCreated: EditorFragment");
        super.onActivityCreated(savedInstanceState);
        //homeViewModel.loadSong("");
        clEditor = (ConstraintLayout) root.findViewById(R.id.cl_editor);
        setButtons();
    }

    public void setButtons() {
        int numLines = editorViewModel.getSong().getNumLines();
        ConstraintLayout.LayoutParams params =
                (ConstraintLayout.LayoutParams) root.findViewById(R.id.top_add_chord_button).getLayoutParams();
        // start at 1 because first button is always there with tag "0"
        for (int i = 1; i < numLines; i++) {
            // each button has to have new layout params
            ConstraintLayout.LayoutParams newParams = makeLayoutParams(params, i);
            // setup the button
            ImageButton button = makeButton(i);
            // add a new button to each line
            clEditor.addView(button, -1, newParams);
        }
    }

    private ConstraintLayout.LayoutParams makeLayoutParams(ConstraintLayout.LayoutParams baseParams, int position) {
        ConstraintLayout.LayoutParams newParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        newParams.topMargin = baseParams.topMargin;
        newParams.endToEnd = baseParams.endToEnd;
        newParams.startToStart = baseParams.startToStart;
        // need to be top constrained to the bottom of the button above it
        String previousTag = "" + (position-1) ;
        newParams.topToBottom = (root.findViewWithTag(previousTag)).getId();
        return newParams;
    }

    private ImageButton makeButton(int position) {
        ImageButton button = new ImageButton(this.getContext());
        button.setId(View.generateViewId());
        button.setBackgroundResource(R.drawable.ic_round_add_24);
        button.setTag("" + position);
        return button;
    }
}