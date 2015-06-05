package peter;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class _149_Max_Points_on_a_Line{
	
	 public int maxPoints(Point[] points) {
	        int length = points.length;
	        int result = 0;
	        for (int i = 0; i < length; ++i) {
	            int same = 0;
	            int zero = 1;
	            HashMap<Double, Integer> map = new HashMap<Double, Integer>();
	            for (int j = i + 1; j < length; ++j) {
	                if (points[i].x == points[j].x && points[i].y == points[j].y) {
	                    same++;
	                } else if (points[i].x == points[j].x) {
	                    zero++;
	                } else {
	                    double slope = (points[i].y - points[j].y) * 1.0 / (points[i].x - points[j].x);
	                    if ((points[i].y - points[j].y) == 0) slope = 0.0;
	                    if (!map.containsKey(slope)) map.put(slope, 1);
	                    map.put(slope, map.get(slope) + 1);
	                }
	            }
	            int max = 1;
	            for (Map.Entry<Double, Integer> e : map.entrySet()) {
	                if (max < e.getValue()) {
	                    max = e.getValue();
	                }
	            }
	            max += same;
	            if (max > result) {
	                result = max;
	            }
	            if (zero > result) {
	                result = zero;
	            }
	        }
	        return result;
	    }
}