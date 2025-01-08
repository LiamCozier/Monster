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

    public int get_state() {return state;}

    public void move_towards(Entity e, int grid_size) {
        int x_disp = e.x_pos-this.x_pos;
        int x_dist = Math.abs(x_disp);
        int y_disp = e.y_pos-this.y_pos;
        int y_dist = Math.abs(y_disp);

        if (x_disp==0 || y_disp==0) {
            return;
        }

        if (x_dist<y_dist) {
            this.x_pos += sign_of(x_disp);
            System.out.println(sign_of(x_disp));
        } else {
            this.y_pos += sign_of(y_disp);
        }

        this.x_pos = clamp_int(this.x_pos, 0, grid_size-1);
        this.y_pos = clamp_int(this.y_pos, 0, grid_size-1);

    }
}
