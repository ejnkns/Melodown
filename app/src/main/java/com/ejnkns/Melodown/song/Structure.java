package com.ejnkns.Melodown.song;

import java.util.ArrayList;

public class Structure {
    private ArrayList<Section> sections;

    public Structure() {
        sections = new ArrayList<Section>();
    }

    public Structure(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public void addSection(Section section) {
        sections.add(section);
    }
}
