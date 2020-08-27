package com.ejnkns.Melodown.song;

import android.util.Log;

import com.ejnkns.Melodown.song.Chords.Chords;

public class Song {
    private Lyrics lyrics;
    private Chords chords;
    private Structure structure;
    private int numLines;

    public Song() {
        lyrics = new Lyrics();
        chords = new Chords();
        structure = new Structure();
        numLines = 0;
    }

    public Song(Lyrics lyrics, Chords chords, Structure structure) {
        this.lyrics = lyrics;
        this.chords = chords;
        this.structure = structure;
        // line up the chords and lyrics with structure

        // string position in chords determines the word it should be displayed above,
        // eg. chords[5] corresponds to the 5th words in lyricline
        // will figure out putting chords in whitespace later...
    }

    public void addLyrics(String input) {
        Log.d("Song", "addLyrics: " + input);
       lyrics.addLyrics(input);
    }
    /*
    public void addLyrics(String input, int position) {
        Log.d("Song", "\naddLyrics: " + input + "\nposition: " + position);
        lyrics.addLyrics(input, position);
    }
     */

    public void replaceLyrics(String input, int position) {
        lyrics.replaceLyrics(input, position);
    }

    public Lyrics getLyrics() {
        return lyrics;
    }

    public Lyrics.LyricLine getLyricLine(int position) {
        return lyrics.getLyricLine(position);
    }
    public void removeLyricLine(int position) {
        lyrics.removeLine(position);
    }

    public int getNumLines() {
        numLines = lyrics.getLyricLines().size();
        return numLines;
    }
}
