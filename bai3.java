import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class bai3 {

    public static int orientation(Point p, Point q, Point r) {
        int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);
        if (val == 0) return 0;  
        return (val > 0) ? 1 : 2; 
    }

    public static List<Point> convexHull(Point points[], int n) {
        List<Point> hull = new ArrayList<>();

        int l = 0;
        for (int i = 1; i < n; i++) {
            if (points[i].x < points[l].x) {
                l = i;
            }
        }

        int p = l, q;
        do {
            hull.add(points[p]);
            q = (p + 1) % n;

            for (int i = 0; i < n; i++) {
                if (orientation(points[p], points[i], points[q]) == 2) {
                    q = i;
                }
            }

            p = q;

        } while (p != l);

        return hull;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            points[i] = new Point(x, y);
        }
        sc.close();
        List<Point> hull = convexHull(points, n);

        System.out.println("The points in the Convex Hull are:");
        for (Point temp : hull) {
            System.out.println(temp.x + " " + temp.y);
        }
    }
}