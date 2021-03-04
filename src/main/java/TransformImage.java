import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgproc.Imgproc.INTER_AREA;
import static org.opencv.imgproc.Imgproc.resize;


public class TransformImage {




    public static void resizeImage(String file) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat path = imread(file);
        Mat resizeimage = new Mat();
        Size scaleSize = new Size(50, 50);
        resize(path, resizeimage, scaleSize, 0, 0, INTER_AREA);
        Imgcodecs.imwrite(file, resizeimage);
        System.out.println("Done Image Resize");

    }

    public static void convertToGray(String file) {

        // load library OpenCv
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        //get the jpg image from the internal resource folder

        Mat image = Imgcodecs.imread(file);
        // convert the image in gray scale
        Imgproc.cvtColor(image, image, Imgproc.COLOR_BGR2GRAY);
        //write gray image on disk
        Imgcodecs.imwrite(file, image);
        System.out.println("Done Image Resize");


    }
    public static void copyFile (String source, String dest) throws IOException {
        File sourceFile = new File(source);
        File destFile = new File(dest);
        Files.copy(sourceFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
