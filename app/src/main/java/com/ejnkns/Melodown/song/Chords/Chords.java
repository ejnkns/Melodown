package com.ejnkns.Melodown.song.Chords;

import java.util.ArrayList;

public class Chords {
    // so the Chords contain an array of ChordLines,
    // which represent the chords for a line of lyrics
    private ArrayList<ChordLine> chords;

    public Chords() {
        this.chords = new ArrayList<ChordLine>();
    }

    public Chords(ArrayList<ChordLine> chords) {
        this.chords = chords;
    }

    public void addChordLine(ChordLine cLine) {
        chords.add(cLine);
    }

    private class ChordLine {
        private ArrayList<String> cLine;

        public ChordLine() {
            cLine = new ArrayList<String>();
        }

        public ChordLine(ArrayList<String> cLine) {
            this.cLine = cLine;
        }

        public void addChord(int index, String chord) {
            cLine.add(index, chord);
        }
    }

    private class Chord {
        private RootNote rootNote;      //Eg. C
        private Modifier modifier;      //Eg. Sharp
        private Quality quality;        //Eg. Major
        private Extensions extensions;  //Eg. 7
        private Alterations alterations;//Eg. sharp five
        private String chordText;       //Eg. C#7

        private String makeChordText() {
            String chordText = "";

            return chordText;
        }

        public Chord(
                RootNote rootNote,
                Modifier modifier,
                Quality quality,
                Extensions extensions,
                Alterations alterations) {
            this.rootNote = rootNote;
            this.modifier = modifier;
            this.quality = quality;
            this.extensions = extensions;
            this.alterations = alterations;
            this.chordText = makeChordText();
            }
        }
    }

