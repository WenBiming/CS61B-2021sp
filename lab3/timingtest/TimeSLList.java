package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        final int M = 10000;

        AList<Integer> Nlst = new AList<>();
        for (int i = 1000; i <= 128000; i *= 2)
            Nlst.addLast(i);

        AList<Double> times = new AList<>();
        for (int i = 0; i < Nlst.size(); i += 1) {
            int n = Nlst.get(i);
            SLList<Integer> testList = new SLList<>();
            while (n != 0) {
                testList.addLast(1);
                n -= 1;
            }
            Stopwatch sw = new Stopwatch();
            for (int j = 1; j <= M; j += 1)
                testList.getLast();
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }

        AList<Integer> ops = new AList<>();
        for (int i = 0; i < Nlst.size(); i ++)
            ops.addLast(M);

        printTimingTable(Nlst, times, ops);
    }

}
