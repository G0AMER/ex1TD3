import java.util.concurrent.SynchronousQueue;

public class Main {
    public static void main(String[] args) {
        //1ère étape :créer le pipeline (tab de sort de taille fixe)
        int N = 5;
        Sort[] pipeline = new Sort[N];
        SynchronousQueue<Integer> I = new SynchronousQueue<Integer>();
        SynchronousQueue<Integer> O = new SynchronousQueue<Integer>();
        for (int i = 0; i < N; i++) {
            pipeline[i] = new Sort(i, I, O, N);
            I = O;
            SynchronousQueue<Integer> O = new SynchronousQueue<Integer>();
            pipeline[i].start();
        }
    }
}