package io.github.monster;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import org.w3c.dom.css.RGBColor;

public class World {
    Player player;
    int[][] grid;
    int[] grid_dimensions = {16, 16};
    int square_spacing = 7;
    int square_size = (640/grid_dimensions[1])-square_spacing;


    World() {
        grid = new int[grid_dimensions[0]][grid_dimensions[1]];
        player = new Player(4, 4);
    }

    public void update() {
        player.take_input(grid_dimensions);
    }

    public void draw(ShapeRenderer sr) {

        int square_offset = square_size + square_spacing;

        for (int i=0; i<grid_dimensions[0]; i++) {
            for (int j=0; j<grid_dimensions[1]; j++) {
                Color background_color = new Color(0.2f, 0.2f, 0.27f, 1f);
                sr.setColor(background_color);
                sr.rect(i * square_offset + ((float) square_spacing/2), j * square_offset + ((float) square_spacing/2), square_size, square_size);
            }
        }

        player.draw(sr, square_size, square_spacing);
    }
}
