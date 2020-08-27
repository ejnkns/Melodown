package com.ejnkns.Melodown.song;

import android.util.Log;

import java.util.ArrayList;

public class Lyrics {
    private ArrayList<LyricLine> lyricLines;

    public Lyrics() {
        this.lyricLines = new ArrayList<LyricLine>();
    }

    public Lyrics(ArrayList<LyricLine> lyricLines) {
        this.lyricLines = lyricLines;
    }

    public Lyrics(String input) {
        this.lyricLines = new ArrayList<LyricLine>();
        addLyrics(input);
    }

    public void addLyricLine(LyricLine line, int position) {
        lyricLines.add(position, line);
    }

    public void addLyrics(String inputLyrics) {
        //check for newlines
        //add each line as a LyricLine to end of lyricLines
        for (String line : inputLyrics.split("\n")) {
            lyricLines.add(new LyricLine(line));
        }
    }

    public void replaceLyrics(String inputLyrics, int position) {
        // check for newlines?
        // add each line as a LyricLine to lyrics after the
        // specified position

        // make sure position is in bounds
        if(position < lyricLines.size()) {
            lyricLines.remove(position);
        } else {
            Log.d("Lyrics", "addLyrics: Oopsie! position out of bounds ;(\nposition: " + position + "\nsize: " + lyricLines.size());
        }
        lyricLines.add(position, new LyricLine(inputLyrics));
        Log.d("Lyrics", "lyricLines: \n" + lyricLines.toString());
    }

    public ArrayList<LyricLine> getLyricLines() {
        return lyricLines;
    }

    public LyricLine getLyricLine(int i) {
        return lyricLines.get(i);
    }

    public void removeLine(int position) {
        lyricLines.remove(position);
    }

    public class LyricLine {
        public String lyricLine;

        public LyricLine(String line) {
           this.lyricLine = line;
        }

        @Override
        public String toString() {
            return lyricLine;
        }
    }
}
