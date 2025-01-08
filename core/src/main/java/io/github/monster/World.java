package io.github.monster;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class World {

    int[][] grid;
    int grid_size = 10;
    int square_spacing = (128/grid_size);
    int square_size = (640/ grid_size)-square_spacing;

    Player player;
    Monster monster;
    Gold[] golds;
    Trap[] traps;


    World() {
        player = new Player(4, 4);
        monster = new Monster(6, 6);

        golds = new Gold[2];
        golds[0] = new Gold(2, 2);
        golds[1] = new Gold(4, 4);

        traps = new Trap[2];
        traps[0] = new Trap(3, 7);
        traps[1] = new Trap(9, 4);
    }

    public void update() {
        boolean just_moved = player.take_input(grid_size);

        monster.set_state(Monster.HUNTING);
        if (just_moved && monster.get_state()==Monster.HUNTING) {
            monster.move_towards(player, grid_size);
        }



        for (Gold g : golds) {
            if (g.collected) {
                continue;
            }
            if (player.x_pos == g.x_pos && player.y_pos == g.y_pos) {
                g.collect();
                player.collect_gold();
            }
        }

        for (Trap t: traps) {
            if (t.is_triggered()) {
                continue;
            }
            if (player.x_pos == t.x_pos && player.y_pos == t.y_pos) {
                t.trigger();
                monster.set_state(Monster.HUNTING);
            }
        }
    }

    public void draw(ShapeRenderer sr) {

        int square_offset = square_size + square_spacing;

        for (int i = 0; i< grid_size; i++) {
            for (int j = 0; j< grid_size; j++) {
                Color background_color = new Color(0.2f, 0.2f, 0.27f, 1f);
                sr.setColor(background_color);
                sr.rect(i * square_offset + ((float) square_spacing/2), j * square_offset + ((float) square_spacing/2), square_size, square_size);
            }
        }

        for (Gold g : golds) {g.draw(sr, square_size, square_spacing);}
        for (Trap t: traps) {t.draw(sr, square_size, square_spacing);}
        player.draw(sr, square_size, square_spacing);
        monster.draw(sr, square_size, square_spacing);

    }
}
