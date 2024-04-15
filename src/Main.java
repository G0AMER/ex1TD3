import java.util.concurrent.SynchronousQueue;



public class Main {

    public static void main(String[] args) {

        // 1 : créer le pipeline

        int N = 10;

        Sort pipeline[] = new Sort[N];

        // préparation des cannaux

        SynchronousQueue<Integer> I = new SynchronousQueue<Integer>();

        SynchronousQueue<Integer> O = new SynchronousQueue<Integer>();

        for (int i = 0; i < N; i++) {

            pipeline[i] = new Sort(i, I, O, N);

            I = O;

            O = new SynchronousQueue<Integer>();

            pipeline[i].start();

        }

    }

}