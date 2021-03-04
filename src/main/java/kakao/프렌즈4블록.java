package kakao;


import java.util.*;

//2018 KAKAO BLIND RECRUITMENT
public class 프렌즈4블록 {

    public int solution(int m, int n, String[] board) {
        int answer = 0;

        Character[][] board2D = get2DArr(m, n, board);
        List<List<Character>> boardList = get2DList(m, n, board2D);

        int[] dx = {0,0,1,1};
        int[] dy = {0,1,0,1};

        Set<Block> blockSet = new TreeSet<>();

        do {
            blockSet.clear();
            for (int i = 0; i < boardList.size() -1; i++) {
                for (int j = 0; j < boardList.get(i).size() -1; j++) {
                    Character c = boardList.get(i).get(j);

                    if (boardList.get(i+1).size() >= j+2 && c.equals(boardList.get(i).get(j + 1)) && c.equals(boardList.get(i + 1).get(j)) && c.equals(boardList.get(i + 1).get(j + 1))) {
                        for (int k = 0; k < 4; k++)
                            blockSet.add(new Block(i+dx[k], j + dy[k], c));
                    }
                }
            }
            answer += blockSet.size();

            for (Block block : blockSet)
                boardList.get(block.x).remove(block.y);

        } while (!blockSet.isEmpty());



        return answer;
    }

    private List<List<Character>> get2DList(int m, int n, Character[][] board2D) {
        List<List<Character>> boardList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Character> list = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                list.add(board2D[m - j -1][i]);
            }
            boardList.add(list);
        }
        return boardList;
    }


    private Character[][] get2DArr(int m, int n, String[] board) {
        Character[][] board2D = new Character[m][n];

        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i].toCharArray();
            for (int j = 0; j < chars.length; j++) {
                board2D[i][j] = chars[j];
            }
        }
        return board2D;
    }

    static class Block implements Comparable<Block> {
        private int x;
        private int y;
        private Character c;

        public Block(int x, int y, Character c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Block block = (Block) o;
            return x == block.x &&
                    y == block.y &&
                    Objects.equals(c, block.c);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, c);
        }


        @Override
        public int compareTo(Block o) {
            return this.y > o.y ? -1 : this.y < o.y ? 1 : Integer.compare(this.x, o.x);
        }
    }

}
