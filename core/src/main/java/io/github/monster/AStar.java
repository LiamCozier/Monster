package io.github.monster;

public class AStar {
    int grid_size;
    int[][] path;
    int end_of_path;

    AStar(int grid_size) {
        this.grid_size = grid_size;
        path = new int[grid_size*grid_size][2];
        end_of_path = 0;
    }

    private boolean is_within_bounds(int x, int y) {
        return !(x<0 || x>=grid_size || y<0 || y>=grid_size);
    }

    private int[][] adjacent_points() {
        int[][] points = new int[4][2];
        int counter = 0;
        for (int i=-1; i<=1; i+=2) {
            for (int j=-1; j<=1; j+=2) {
                points[counter] = new int[]{i, j};
                counter++;
            }
        }
        return points;
    }

    private int distance_squared(int x1, int y1, int x2, int y2) {
        return Math.abs(x1-x2) + Math.abs(y1-y2);
    }

    public void calculate_path(int x1, int y1, int x2, int y2) {
        int h_cost;
        int g_cost;
        int f_cost;

        int[] lowest_cost = {-1, -1, -1};
        while(x1==x2 && y1==y2) { // not at target position

            // find cheapest adjacent point
            for (int[] point: adjacent_points()) {

                if (!is_within_bounds(point[0], point[1])) {
                    continue;
                }

                h_cost = distance_squared(point[0], point[1], x1, y1);
                g_cost = distance_squared(point[0], point[1], x2, y2);
                f_cost = h_cost+g_cost;

                if (f_cost<lowest_cost[3]) {
                    lowest_cost[0] = point[0];
                    lowest_cost[1] = point[1];
                    lowest_cost[3] = f_cost;
                }
            }

            
        }
    }

}
