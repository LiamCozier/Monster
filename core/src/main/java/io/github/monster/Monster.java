package io.github.monster;

import com.badlogic.gdx.graphics.Color;

public class Monster extends Entity {
    public static final int SLEEPING = 0;
    public static final int HUNTING = 1;

    private int state;

    Monster(int x_pos, int y_pos) {
        super(x_pos, y_pos, Color.PURPLE);
        state = SLEEPING;
    }

    public void set_state(int state) {
        this.state = state;
    }
}
