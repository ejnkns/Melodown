package com.ejnkns.Melodown.ui.editor;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ejnkns.Melodown.song.Song;

public class EditorViewModel extends ViewModel {

    private MutableLiveData<String> mLyrics;
    private Song song;

    // TODO: store songs on the device
    private String data= "Somebody once told me\nthe world was gonna roll me\nI ain't the sharpest tool in the shed\nshe was lookin' kinda dumb\nwith her finger and her thumb\nin the shape of an 'L' on her forehead\nWELL\nthe years start coming\nand they don't stop coming\nfed to the rules and i hit the ground running\ndidn't make sense not to live for fun\nyour brain gets smart but your head gets dumb";

    public EditorViewModel() {
        mLyrics = new MutableLiveData<>();
        this.song = new Song();
        displayLyrics();
    }

    public LiveData<String> getText() {
        return mLyrics;
    }


    private void displayLyrics() {
        song.addLyrics(data);
        mLyrics.setValue(data);
    }

    private void getButtons() {

    }

    public Song getSong() {
        return song;
    }

}
