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
        boolean moved = false;
        if (Gdx.input.isKeyJustPressed(Input.Keys.LEFT)) {
            x_pos-=1;
            moved = true;
        }if (Gdx.input.isKeyJustPressed(Input.Keys.RIGHT)) {
            x_pos+=1;
            moved = true;
        }if (Gdx.input.isKeyJustPressed(Input.Keys.UP)) {
            y_pos+=1;
            moved = true;
        }if (Gdx.input.isKeyJustPressed(Input.Keys.DOWN)) {
            y_pos-=1;
            moved = true;
        }

        x_pos = clamp_int(x_pos, 0, grid_size-1);
        y_pos = clamp_int(y_pos, 0, grid_size-1);

        return moved;
    }

    public void collect_gold() {
        collected_gold++;
    }

}
