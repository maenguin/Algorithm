package kakao.blind._2020;

//문제 출처 : https://programmers.co.kr/learn/courses/30/lessons/60059
//노션 링크 : https://delirious-sock-4dc.notion.site/b2cff7bbd59942febbf1732d95d9f68b
//알고 리즘 : 구현
public class 자물쇠와열쇠 {

    private int[][] paddedLock;
    private int padding;

    public boolean solution(int[][] key, int[][] lock) {
        padding = (key.length - 1);
        paddedLock = new int[lock.length + padding * 2][lock.length + padding * 2];
        for (int i = 0; i < lock.length; i++) {
            System.arraycopy(lock[i], 0, paddedLock[padding + i], padding, lock.length);
        }
        for (int i = 0; i < 4; i++) {
            key = rotateR90(key);
            if (tryOpen(key)) {
                return true;
            }
        }
        return false;
    }

    private boolean tryOpen(int[][] key) {
        for (int i = 0; i < paddedLock.length - padding; i++) {
            for (int j = 0; j < paddedLock.length - padding; j++) {
                for (int k = 0; k < key.length; k++) {
                    for (int l = 0; l < key.length; l++) {
                        int dr = i + k;
                        int dc = j + l;
                        paddedLock[dr][dc] += key[k][l];
                    }
                }
                if (canOpen()) {
                    return true;
                }
                for (int k = 0; k < key.length; k++) {
                    for (int l = 0; l < key.length; l++) {
                        int dr = i + k;
                        int dc = j + l;
                        paddedLock[dr][dc] -= key[k][l];
                    }
                }
            }
        }
        return false;
    }

    private boolean canOpen() {
        boolean ok = true;
        for (int k = padding; k < paddedLock.length - padding; k++) {
            for (int l = padding; l < paddedLock.length - padding; l++) {
                if (paddedLock[k][l] != 1) {
                    ok = false;
                }
            }
        }
        return ok;
    }

    private static int[][] rotateR90(int[][] a) {
        int r = a.length;
        int c = a[0].length;
        int[][] ans = new int[c][r];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                ans[i][j] = a[r - 1 - j][i];
            }
        }
        return ans;
    }

}
