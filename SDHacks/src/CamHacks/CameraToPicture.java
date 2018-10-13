package CamHacks;

import org.bytedeco.javacpp.opencv_core.IplImage;
import org.bytedeco.javacv.*;
import static org.bytedeco.javacpp.opencv_imgcodecs.cvSaveImage;

public class CameraToPicture implements Runnable{
	CanvasFrame canvas = new CanvasFrame("Camera");

    public CameraToPicture() {
        canvas.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    }

    public void run() {

        FrameGrabber grabber = new VideoInputFrameGrabber(0);
        OpenCVFrameConverter.ToIplImage converter = new OpenCVFrameConverter.ToIplImage();
        IplImage img;
        try {
            grabber.start();
            while (true) {
                Frame frame = grabber.grab();

                img = converter.convert(frame);
                cvSaveImage("image.jpg", img);

                canvas.showImage(converter.convert(img));

                Thread.sleep(1000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
    	CameraToPicture gs = new CameraToPicture();
        Thread th = new Thread(gs);
        th.start();
    }
}
