package org.example;

import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.videoio.VideoCapture;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;

public class Main {
    public static void main(String[] args) {
        OpenCV.loadLocally();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("OpenCV version: " + Core.getVersionString());
        VideoCapture capture = new VideoCapture(0);

        if (!capture.isOpened()) {
            System.out.println("Failed to open camera!");
            return;
        }

        HighGui.namedWindow("Camera Preview", HighGui.WINDOW_AUTOSIZE);
        Mat frame = new Mat();


        while (true) {
            capture.read(frame);
            if (frame.empty()) {
                System.out.println("No frame captured!");
                break;
            }
            HighGui.imshow("Camera Preview", frame);
            if (HighGui.waitKey(10) >= 0)
                break;
        }
        capture.release();
        HighGui.destroyAllWindows();
    }
}
