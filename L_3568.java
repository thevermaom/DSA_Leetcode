import java.util.*;

public class L_3568 {
    public int minMoves(String[] classroom, int maxEnergy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startX = -1, startY = -1;
        int litterCount = 0;
        int[][] litterIndex = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            Arrays.fill(litterIndex[i], -1);
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startX = i;
                    startY = j;
                } else if (c == 'L') {
                    litterIndex[i][j] = litterCount++;
                }
            }
        }
        
        // If there's no litter to collect, 0 moves needed.
        if (litterCount == 0) {
            return 0;
        }
        
        int targetMask = (1 << litterCount) - 1;
        
        // Queue state: {x, y, currentEnergy, collectedMask}
        Queue<int[]> queue = new LinkedList<>();
        
        // Visited array: visited[x][y][energy][mask]
        boolean[][][][] visited = new boolean[m][n][maxEnergy + 1][1 << litterCount];
        
        // Initial state at 'S'
        queue.offer(new int[]{startX, startY, maxEnergy, 0});
        visited[startX][startY][maxEnergy][0] = true;
        
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int moves = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int x = curr[0];
                int y = curr[1];
                int energy = curr[2];
                int mask = curr[3];
                
                // If all litter items are collected, return total moves
                if (mask == targetMask) {
                    return moves;
                }
                
                // If energy is 0, student cannot move further
                if (energy == 0) {
                    continue;
                }
                
                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                        char cell = classroom[nx].charAt(ny);
                        
                        // Skip obstacles
                        if (cell == 'X') {
                            continue;
                        }
                        
                        int nextEnergy = energy - 1;
                        int nextMask = mask;
                        
                        // If cell is a Reset Area 'R', refill energy to full
                        if (cell == 'R') {
                            nextEnergy = maxEnergy;
                        }
                        
                        // If cell is Litter 'L', update collection bitmask
                        if (cell == 'L') {
                            int idx = litterIndex[nx][ny];
                            nextMask |= (1 << idx);
                        }
                        
                        if (!visited[nx][ny][nextEnergy][nextMask]) {
                            visited[nx][ny][nextEnergy][nextMask] = true;
                            queue.offer(new int[]{nx, ny, nextEnergy, nextMask});
                        }
                    }
                }
            }
            moves++;
        }
        
        return -1;
    }
}