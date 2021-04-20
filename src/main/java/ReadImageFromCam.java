import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.*;

public class ReadImageFromCam {

        public static void main(String[] args) {
            System.loadLibrary("opencv_java430");
            VideoCapture cap = new VideoCapture();
            cap.open(0);
            if (!cap.isOpened()) {
                System.out.println("Cam offline");
            } else System.out.println("Cam online" + cap.toString());
            Mat frame = new Mat();
            cap.read(frame);
            Imgcodecs.imwrite("d:/projectFirst/src/main/resources/knot.jpg",frame);
            cap.release();

        }
}
