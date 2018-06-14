package ru.tilman.controller;

import ru.tilman.entity.Chamber;

import java.util.List;

public class ChamberAjax {

    private List<Chamber> chambers;

    public List<Chamber> getChambers() {
        return chambers;
    }

    public void setChambers(List<Chamber> chambers) {
        this.chambers = chambers;
    }
}
