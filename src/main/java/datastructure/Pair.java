package datastructure;

public class Pair<S, T> {
    private final S left;
    private final T right;

    private Pair(S left, T right) {
        this.left = left;
        this.right = right;
    }

    public static <S, T> Pair<S, T> of(S left, T right) {
        return new Pair<>(left, right);
    }

    public S getLeft() {
        return left;
    }

    public T getRight() {
        return right;
    }
}
