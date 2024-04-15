import java.util.concurrent.SynchronousQueue;

public class Sort extends Thread {
    SynchronousQueue<Integer> O = new SynchronousQueue<Integer>();
    int N;
    SynchronousQueue<Integer> I = new SynchronousQueue<Integer>();
    int i;
    int[] Res;

    public Sort(int i, SynchronousQueue<Integer> I, SynchronousQueue<Integer> O, int N) {
        this.i = i;
        this.I = I;
        this.O = O;
        this.N = N;
        Res = new int[N];
    }

    @Override
    public void run() {
        int min;
        if (i == 0) {
            int[] tab = {12, 0, 5, 8, 3};
            min = tab[0];
            for (int j = 1; j < N; j++) {
                if (tab[j] < min) {
                    try {
                        O.put(min);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    min = tab[j];
                } else {
                    try {
                        O.put(tab[i]);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

            }
            Res[i] = min;
        }
    }
}