package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> Nlst = new AList<>();
        for (int i = 1000; i <= 128000; i *= 2)
            Nlst.addLast(i);

        AList<Double> times = new AList<>();
        for (int i = 0; i < Nlst.size(); i ++) {
            int n = Nlst.get(i);
            AList<Integer> testList = new AList<>();
            Stopwatch sw = new Stopwatch();
            while (n != 0) {
                testList.addLast(1);
                n -= 1;
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
        }

        printTimingTable(Nlst, times, Nlst);
    }
}
