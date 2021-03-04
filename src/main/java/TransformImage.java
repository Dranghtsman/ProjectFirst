import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgproc.Imgproc.INTER_AREA;
import static org.opencv.imgproc.Imgproc.resize;


public class TransformImage {


    public static void resizeImage(String file,int width, int height) {
        // load library OpenCv
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat path = imread(file);
        Size scaleSize = new Size(width, height);
        Mat resizeimage = new Mat();
        resize(path, resizeimage, scaleSize, 0, 0, INTER_AREA); //resize image;
        Imgcodecs.imwrite(file, resizeimage);
        System.out.println("Done Image Resize");

    }

    public static void convertToGray(String file) {

        // load library OpenCv
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat image = Imgcodecs.imread(file);
        Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2GRAY); // convert the image in gray scale
        Imgcodecs.imwrite(file, image); //write gray image to file
        System.out.println("Done Image convert to Gray");

    }


}


