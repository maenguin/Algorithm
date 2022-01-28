package kakao.blind2022;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/92343
//노션 링크 : https://delirious-sock-4dc.notion.site/108e3038690e4edbb4799e836899285c
//문제 유형 : 게임이론
//풀이 방법 : DFS, minimax
public class 사라지는발판 {

    private int[] dx = {-1, 0, 0, 1};
    private int[] dy = {0, -1, 1, 0};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        Result result = doA(board, aloc, bloc, 0);
        return result.move;
    }

    private Result doA(int[][] board, int[] aloc, int[] bloc, int depth) {
        if (board[aloc[0]][aloc[1]] == 0) {
            return new Result(false, depth);
        }
        boolean canMove = false;
        boolean canWin = false;
        int minMove = (int) 1e9, maxMove = 0;
        for (int i = 0; i < 4; i++) {
            int nx = aloc[0] + dx[i];
            int ny = aloc[1] + dy[i];
            if (0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length && board[nx][ny] != 0) {
                canMove = true;
                int[] newloc = {nx, ny};
                board[aloc[0]][aloc[1]] = 0;
                Result result = doB(board, newloc, bloc, depth + 1);
                canWin |= !result.win;
                if (result.win) {
                    maxMove = Math.max(maxMove, result.move);
                } else {
                    minMove = Math.min(minMove, result.move);
                }
                board[aloc[0]][aloc[1]] = 1;
            }
        }
        if (!canMove) {
            return new Result(false, depth);
        }
        return new Result(canWin, canWin ? minMove : maxMove);
    }

    private Result doB(int[][] board, int[] aloc, int[] bloc, int depth) {
        if (board[bloc[0]][bloc[1]] == 0) {
            return new Result(false, depth);
        }
        boolean canMove = false;
        boolean canWin = false;
        int minMove = (int) 1e9, maxMove = 0;
        for (int i = 0; i < 4; i++) {
            int nx = bloc[0] + dx[i];
            int ny = bloc[1] + dy[i];
            if (0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length && board[nx][ny] != 0) {
                canMove = true;
                int[] newloc = {nx, ny};
                board[bloc[0]][bloc[1]] = 0;
                Result result = doA(board, aloc, newloc, depth + 1);
                canWin |= !result.win;
                if (result.win) {
                    maxMove = Math.max(maxMove, result.move);
                } else {
                    minMove = Math.min(minMove, result.move);
                }
                board[bloc[0]][bloc[1]] = 1;
            }
        }
        if (!canMove) {
            return new Result(false, depth);
        }
        return new Result(canWin, canWin ? minMove : maxMove);
    }

    private Result doGame(int[][] board, int[] aloc, int[] bloc, int depth) {
        if (board[aloc[0]][aloc[1]] == 0) {
            return new Result(false, depth);
        }
        boolean canMove = false;
        boolean canWin = false;
        int minMove = (int) 1e9, maxMove = 0;
        for (int i = 0; i < 4; i++) {
            int nx = aloc[0] + dx[i];
            int ny = aloc[1] + dy[i];
            if (0 <= nx && nx < board.length && 0 <= ny && ny < board[0].length && board[nx][ny] != 0) {
                canMove = true;
                int[] newloc = {nx, ny};
                board[aloc[0]][aloc[1]] = 0;
                Result result = doGame(board, bloc, newloc, depth + 1);
                canWin |= !result.win;
                if (result.win) {
                    maxMove = Math.max(maxMove, result.move);
                } else {
                    minMove = Math.min(minMove, result.move);
                }
                board[aloc[0]][aloc[1]] = 1;
            }
        }
        if (!canMove) {
            return new Result(false, depth);
        }
        return new Result(canWin, canWin ? minMove : maxMove);
    }

    private static class Result {
        boolean win;
        int move;

        public Result(boolean win, int move) {
            this.win = win;
            this.move = move;
        }
    }
}
