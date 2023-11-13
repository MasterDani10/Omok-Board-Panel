//import java.awt.*;
//
//public class ComputerLogicEasy {
//    Point p;
//    int x, y;
//    public ComputerLogicEasy(int x, int y){
//        this.x = x;
//        this.y = y;
//
//    }
//
//    public int getX(int i){
//
//    }
//
//    public Point getUpdatedPoint(int i){
//        if(i == 1) {
//            if (x == 14) {
//                return new Point(x-2,y);
//            } else {
//                return new Point(x+2,y);
//            }
//        }
//        else if(i == 2){
//            if (x == 0) {
//                return new Point(x+2,y);
//
//            } else {
//                return new Point(x-2,y);
//            }
//        }
//        else if(i == 3){
//            if (y == 14) {
//                return new Point(x,y-2);
//            } else {
//                return new Point(x,y+2);
//            }
//        }
//        else if(i == 4){
//            if (y == 0) {
//                return new Point(x,y+2);
//            } else {
//                return new Point(x,y-2);
//            }
//        }
//        else {
//            ComputerLogicRandom random = new ComputerLogicRandom();
//            return new Point(random.getRandom(), random.getRandom());
//        }
//    }
//}
