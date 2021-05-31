/**
 * @file: OffByN.java
 * @time: 2021/5/31 2:09 PM
 * @Author by Pking
 */
public class OffByN implements CharacterComparator {
    private int N;

    public OffByN(int N) {
        this.N = N;
    }

    @Override
    public boolean equalChars(char a, char b) {
        if (Math.abs(a - b) == N) {
            return true;
        }
        return false;
    }
}
