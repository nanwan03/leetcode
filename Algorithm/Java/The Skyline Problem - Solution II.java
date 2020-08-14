public class Solution {
    private static class Rectangle {
        public int left, right, height;
    
        public Rectangle(int left, int right, int height) {
          this.left = left;
          this.right = right;
          this.height = height;
        }
    }
    private static class Ref<T> {
    	  public T value;

    	  public Ref(T v) {
    	    value = v;
    	  }
    }
    private static class Node {
        public int x;
        public int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private class NodeComparator implements Comparator<Node> {
        public int compare(Node a, Node b) {
            if (a.x == b.x) {
                return b.y - a.y;
            }
            return a.x - b.x;
        }
    }
    public List<int[]> getSkyline(int[][] buildings) {
        // write your code here
        if (buildings == null || buildings.length == 0) {
            return new ArrayList<int[]>();
        }
        List<Rectangle> list = new ArrayList<Rectangle>();
        for (int i = 0; i < buildings.length; i++) {
            list.add(new Rectangle(buildings[i][0], buildings[i][1], buildings[i][2]));
        }
        List<Rectangle> rst = computeSkylineInInterval(list, 0, list.size());
        List<int[]> output = new ArrayList<int[]>();
        int lastEnd = -1;
        for (Rectangle r : rst) {
            if (lastEnd != -1 && lastEnd < r.left) {
                output.add(new int[]{lastEnd, 0});
            }
            output.add(new int[]{r.left, r.height});
            lastEnd = r.right;
        }
        if (lastEnd != -1) {
            output.add(new int[]{lastEnd, 0});
        }
        return output;
    }
    private static List<Rectangle> computeSkylineInInterval( List<Rectangle> buildings, int leftEndpoint, int rightEndpoint) {
        if (rightEndpoint - leftEndpoint <= 1) { // 0 or 1 skyline, just copy it.
          return new ArrayList<>(buildings.subList(leftEndpoint, rightEndpoint));
        }
        int mid = leftEndpoint + ((rightEndpoint - leftEndpoint) / 2);
        List<Rectangle> leftSkyline 
            = computeSkylineInInterval(buildings, leftEndpoint, mid);
        List<Rectangle> rightSkyline 
            = computeSkylineInInterval(buildings, mid, rightEndpoint);
        return mergeSkylines(leftSkyline, rightSkyline);
    }

  private static List<Rectangle> mergeSkylines(List<Rectangle> leftSkyline, 
                                               List<Rectangle> rightSkyline) {
        int i = 0, j = 0;
        List<Rectangle> merged = new ArrayList<>();
    
        while (i < leftSkyline.size() && j < rightSkyline.size()) {
          if (leftSkyline.get(i).right < rightSkyline.get(j).left) {
            merged.add(leftSkyline.get(i++));
          } else if (rightSkyline.get(j).right < leftSkyline.get(i).left) {
            merged.add(rightSkyline.get(j++));
          } else if (leftSkyline.get(i).left <= rightSkyline.get(j).left) {
            Ref<Integer> iWrapper = new Ref<Integer>(i);
            Ref<Integer> jWrapper = new Ref<Integer>(j);
            mergeIntersectSkylines(merged, leftSkyline.get(i), iWrapper, rightSkyline.get(j), jWrapper);
            i = iWrapper.value;
            j = jWrapper.value;
          } else { // leftSkyline.get(i).left > rightSkyline.get(j).left.
            Ref<Integer> iWrapper = new Ref<>(i);
            Ref<Integer> jWrapper = new Ref<>(j);
            mergeIntersectSkylines(merged, rightSkyline.get(j), jWrapper, leftSkyline.get(i), iWrapper);
            i = iWrapper.value;
            j = jWrapper.value;
          }
        }
        merged.addAll(leftSkyline.subList(i, leftSkyline.size()));
        merged.addAll(rightSkyline.subList(j, rightSkyline.size()));
        return merged;
  }

  private static void mergeIntersectSkylines(List<Rectangle> merged, Rectangle a,
                                             Ref<Integer> aIdx, Rectangle b,
                                             Ref<Integer> bIdx) {
        if (a.right <= b.right) {
          if (a.height > b.height) {
            if (b.right != a.right) {
              merged.add(a);
              aIdx.value = aIdx.value + 1;
              b.left = a.right;
            } else {
              bIdx.value = bIdx.value + 1;
            }
          } else if (a.height == b.height) {
            b.left = a.left;
            aIdx.value = aIdx.value + 1;
          } else { // a->height < b->height.
            if (a.left != b.left) {
              merged.add(new Rectangle(a.left, b.left, a.height));
            }
            aIdx.value = aIdx.value + 1;
          }
        } else { // a.right > b.right.
          if (a.height >= b.height) {
            bIdx.value = bIdx.value + 1;
          } else {
            if (a.left != b.left) {
              merged.add(new Rectangle(a.left, b.left, a.height));
            }
            a.left = b.right;
            merged.add(b);
            bIdx.value = bIdx.value + 1;
          }
      }
  }
}