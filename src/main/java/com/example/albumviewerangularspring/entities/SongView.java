package com.example.albumviewerangularspring.entities;

import lombok.Getter;

@Getter
public class SongView {
    private String name;
    private Integer duration;
    private Integer position;

    public SongView(){};

    public SongView(String name, Integer duration, Integer position) {
        this.name = name;
        this.duration = duration;
        this.position = position;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }
}
