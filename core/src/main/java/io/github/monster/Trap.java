package io.github.monster;

import com.badlogic.gdx.graphics.Color;

public class Trap extends Entity{
    private boolean triggered;

    Trap(int x_pos, int y_pos) {
        super(x_pos, y_pos, Color.RED);
        triggered = false;
    }

    public void trigger() {
        this.triggered = true;
        this.color = Color.GRAY;
    }

    public boolean is_triggered() {
        return triggered;
    }
}
