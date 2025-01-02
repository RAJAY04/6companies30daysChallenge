public class OverLapCircleAndRectangles {
    public static void main(String[] args) {
        OverLapCircleAndRectangles obj = new OverLapCircleAndRectangles();
        System.out.println(obj.checkOverlap(1, 0, 0, 1, -1, 3, 1));
    }

    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearestX = Math.max(x1,Math.min(x2,xCenter));
        int nearestY = Math.max(y1,Math.min(y2,yCenter));

        int xDist = Math.abs(nearestX - xCenter);
        int yDist = Math.abs(nearestY - yCenter);

        return xDist * xDist + yDist * yDist <= radius * radius;
    }
}
