import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Interval class to represent each interval [start, end]
class Interval {
    int start;
    int end;
    
    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class MergeIntervals {

    // Function to merge overlapping intervals
    public static List<Interval> mergeIntervals(List<Interval> intervals) {
        // If intervals is empty or has only one interval, return it as is
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        // Sort intervals based on the start time
        intervals.sort(Comparator.comparingInt(i -> i.start));
        
        List<Interval> mergedIntervals = new ArrayList<>();
        Interval currentInterval = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval nextInterval = intervals.get(i);
            
            // Check for overlapping intervals
            if (currentInterval.end >= nextInterval.start) {
                // Merge the intervals
                currentInterval.end = Math.max(currentInterval.end, nextInterval.end);
            } else {
                // No overlap, add currentInterval to merged list and update currentInterval
                mergedIntervals.add(currentInterval);
                currentInterval = nextInterval;
            }
        }
        
        // Add the last remaining interval
        mergedIntervals.add(currentInterval);
        
        return mergedIntervals;
    }
    
    // Helper method to print intervals
    public static void printIntervals(List<Interval> intervals) {
        System.out.print("[");
        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);
            System.out.print("[" + interval.start + ", " + interval.end + "]");
            if (i < intervals.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        // Example 1
        List<Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Interval(1, 3));
        intervals1.add(new Interval(2, 4));
        intervals1.add(new Interval(6, 8));
        intervals1.add(new Interval(9, 10));
        
        System.out.println("Input intervals:");
        printIntervals(intervals1);
        
        List<Interval> mergedIntervals1 = mergeIntervals(intervals1);
        
        System.out.println("Merged intervals:");
        printIntervals(mergedIntervals1);
        
        // Example 2
        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(6, 8));
        intervals2.add(new Interval(1, 9));
        intervals2.add(new Interval(2, 4));
        intervals2.add(new Interval(4, 7));
        
        System.out.println("\nInput intervals:");
        printIntervals(intervals2);
        
        List<Interval> mergedIntervals2 = mergeIntervals(intervals2);
        
        System.out.println("Merged intervals:");
        printIntervals(mergedIntervals2);
    }
}
/*Input intervals:
[[1, 3], [2, 4], [6, 8], [9, 10]]
Merged intervals:
[[1, 4], [6, 8], [9, 10]]

Input intervals:
[[6, 8], [1, 9], [2, 4], [4, 7]]
Merged intervals:
[[1, 9]]*/

