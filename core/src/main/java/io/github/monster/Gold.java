package io.github.monster;

import com.badlogic.gdx.graphics.Color;

public class Gold extends Entity{
    public boolean collected = false;

    Gold(int x_pos, int y_pos) {
        super(x_pos, y_pos, Color.GOLD);
    }

    public void collect() {
        this.collected = true;
        this.color = Color.GRAY;
    }

    public boolean is_collected() {
        return collected;
    }
}
