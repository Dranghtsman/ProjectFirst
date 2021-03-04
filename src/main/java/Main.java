import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws Exception {
        try {
            String orginalFile = "d:\\lape.jpg";
            String tempFile = "d:\\ss.jpg";

            TransformImage.copyFile(orginalFile, tempFile);
//

            Scanner inp = new Scanner(System.in);
            System.out.format("Please enter a number :" +
                    " %n 1 -> Resize image %n 0 -> Skip this step %nchoice: ");

            int chois1 = inp.nextInt();

            if (chois1 == 1) {
                System.out.print("Please enter image width :");
                int width = inp.nextInt();
                System.out.print("Please enter image height :");
                int height = inp.nextInt();
                TransformImage.resizeImage(tempFile, width, height);

            } else if (chois1 == 0) {

                System.out.println("Action is skipped");
            }


            Scanner write = new Scanner(System.in);
            System.out.format("Please Enter a number :" +
                    " %n 1 -> Change color to Gray %n 0 -> Skip this step %n%nchoice: ");
            int chois = write.nextInt();
            if (chois == 1) {
                TransformImage.convertToGray(tempFile);
            } else if (chois == 0) {

                System.out.println("Action is skipped");
            }


            ImgageTransformerDAO imgageTransformerDAO = new ImgageTransformerDAO();


            Scanner input = new Scanner(System.in);
            System.out.println("Enter image identifier, whitch will be used in database: ");
            String name = input.nextLine();
            imgageTransformerDAO.insertImage(tempFile, name);


            System.out.println("Image was Write into database");

            ImgageTransformerDAO writeF = new ImgageTransformerDAO();
            Scanner wf = new Scanner(System.in);
            System.out.println("Save image from database to disk (path example d:\\imagename.jpg");
            String fileName = wf.nextLine();
            Scanner wf1 = new Scanner(System.in);
            System.out.println("Enter image identifier(file name) on database (example rope");
            name = wf1.nextLine();

            InputStream iStream = ImgageTransformerDAO.writetoFile(name);
            if (iStream == null) {
                System.out.println("Image wasn't read from database");
                return;
            }
            File file = new File(fileName);
            FileOutputStream outputStr = new FileOutputStream(file);
            System.out.println("Image was written from database to disk" + fileName);

            byte[] buffer = new byte[1024];
            while (iStream.read(buffer) > 0) {
                outputStr.write(buffer);
            }
            iStream.close();
            outputStr.close();

        } catch (Exception exception) {
            main.java.util.ExceptionCatch.huntException(exception);
        }


    }
}