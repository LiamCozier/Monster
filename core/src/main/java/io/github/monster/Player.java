package io.github.monster;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;

public class Player extends Entity {
    private int collected_gold;


    Player(int x_pos, int y_pos) {
        super(x_pos, y_pos, Color.PINK);
        collected_gold = 0;
    }

    public boolean take_input(int grid_size) {
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            x_pos-=1;
        }if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            x_pos+=1;
        }if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            y_pos+=1;
        }if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            y_pos-=1;
        }

        x_pos = clamp(x_pos, 0, grid_size-1);
        y_pos = clamp(y_pos, 0, grid_size-1);
    }

    private int clamp(int val, int min, int max) {
        return Math.max(min, Math.min(max, val));
    }

    public void collect_gold() {
        collected_gold++;
    }

}
