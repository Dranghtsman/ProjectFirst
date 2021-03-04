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
            System.out.format("Please Enter a number : %n" +
                    " 1 -> Resize image %n 0 -> Skip this step %n");
            int chois1 = inp.nextInt();

            if (chois1 == 1) {
                TransformImage.resizeImage(tempFile);

            } else if (chois1 == 0) {

                System.out.println("Action is skipped");
            }


            Scanner write = new Scanner(System.in);
            System.out.format("Please Enter a number : %n 1 -> Image make Gray %n 0 -> Skip this step %n");
            int chois = write.nextInt();
            if (chois == 1) {
                TransformImage.convertToGray(tempFile);
            } else if (chois == 0) {

                System.out.println("Action is skipped");
            }


            ImgageTransformerDAO imgageTransformerDAO = new ImgageTransformerDAO();


            //String filePath= "d:\\ss.jpg";
            Scanner input = new Scanner(System.in);
            System.out.println("write image name ");
            String name = input.nextLine();
            System.out.println("Now write image path like this d:\\imagename.jpg");
            Scanner input1 = new Scanner(System.in);
            String filePath = input1.nextLine();

            imgageTransformerDAO.insertImage(filePath, name);


            //String name = "sss";

            System.out.println("Image is Write to database");

            ImgageTransformerDAO writeF = new ImgageTransformerDAO();
            Scanner wf = new Scanner(System.in);
            System.out.println("Download image to database write path example d:\\imagename.jpg");
            String fileName = wf.nextLine();
            Scanner wf1 = new Scanner(System.in);
            System.out.println("Download file from deskription write deskription  example Bird----");
            name = wf1.nextLine();
            //String fileName = "d:\\ccc.jpg";
            //String name = "Bird----";
            InputStream iStream = ImgageTransformerDAO.writetoFile(name);
            if (iStream == null) {
                System.out.println("img not read from database ");
                return;
            }
            File file = new File(fileName);
            FileOutputStream outputStr = new FileOutputStream(file);
            System.out.println("Image write to file from database " + fileName);

            byte[] buffer = new byte[1024];
            while (iStream.read(buffer) > 0) {
                outputStr.write(buffer);
            }
            iStream.close();
            outputStr.close();

        } catch (Exception exception) {
            main.java.util.ExceptionCatch.huntException(exception);
        }


    }}