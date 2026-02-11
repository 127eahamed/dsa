import java.util.HashSet;

public class SetOps_1_AEhan {
    public static <E> HashSet<E> union(HashSet<E> A, HashSet<E> B) {
        HashSet<E> hashSet = new HashSet<E>(A);
        hashSet.addAll(B);
        return hashSet;
    }
    public static <E> HashSet<E> intersection(HashSet<E> A, HashSet<E> B) {
        HashSet<E> hashSet = new HashSet<E>();
        for (E element : A) {
            if (B.contains(element)) {
                hashSet.add(element);
            }
        }
        return hashSet;
    }
    public static <E> HashSet<E> difference(HashSet<E> A, HashSet<E> B) {
        HashSet<E> hashSet = new HashSet<E>(A);
        hashSet.removeAll(B);
        return hashSet;
    }
}
