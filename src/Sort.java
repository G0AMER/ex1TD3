import java.util.concurrent.SynchronousQueue;

public class Sort extends Thread {

    private static int[] res;
    private final SynchronousQueue<Integer> I;
    private final SynchronousQueue<Integer> O;
    private final int index;
    private final int N;


    Sort(int index, SynchronousQueue<Integer> I, SynchronousQueue<Integer> O, int N) {

        this.I = I;

        this.O = O;

        this.index = index;

        this.N = N;

        res = new int[N];

    }


    @Override

    public void run() {

        try {

            // definition du minimum

            int min;


            // definition du tableau

            int[] tab = {12, 0, 5, 8, 3, 15, 20, 1, 13, 17};


            // cas1: index = 0

            if (index == 0) {

                min = tab[0];

                for (int i = 1; i < N; i++) {

                    if (tab[i] < min) {


                        O.put(min);


                        min = tab[i];

                    } else {

                        O.put(tab[i]);


                    }

                }

                res[0] = min;

            }


            // cas2 : tous les threads sauf le dernier

            else if (index > 0 && index < N - 1) {

                min = I.take();


                for (int i = 1; i < N - index; i++) {

                    int k = I.take();

                    if (k < min) {

                        O.put(min);

                        min = k;

                    } else {

                        O.put(k);

                    }

                    res[index] = min;

                }


            }


            // cas3: index = n-1

            else {

                min = I.take();

                res[index] = min;

                for (int i = 0; i < N; i++) {

                    System.out.println(res[i]);

                }

            }


        } catch (InterruptedException e) {


        }

    }

}
