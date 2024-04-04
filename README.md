# <h1 align="center">OpenCV with JavaFX</h1>

## <h2 align="center">This repositior show how to use OpenCV with Java</h2>
### This repo is exclusively for Windows users, but we welcome contributions for instructions on using OpenCV in Linux and macOS



* ### Prerequisites 

#### Download [OpenCV](https://opencv.org/releases)

#### Add this DLL file to environment variable.
![img.png](screenshot%2Fimg.png)
![img_1.png](screenshot%2Fimg_1.png)
#### You can find this dll inside {opencv_folder}\build\java\x64

### You can run this code and print OpenCV version.

```java
public class Main {
    public static void main(String[] args) {
        OpenCV.loadLocally();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("OpenCV version: " + Core.getVersionString());
        VideoCapture capture = new VideoCapture(0);
    }
}
```

### You can run this code to preview WebCam.
```java
public class Main {
    public static void main(String[] args) {
        OpenCV.loadLocally();
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("OpenCV version: " + Core.getVersionString());
        
        
        VideoCapture capture = new VideoCapture(0);// change this value to something else if 0 isn't working for you.
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
```
