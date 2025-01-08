package io.github.monster;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.awt.*;

public class Entity {
    public int x_pos,y_pos;
    public Color color;

    Entity(int x_pos, int y_pos, Color color) {
        this.x_pos = x_pos;
        this.y_pos = y_pos;
        this.color = color;
    }

    public void draw(ShapeRenderer sr, int square_size, int square_spacing) {
        int square_offset = square_size + square_spacing;

        sr.setColor(this.color);
        sr.rect(x_pos * square_offset + ((float) square_spacing/2), y_pos * square_offset + ((float) square_spacing/2), square_size, square_size);
    }

    protected int sign_of(int n) {
        return n / Math.abs(n);
    }

    protected int clamp_int(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }
}
