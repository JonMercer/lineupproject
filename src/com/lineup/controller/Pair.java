package controller;

import java.util.Objects;

/**
 * Created by Jon Mercer on 15-07-30.
 */
public class Pair<X, Y> extends Object{

    private final X left;
    private final Y right;

    public Pair(X left, Y right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "(" + left + "," + right + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Pair)) {
            return false;
        }
        Pair<X, Y> other_ = (Pair<X, Y>) other;
        return Objects.equals(other_.left, this.left) && Objects.equals(other_.right, this.right);
    }

    @Override
    public int hashCode() {
        final int prime = 13;
        int result = 1;
        result = prime * result + ((left == null) ? 0 : left.hashCode());
        result = prime * result + ((right == null) ? 0 : right.hashCode());
        return result;
    }

    public X getLeft() {
        return left;
    }

    public Y getRight() {
        return right;
    }

}
