package com.example.broslab;


import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;
import android.util.Log;

import org.opencv.android.Utils;
import org.opencv.core.CvException;
import org.opencv.core.Rect;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Core;
import org.opencv.android.JavaCameraView;
import org.opencv.android.OpenCVLoader;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.Size;
import org.opencv.core.Point;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfPoint;
import org.opencv.utils.Converters;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import android.view.WindowManager;

import static org.opencv.core.Core.rotate;
import static org.opencv.core.Core.transpose;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;


public class MainActivity extends AppCompatActivity implements CameraBridgeViewBase.CvCameraViewListener2 {






    //view holder
    CameraBridgeViewBase cameraBridgeViewBase;

    //camera listener callback
    BaseLoaderCallback baseLoaderCallback;

    //image holder
    Mat bwIMG, hsvIMG, lrrIMG, urrIMG, dsIMG, usIMG, cIMG, hovIMG, myIMG;
    MatOfPoint2f approxCurve;

    int threshold;







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);



        //initialize treshold
        threshold = 100;

        cameraBridgeViewBase = (JavaCameraView) findViewById(R.id.cameraview);
        cameraBridgeViewBase.setVisibility(SurfaceView.VISIBLE);
        cameraBridgeViewBase.setCvCameraViewListener(this);

        //create camera listener callback
        baseLoaderCallback = new BaseLoaderCallback(this) {
            @Override
            public void onManagerConnected(int status) {
                switch (status) {
                    case LoaderCallbackInterface.SUCCESS:
                        Log.v("aashari-log", "Loader interface success");

                        bwIMG = new Mat();
                        dsIMG = new Mat();
                        hsvIMG = new Mat();
                        lrrIMG = new Mat();
                        urrIMG = new Mat();
                        usIMG = new Mat();
                        cIMG = new Mat();
                        hovIMG = new Mat();
                        approxCurve = new MatOfPoint2f();
                        cameraBridgeViewBase.enableView();
                        myIMG = new Mat();
                        break;
                    default:
                        super.onManagerConnected(status);
                        break;
                }
            }
        };

    }


    @Override

    public void onCameraViewStarted(int width, int height) {

    }

    @Override
    public void onCameraViewStopped() {

    }







    @Override
    public Mat onCameraFrame(CameraBridgeViewBase.CvCameraViewFrame inputFrame) {







        //y값 추출 위한 변수들.
        double max = 0;
        double secmax = 0;
        int i = 0;
        int maxnumber = 0;
        int secmaxnumber = 0;
        double temps = 0;

        double lastno1 = 0;
        double lastno2 = 0;
        double lastno3 = 0;
        double lastno4 = 0;
        double lastno5 = 0;
        double lastno6 = 0;
        double lastno7 = 0;
        double lastno8 = 0;
        double blastno1 = 0;
        double blastno2 = 0;
        double blastno3 = 0;
        double blastno4 = 0;
        double blastno5 = 0;
        double blastno6 = 0;
        double blastno7 = 0;
        double blastno8 = 0;
        double bblastno1 = 0;
        double bblastno2 = 0;
        double bblastno3 = 0;
        double bblastno4 = 0;
        double bblastno5 = 0;
        double bblastno6 = 0;
        double bblastno7 = 0;
        double bblastno8 = 0;



        double max1 = 0;
        double max2 = 0;
        double min1 = 0;
        double min2 = 0;
        double maxb1 = 0;
        double maxb2 = 0;
        double minb1 = 0;
        double minb2 = 0;
        double secmax1 = 0;
        int maxnumber1 = 0;
        int secmaxnumber1 = 0;
        double temps1 = 0;


        double lastnob1 = 0;
        double lastnob2 = 0;
        double lastnob3 = 0;
        double lastnob4 = 0;
        double lastnob5 = 0;
        double lastnob6 = 0;
        double lastnob7 = 0;
        double lastnob8 = 0;




        double number0 = 0;
        double number1 = 0;
        double number2 = 0;
        double number3 = 0;
        double number4 = 0;
        double number5 = 0;
        double number6 = 0;
        double number7 = 0;
        double number8 = 0;
        double number9 = 0;
        double number10 = 0;
        double number11 = 0;
        double number12 = 0;
        double number13 = 0;
        double number14 = 0;
        double number15= 0;
        double number16= 0;
        double number17= 0;
        double number18= 0;
        double number19= 0;
        double number91= 0;
        double number191 = 0;


        double rightnumber1 = 0;
        double rightnumber2 = 0;
        double rightnumber3 = 0;
        double rightnumber4 = 0;
        double rightnumber5 = 0;
        double rightnumber6 = 0;
        double rightnumber7 = 0;
        double rightnumber8 = 0;


        int ss1 = 0;
        int ss2 = 0;
        int ss3 = 0;
        int ss4 = 0;
        int ss5 = 0;
        int ss6 = 0;
        int ss7 = 0;
        int ss8 = 0;
        int ss9 = 0;
        int ss10 = 0;
        int ss11 = 0;
        int ss20 = 0;
        int ss21 = 0;
        int ss22 = 0;
        int ss23 = 0;
        int ss24 = 0;
        int ss25 = 0;
        int ss26 = 0;
        int ss27 = 0;
        int ss28 = 0;
        int ss29 = 0;
        int ss30 = 0;







        //Size szsz = new Size(1000,1000);

        Mat gray = inputFrame.gray();
        Mat dst = inputFrame.rgba();
        /*
        Mat mRgbaT = dst.t();
        Core.flip(dst.t(), mRgbaT, 1);
        */

        //Log.i("haha",  "haha - " + dst.size());


        int w = dst.width();
        int h = dst.height();
        Imgproc.rectangle(dst, new Point(w * 0, h * 0), new Point(
                w , h * 1 /  7 ), new Scalar( 0, 0, 0, 128 ), -1
        );


        Imgproc.rectangle(dst, new Point(w * 0, h * 1), new Point(
                w , h * 6 /  7 ), new Scalar( 0, 0, 0, 128), -1
        );
        Imgproc.rectangle(dst, new Point(w * 0, h * 0), new Point(
                w * 5 / 18 , h  ), new Scalar( 0, 0, 0, 128 ), -1
        );
        Imgproc.rectangle(dst, new Point(w * 13 / 18, h * 0), new Point(
                w  , h  ), new Scalar( 0, 0, 0, 128 ), -1
        );


        //Imgproc.putText(dst, "lab", new Point(w * 15 / 18, h * 6 /  7), 3, 2, new Scalar(255, 255, 255), 2);


        //Imgproc.putText(dst, "Bros", new Point(w * 15 / 18, h * 5 /  7), 3, 2, new Scalar(255, 255, 255), 2);
        //Imgproc.putText(dst, "Beta Ver.", new Point(w * 15 / 18, h * 3 /  7), 3, 2, new Scalar(255, 255, 255), 2);


        Imgproc.rectangle(dst, new Point(w * 5 / 18, h * 1 / 7), new Point(
                w * 13 / 18, h * 6 /  7 ), new Scalar( 255, 0, 0 ), 10
        );

//2번째 인자와 3번째 인자를 통해 점을 2개 받습니다. 점을 두개 받으면 사각형이 정의됩니다.

//Imgproc = image processing을 의미한다.
        //Mat은 Matrix의 약자이며, 말 그대로 행렬(Matrix)과 비슷한 구조를 가지고 있다. 세로로 M 픽셀, 가로로 N 픽셀로 이루어진 이미지를 MxN 행렬 형태로 저장한다.


        Imgproc.pyrDown(gray, dsIMG, new Size(gray.cols() / 2, gray.rows() / 2));
        Imgproc.pyrUp(dsIMG, usIMG, gray.size());

        Imgproc.Canny(usIMG, bwIMG, 0, threshold);

        Imgproc.dilate(bwIMG, bwIMG, new Mat(), new Point(-1, 1), 1);

        List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
        //contours라는 matofpoint 타입의 list를 만들어 준 후 string matofpoint 타입의 arraylist 생성
        //MatOfPoint는 point 타입의 배열(matrix)를 의미한다
        cIMG = bwIMG.clone();


        Imgproc.findContours(cIMG, contours, hovIMG, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
        int myNumber = 0;
        int testNumber = 0;

        for (MatOfPoint cnt : contours) {

            MatOfPoint2f curve = new MatOfPoint2f(cnt.toArray());

            Imgproc.approxPolyDP(curve, approxCurve, 0.02 * Imgproc.arcLength(curve, true), true);
//cv2.findContours() 함수를 통해 찾은 컨투어 라인은 각각의 컨투어 포인트들을 가지고 있다. 컨투어 추정은 Douglas-Peucker 알고리즘을 이용해 컨투어 포인트의 수를 줄여 실제 컨투어 라인과 근사한 라인을 그릴 때 사용된다. OpenCV에서는 cv2.approxPolyDP() 라는 함수로 구현되어 있다.
//MatOfPoint2f differs from MatOfPoint only in the type of the elements (32-bit float and 32-bit int respectively).
            int numberVertices = (int) approxCurve.total();

            double contourArea = Imgproc.contourArea(cnt);

            if (Math.abs(contourArea) < 100) {
                continue;
            }

            //Rectangle detected
            if (numberVertices >= 4 && numberVertices <= 6) {

                List<Double> cos = new ArrayList<>();

                for (int j = 2; j < numberVertices + 1; j++) {
                    cos.add(angle(approxCurve.toArray()[j % numberVertices], approxCurve.toArray()[j - 2], approxCurve.toArray()[j - 1]));

                }

                Collections.sort(cos);

                double mincos = cos.get(0);
                double maxcos = cos.get(cos.size() - 1);


                if (numberVertices == 4 && mincos >= -0.1 && maxcos <= 0.3) {

                    myNumber+=1;
                    setLabel(dst, "o"+myNumber, cnt);

                    double[] temp_double;
                    temp_double = approxCurve.get(0,0);
                    Point p1 = new Point(temp_double[0], temp_double[1]);
                    //Core.circle(imgSource,p1,55,new Scalar(0,0,255));
                    //Imgproc.warpAffine(sourceImage, dummy, rotImage,sourceImage.size());
                    temp_double = approxCurve.get(1,0);
                    Point p2 = new Point(temp_double[0], temp_double[1]);
                    // Core.circle(imgSource,p2,150,new Scalar(255,255,255));
                    temp_double = approxCurve.get(2,0);
                    Point p3 = new Point(temp_double[0], temp_double[1]);
                    //Core.circle(imgSource,p3,200,new Scalar(255,0,0));
                    temp_double = approxCurve.get(3,0);
                    Point p4 = new Point(temp_double[0], temp_double[1]);
                    // Core.circle(imgSource,p4,100,new Scalar(0,0,255));
                    List<Point> source = new ArrayList<Point>();

                    source.add(p1);
                    source.add(p2);
                    source.add(p3);
                    source.add(p4);
                    testNumber += 1;

                    double testX;
                    double testY;

                    //사각형 4개 모서리의 x,y값의 평균을 구한다.
                    testX = (source.get(0).x + source.get(1).x + source.get(2).x + source.get(3).x) / 4;
                    testY = (source.get(0).y + source.get(1).y + source.get(2).y + source.get(3).y) / 4;
                    //x,y 평균값에 각각의 x,y값을 빼서 모두 더한다 (결과의 값이 클수록 검사지 샘플 표 하단 직사각형일 가능성이 높다)

                    double testaY;
                    double testaZ;
                    double testaZ1;
                    double testaZ2;
                    double testaZ3;

                    double testaX;
                    double testbZ;
                    double testbZ1;
                    double testbZ2;
                    double testbZ3;



                    testaX = Math.abs(testX - source.get(0).x) + Math.abs(testX - source.get(1).x) + Math.abs(testX - source.get(2).x) + Math.abs(testX - source.get(3).x);
                    testaY = Math.abs(testY - source.get(0).y) + Math.abs(testY - source.get(1).y) + Math.abs(testY - source.get(2).y) + Math.abs(testY - source.get(3).y);

                    testaZ = source.get(0).y;
                    testaZ1 = source.get(1).y;
                    testaZ2 = source.get(2).y;
                    testaZ3 = source.get(3).y;

                    testbZ = source.get(0).x;
                    testbZ1 = source.get(1).x;
                    testbZ2 = source.get(2).x;
                    testbZ3 = source.get(3).x;

                    Log.d("tata", i+ "번째" + source + "testay" + testaY);



                    double arr[] = new double[200];
                    double arrbefore[] = new double[200];
                    double arrbefore1[] = new double[200];
                    double arrbefore2[] = new double[200];
                    double arrbefore3[] = new double[200];

                    double arr1[] = new double[200];

                    double arrbef[] = new double[200];
                    double arrbef1[] = new double[200];
                    double arrbef2[] = new double[200];
                    double arrbef3[] = new double[200];


                    arr[i] = testaX;
                    arrbefore[i] = testbZ;
                    arrbefore1[i] = testbZ1;
                    arrbefore2[i] = testbZ2;
                    arrbefore3[i] = testbZ3;



                    arr1[i] = testaY;
                    arrbef[i] = testaZ;
                    arrbef1[i] = testaZ1;
                    arrbef2[i] = testaZ2;
                    arrbef3[i] = testaZ3;




                    if(arr1[i] > secmax)
                    {

                        secmax = arr1[i];
                        secmaxnumber = i;
                        lastno1 = arrbefore[i];
                        lastno2= arrbefore1[i];
                        lastno3= arrbefore2[i];
                        lastno4= arrbefore3[i];

                        lastnob1 = arrbef[i];
                        lastnob2 = arrbef1[i];
                        lastnob3 = arrbef2[i];
                        lastnob4 = arrbef3[i];


                        if(secmax > max ) {
                            temps = max;
                            max = secmax;
                            secmaxnumber = maxnumber;
                            secmax = temps;

                            lastno1 = lastno5;
                            lastno2= lastno6;
                            lastno3= lastno7;
                            lastno4= lastno8;

                            lastnob1 = lastnob5;
                            lastnob2 = lastnob6;
                            lastnob3 = lastnob7;
                            lastnob4 = lastnob8;

                            lastno5 = arrbefore[i];
                            lastno6= arrbefore1[i];
                            lastno7= arrbefore2[i];
                            lastno8= arrbefore3[i];

                            lastnob5 = arrbef[i];
                            lastnob6 = arrbef1[i];
                            lastnob7 = arrbef2[i];
                            lastnob8 = arrbef3[i];

                            maxnumber = i;
                        }
                    }
                    i+=1;

                    if (myNumber >= 50)

                    {
                        Log.d("tata", i+ "번째 secmax" + secmax + "max" + max);
                        //테스트지 위 사각형을 가려내는 알고리즘 (밑의 조건 충족 경우 lastnob1이 위의 사각형이 됨)
                        if ( lastno1 > lastno5) {
                            // 01 ~ 04 는 위에 있는 사각형, 05~08은 아래에 있는 사각형
                            //y
                            blastno1 = lastnob1;
                            blastno2 = lastnob2;
                            blastno3 = lastnob3;
                            blastno4 = lastnob4;

                            //x
                            bblastno1 = lastno1;
                            bblastno2 = lastno2;
                            bblastno3 = lastno3;
                            bblastno4 = lastno4;

                            //y
                            blastno5 = lastnob5;
                            blastno6 = lastnob6;
                            blastno7 = lastnob7;
                            blastno8 = lastnob8;

                            //x
                            bblastno5 = lastno5;
                            bblastno6 = lastno6;
                            bblastno7 = lastno7;
                            bblastno8 = lastno8;


                            double arr2[] = {blastno1, blastno2,blastno3,blastno4};//y
                            double arr3[] = {bblastno1, bblastno2,bblastno3,bblastno4};//x
                            double arr4[] = {blastno5, blastno6,blastno7,blastno8};//y
                            double arr5[] = {bblastno5, bblastno6,bblastno7,bblastno8};//x




                            Map<Double, Double> map = new HashMap<Double, Double>();



                            // y,x 의 순서
                            map.put(blastno1, bblastno1);
                            map.put(blastno2, bblastno2);
                            map.put(blastno3, bblastno3);
                            map.put(blastno4, bblastno4);
                            map.put(blastno5, bblastno5);
                            map.put(blastno6, bblastno6);
                            map.put(blastno7, bblastno7);
                            map.put(blastno8, bblastno8);


                            Map<Double, Double> map1 = new HashMap<Double, Double>();
                            Map<Double, Double> map2 = new HashMap<Double, Double>();

                            if(map.containsKey(blastno8)){
                                Arrays.sort(arr2);
                                Arrays.sort(arr4);

                                if(map.containsKey(blastno8)){
                                    Log.d("hehe", "seeeeee" + map.get(arr2[0]));

                                    //우측 꼭지점
                                    map1.put(map.get(arr2[0]), arr2[0]);
                                    map1.put(map.get(arr2[1]), arr2[1]);
                                    map1.put(map.get(arr4[0]), arr4[0]);
                                    map1.put(map.get(arr4[1]), arr4[1]);

                                    //좌측 꼭지점
                                    map2.put(map.get(arr2[2]), arr2[2]);
                                    map2.put(map.get(arr2[3]), arr2[3]);
                                    map2.put(map.get(arr4[2]), arr4[2]);
                                    map2.put(map.get(arr4[3]), arr4[3]);

                                    //우측 꼭지점
                                    double arr6[] = {map.get(arr2[1]), map.get(arr2[0])};//x
                                    double arr7[] = {map.get(arr4[1]), map.get(arr4[0])};//x

                                    Arrays.sort(arr6);
                                    Arrays.sort(arr7);


                                    //좌측 꼭지점

                                    double arr8[] = {map.get(arr2[3]), map.get(arr2[2])};//x
                                    double arr9[] = {map.get(arr4[3]), map.get(arr4[2])};//x

                                    Arrays.sort(arr8);
                                    Arrays.sort(arr9);

                                    //왼쪽 사각형 꼭지점 구하는 로직
                                    number0 = map.get(arr2[3]);
                                    number1 = map.get(arr2[2]);
                                    number2 = (number0 + number1) / 2;


                                    if(map.containsKey(blastno8)){


                                        //왼쪽 사각형 꼭지점 구하는 로직
                                        number3 = map.get(arr4[3]);
                                        number4 = map.get(arr4[2]);
                                        number5 = (number3 + number4) / 2;

                                        if(map.containsKey(blastno8)) {

                                            //좌측 위 아래 사각형 중간 변 끼리 잇는 선
                                            //Imgproc.line(dst, new Point(number5  , (arr4[3] + arr4[2]) / 2 ), new Point(
                                             //       number2  , (arr2[3] + arr2[2]) / 2  ), new Scalar( 255, 255, 255 ), 10
                                           // );


                                            //우측 상단 꼭지점과 좌측 하단 꼭지점 잇는 좌표
                                            //Imgproc.line(dst, new Point(arr6[1]  , map1.get(arr6[1]) ), new Point(
                                               // arr7[0]  , map1.get(arr7[0])  ), new Scalar( 0, 0, 0 ), 10);


                                                //아래 사각형의 아랫변 꼭지점 좌우로 잇는 좌표
                                           //Imgproc.line(dst, new Point(arr6[1]  , map1.get(arr6[1]) ), new Point(
                                                 //   arr8[1]  , map2.get(arr8[1])  ), new Scalar( 255, 0, 0 ), 10);


                                            //위 사각형의 윗변 꼭지점 좌우로 잇는 좌표
                                            //Imgproc.line(dst, new Point(arr7[0]  , map1.get(arr7[0]) ), new Point(
                                             //       arr9[0]  , map2.get(arr9[0])  ), new Scalar( 0, 255, 0 ), 10);

                                            //위 꼭지점의 x,y 좌표
                                            double result1 = arr7[0] - (11.5 / 8 * (arr7[0] -  arr9[0]));
                                            double result2 = map1.get(arr7[0]) - (11.5 / 8 * (map1.get(arr7[0]) -   map2.get(arr9[0])) );
                                            //아래 꼭지점의 x,y 좌표
                                            double result3 = arr6[1] - (11.5 / 8 * (arr6[1] -  arr8[1]));
                                            double result4 = map1.get(arr6[1]) - (11.5 / 8 * (map1.get(arr6[1]) -   map2.get(arr8[1])) );

                                            //위, 아래 중간선 잇는 좌표
                                           // Imgproc.line(dst, new Point(result1  , result2 ), new Point(
                                                  //  result3  , result4  ), new Scalar( 0, 0, 255 ), 5);


//x 좌표




                                            double plus0 =     Math.round(  (result3 - result1) * 1 /27 * 100 ) / 100;
                                            double plus1 =     Math.round(        (  result1 + plus0 * 1.95 / 2 )* 100 ) / 100;
                                            double plus2 =     Math.round(        (   plus1 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus3 =     Math.round(        (   plus2 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus4 =     Math.round(        (   plus3 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus5 =     Math.round(        (   plus4 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus6 =     Math.round(        (   plus5 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus7 =     Math.round(        (   plus6 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus8 =     Math.round(        (   plus7 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus9 =     Math.round(        (   plus8 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus91 =    Math.round(        (   plus9 + plus0 * 2.95 )* 100 ) / 100;

                                            Log.d("calc", "plus 0 to 91 ----" + plus0);
                                            Log.d("calc", "plus 0 to 91 ----" + plus1);
                                            Log.d("calc", "plus 0 to 91 ----" + plus2);
                                            Log.d("calc", "plus 0 to 91 ----" + plus3);
                                            Log.d("calc", "plus 0 to 91 ----" + plus4);
                                            Log.d("calc", "plus 0 to 91 ----" + plus5);
                                            Log.d("calc", "plus 0 to 91 ----" + plus6);
                                            Log.d("calc", "plus 0 to 91 ----" + plus7);
                                            Log.d("calc", "plus 0 to 91 ----" + plus8);
                                            Log.d("calc", "plus 0 to 91 ----" + plus9);
                                            Log.d("calc", "plus 0 to 91 ----" + plus91);



//y 좌표


                                            double plus10 = Math.round( (result4 - result2) * 1 /27 * 100 ) / 100;
                                            double plus11 = Math.round( (result2 + plus10 * 1.95 / 2 )* 100 ) / 100;
                                            double plus12 = Math.round( ( plus11 + plus10 * 2.95)* 100 ) / 100;
                                            double plus13 = Math.round( ( plus12 + plus10 * 2.95)* 100 ) / 100;
                                            double plus14 = Math.round( ( plus13 + plus10 * 2.95)* 100 ) / 100;
                                            double plus15 = Math.round( ( plus14 + plus10 * 2.95)* 100 ) / 100;
                                            double plus16 = Math.round( ( plus15 + plus10 * 2.95)* 100 ) / 100;
                                            double plus17 = Math.round( ( plus16 + plus10 * 2.95)* 100 ) / 100;
                                            double plus18 = Math.round( ( plus17 + plus10 * 2.95)* 100 ) / 100;
                                            double plus19 = Math.round( ( plus18 + plus10 * 2.95)* 100 ) / 100;
                                            double plus191 =Math.round( ( plus19 + plus10 * 2.95)* 100 ) / 100;



                                            Log.d("calc", "plus 10 to 191 ----" + plus10);
                                            Log.d("calc", "plus 10 to 191 ----" + plus11);
                                            Log.d("calc", "plus 10 to 191 ----" + plus12);
                                            Log.d("calc", "plus 10 to 191 ----" + plus13);
                                            Log.d("calc", "plus 10 to 191 ----" + plus14);
                                            Log.d("calc", "plus 10 to 191 ----" + plus15);
                                            Log.d("calc", "plus 10 to 191 ----" + plus16);
                                            Log.d("calc", "plus 10 to 191 ----" + plus17);
                                            Log.d("calc", "plus 10 to 191 ----" + plus18);
                                            Log.d("calc", "plus 10 to 191 ----" + plus19);
                                            Log.d("calc", "plus 10 to 191 ----" + plus191);



                                            //x좌표
                                            number0 = result1 + (result3-result1) * 1 / 27 ;
                                            number1 = result1 + (result3-result1) * 4 / 27;
                                            number2 = result1 + (result3-result1) * 7 / 27;
                                            number3 = result1 + (result3-result1) * 10 / 27;
                                            number4 = result1 + (result3-result1) * 13 / 27;
                                            number5 = result1 + (result3-result1) * 16 / 27;
                                            number6 = result1 + (result3-result1) * 19 / 27;
                                            number7 = result1 + (result3-result1) * 22 / 27;
                                            number8 = result1 + (result3-result1) * 25 / 27;
                                            number9 = result1 + (result3-result1) * 28 / 27;
                                            number91 = result1 + (result3-result1) * 31/ 27;

                                            ss1 = (int) number0;
                                            ss2 = (int) number1;
                                            ss3 = (int) number2;
                                            ss4 = (int) number3;
                                            ss5 = (int) number4;
                                            ss6 = (int) number5;
                                            ss7 = (int) number6;
                                            ss8 = (int) number7;
                                            ss9 = (int) number8;
                                            ss10 = (int) number9;
                                            ss11 = (int) number91;



                                            //y좌표

                                            number10 = result2 + (result4-result2) * 1 / 27;
                                            number11 = result2 + (result4-result2) * 4 / 27;
                                            number12 = result2 + (result4-result2) * 7 / 27;
                                            number13 = result2 + (result4-result2) * 10 / 27;
                                            number14 = result2 + (result4-result2) * 13 / 27;
                                            number15 = result2 + (result4-result2) * 16 / 27;
                                            number16 = result2 + (result4-result2) * 19 / 27;
                                            number17 = result2 + (result4-result2) * 22 / 27;
                                            number18 = result2 + (result4-result2) * 25 / 27;
                                            number19 = result2 + (result4-result2) * 28 / 27;
                                            number191 = result2 + (result4-result2) * 31 / 27;

                                            ss20 = (int)number10;
                                            ss21 = (int)number11;
                                            ss22 = (int)number12;
                                            ss23 = (int)number13;
                                            ss24 = (int)number14;
                                            ss25 = (int)number15;
                                            ss26 = (int)number16;
                                            ss27 = (int)number17;
                                            ss28 = (int)number18;
                                            ss29 = (int)number19;
                                            ss30 = (int)number191;


                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number0, number10),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );

                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number1, number11),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );
                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number2, number12),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );

                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number3, number13),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );
                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number4, number14),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );

                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number5, number15),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );
                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number6, number16),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );

                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number7, number17),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );
                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number8, number18),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );

                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number9, number19),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );
                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number91, number191),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );




                                        }
                                    }

                                }
                            }


                            /*
2019-05-29 19:13:11.172 17266-17780/com.example.broslab D/tata: 50arr2[][351.0, 535.0, 540.0, 353.0]
2019-05-29 19:13:11.172 17266-17780/com.example.broslab D/tata: 50arr3[][1134.0, 1132.0, 1178.0, 1182.0]
2019-05-29 19:13:11.172 17266-17780/com.example.broslab D/tata: 50arr4[][353.0, 540.0, 541.0, 355.0]
2019-05-29 19:13:11.172 17266-17780/com.example.broslab D/tata: 50arr5[][576.0, 566.0, 616.0, 623.0]
arr2 = secmax의 y 값
arr3 = secmax의 x값
arr4 = max의 y값
arr5 = max의 x값

*/

                        }
                        if ( lastno1 < lastno5){
                            //y
                            blastno1 = lastnob5;
                            blastno2 = lastnob6;
                            blastno3 = lastnob7;
                            blastno4 = lastnob8;
                            //x
                            bblastno1 = lastno5;
                            bblastno2 = lastno6;
                            bblastno3 = lastno7;
                            bblastno4 = lastno8;

                            //y
                            blastno5 = lastnob1;
                            blastno6 = lastnob2;
                            blastno7 = lastnob3;
                            blastno8 = lastnob4;

                            //x
                            bblastno5 = lastno1;
                            bblastno6 = lastno2;
                            bblastno7 = lastno3;
                            bblastno8 = lastno4;

                            double arr2[] = {blastno1, blastno2,blastno3,blastno4};
                            double arr3[] = {bblastno1, bblastno2,bblastno3,bblastno4};
                            double arr4[] = {blastno5, blastno6,blastno7,blastno8};
                            double arr5[] = {bblastno5, bblastno6,bblastno7,bblastno8};



                            /*
                            2019-05-29 19:28:33.808 19310-19814/com.example.broslab D/tata: 50arr2[][338.0, 504.0, 506.0, 339.0]
                            2019-05-29 19:28:33.808 19310-19814/com.example.broslab D/tata: 50arr3[][1208.0, 1206.0, 1253.0, 1250.0]
                            2019-05-29 19:28:33.808 19310-19814/com.example.broslab D/tata: 50arr4[][346.0, 507.0, 510.0, 347.0]
                            2019-05-29 19:28:33.808 19310-19814/com.example.broslab D/tata: 50arr5[][716.0, 711.0, 756.0, 758.0]
                            arr2 = max의 y값
                            arr3 = max의 x값
                            arr4  = secmax의 y값
                            arr5 = secmax의 x값

*/

                            Map<Double, Double> map = new HashMap<Double, Double>();

                            map.put(blastno1, bblastno1);
                            map.put(blastno2, bblastno2);
                            map.put(blastno3, bblastno3);
                            map.put(blastno4, bblastno4);
                            map.put(blastno5, bblastno5);
                            map.put(blastno6, bblastno6);
                            map.put(blastno7, bblastno7);
                            map.put(blastno8, bblastno8);


                            Map<Double, Double> map1 = new HashMap<Double, Double>();
                            Map<Double, Double> map2 = new HashMap<Double, Double>();


                            if(map.containsKey(blastno8)){
                                Arrays.sort(arr2);
                                Arrays.sort(arr4);

                                if(map.containsKey(blastno8)){
                                    Log.d("hehe", "seeeeee" + map.get(arr2[0]));


                                    //우측 꼭지점
                                    map1.put(map.get(arr2[0]), arr2[0]);
                                    map1.put(map.get(arr2[1]), arr2[1]);
                                    map1.put(map.get(arr4[0]), arr4[0]);
                                    map1.put(map.get(arr4[1]), arr4[1]);

                                    //좌측 꼭지점
                                    map2.put(map.get(arr2[2]), arr2[2]);
                                    map2.put(map.get(arr2[3]), arr2[3]);
                                    map2.put(map.get(arr4[2]), arr4[2]);
                                    map2.put(map.get(arr4[3]), arr4[3]);

                                    //우측 꼭지점
                                    double arr6[] = {map.get(arr2[1]), map.get(arr2[0])};//x
                                    double arr7[] = {map.get(arr4[1]), map.get(arr4[0])};//x


                                    Arrays.sort(arr6);
                                    Arrays.sort(arr7);
                                    //좌측 꼭지점

                                    double arr8[] = {map.get(arr2[3]), map.get(arr2[2])};//x
                                    double arr9[] = {map.get(arr4[3]), map.get(arr4[2])};//x

                                    Arrays.sort(arr8);
                                    Arrays.sort(arr9);

                                    //왼쪽 사각형 꼭지점 구하는 로직
                                    number0 = map.get(arr2[3]);
                                    number1 = map.get(arr2[2]);
                                    number2 = (number0 + number1) / 2;



                                    if(map.containsKey(blastno8)){


                                        //왼쪽 사각형 꼭지점 구하는 로직
                                        number3 = map.get(arr4[3]);
                                        number4 = map.get(arr4[2]);
                                        number5 = (number3 + number4) / 2;




                                        if(map.containsKey(blastno8)) {
                                            //좌측 위 아래 사각형 중간 변 끼리 잇는 선
                                            //Imgproc.line(dst, new Point(number5  , (arr4[3] + arr4[2]) / 2 ), new Point(
                                                    //number2  , (arr2[3] + arr2[2]) / 2  ), new Scalar( 255, 255, 255 ), 10
                                           // );

                                            //우측 상단 꼭지점과 좌측 하단 꼭지점 잇는 좌표
                                           // Imgproc.line(dst, new Point(arr6[1]  , map1.get(arr6[1]) ), new Point(
                                                   // arr7[0]  , map1.get(arr7[0])  ), new Scalar( 0, 0, 0 ), 10);

                                            //아래 사각형의 아랫변 꼭지점 좌우로 잇는 좌표
                                            //Imgproc.line(dst, new Point(arr6[1]  , map1.get(arr6[1]) ), new Point(
                                                    //arr8[1]  , map2.get(arr8[1])  ), new Scalar( 255, 0, 0 ), 10);

                                            //위 사각형의 윗변 꼭지점 좌우로 잇는 좌표
                                            //Imgproc.line(dst, new Point(arr7[0]  , map1.get(arr7[0]) ), new Point(
                                                   // arr9[0]  , map2.get(arr9[0])  ), new Scalar( 0, 255, 0 ), 10);


                                            //위 꼭지점의 x,y 좌표
                                            double result1 = arr7[0] - (11.5 / 8 * (arr7[0] -  arr9[0]));
                                            double result2 = map1.get(arr7[0]) - (11.5 / 8 * (map1.get(arr7[0]) -   map2.get(arr9[0])) );
                                            //아래 꼭지점의 x,y 좌표
                                            double result3 = arr6[1] - (11.5 / 8 * (arr6[1] -  arr8[1]));
                                            double result4 = map1.get(arr6[1]) - (11.5 / 8 * (map1.get(arr6[1]) -   map2.get(arr8[1])) );
                                            //위, 아래 중간선 잇는 좌표
                                            //Imgproc.line(dst, new Point(result1  , result2 ), new Point(
                                                //    result3  , result4  ), new Scalar( 0, 0, 255 ), 5);

//x 좌표




                                            double plus0 =     Math.round(  (result3 - result1) * 1 /27 * 100 ) / 100;
                                            double plus1 =     Math.round(        (  result1 + plus0 * 1.95 / 2 )* 100 ) / 100;
                                            double plus2 =     Math.round(        (   plus1 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus3 =     Math.round(        (   plus2 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus4 =     Math.round(        (   plus3 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus5 =     Math.round(        (   plus4 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus6 =     Math.round(        (   plus5 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus7 =     Math.round(        (   plus6 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus8 =     Math.round(        (   plus7 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus9 =     Math.round(        (   plus8 + plus0 * 2.95 )* 100 ) / 100;
                                            double plus91 =    Math.round(        (   plus9 + plus0 * 2.95 )* 100 ) / 100;



                                            Log.d("calc", "plus 0 to 91 ----" + plus0);
                                            Log.d("calc", "plus 0 to 91 ----" + plus1);
                                            Log.d("calc", "plus 0 to 91 ----" + plus2);
                                            Log.d("calc", "plus 0 to 91 ----" + plus3);
                                            Log.d("calc", "plus 0 to 91 ----" + plus4);
                                            Log.d("calc", "plus 0 to 91 ----" + plus5);
                                            Log.d("calc", "plus 0 to 91 ----" + plus6);
                                            Log.d("calc", "plus 0 to 91 ----" + plus7);
                                            Log.d("calc", "plus 0 to 91 ----" + plus8);
                                            Log.d("calc", "plus 0 to 91 ----" + plus9);
                                            Log.d("calc", "plus 0 to 91 ----" + plus91);



//y 좌표

                                            double plus10 = Math.round( (result4 - result2) * 1 /27 * 100 ) / 100;
                                            double plus11 = Math.round( (result2 + plus10 * 1.95 / 2 )* 100 ) / 100;
                                            double plus12 = Math.round( ( plus11 + plus10 * 2.95)* 100 ) / 100;
                                            double plus13 = Math.round( ( plus12 + plus10 * 2.95)* 100 ) / 100;
                                            double plus14 = Math.round( ( plus13 + plus10 * 2.95)* 100 ) / 100;
                                            double plus15 = Math.round( ( plus14 + plus10 * 2.95)* 100 ) / 100;
                                            double plus16 = Math.round( ( plus15 + plus10 * 2.95)* 100 ) / 100;
                                            double plus17 = Math.round( ( plus16 + plus10 * 2.95)* 100 ) / 100;
                                            double plus18 = Math.round( ( plus17 + plus10 * 2.95)* 100 ) / 100;
                                            double plus19 = Math.round( ( plus18 + plus10 * 2.95)* 100 ) / 100;
                                            double plus191 =Math.round( ( plus19 + plus10 * 2.95)* 100 ) / 100;


                                            Log.d("calc", "plus 10 to 191 ----" + plus10);
                                            Log.d("calc", "plus 10 to 191 ----" + plus11);
                                            Log.d("calc", "plus 10 to 191 ----" + plus12);
                                            Log.d("calc", "plus 10 to 191 ----" + plus13);
                                            Log.d("calc", "plus 10 to 191 ----" + plus14);
                                            Log.d("calc", "plus 10 to 191 ----" + plus15);
                                            Log.d("calc", "plus 10 to 191 ----" + plus16);
                                            Log.d("calc", "plus 10 to 191 ----" + plus17);
                                            Log.d("calc", "plus 10 to 191 ----" + plus18);
                                            Log.d("calc", "plus 10 to 191 ----" + plus19);
                                            Log.d("calc", "plus 10 to 191 ----" + plus191);



                                            //x좌표
                                            number0 = result1 + (result3-result1) * 1 / 27 ;
                                            number1 = result1 + (result3-result1) * 4 / 27;
                                            number2 = result1 + (result3-result1) * 7 / 27;
                                            number3 = result1 + (result3-result1) * 10 / 27;
                                            number4 = result1 + (result3-result1) * 13 / 27;
                                            number5 = result1 + (result3-result1) * 16 / 27;
                                            number6 = result1 + (result3-result1) * 19 / 27;
                                            number7 = result1 + (result3-result1) * 22 / 27;
                                            number8 = result1 + (result3-result1) * 25 / 27;
                                            number9 = result1 + (result3-result1) * 28 / 27;
                                            number91 = result1 + (result3-result1) * 31/ 27;

                                            ss1 = (int) number0;
                                            ss2 = (int) number1;
                                            ss3 = (int) number2;
                                            ss4 = (int) number3;
                                            ss5 = (int) number4;
                                            ss6 = (int) number5;
                                            ss7 = (int) number6;
                                            ss8 = (int) number7;
                                            ss9 = (int) number8;
                                            ss10 = (int) number9;
                                            ss11 = (int) number91;

                                            //y좌표

                                            number10 = result2 + (result4-result2) * 1 / 27;
                                            number11 = result2 + (result4-result2) * 4 / 27;
                                            number12 = result2 + (result4-result2) * 7 / 27;
                                            number13 = result2 + (result4-result2) * 10 / 27;
                                            number14 = result2 + (result4-result2) * 13 / 27;
                                            number15 = result2 + (result4-result2) * 16 / 27;
                                            number16 = result2 + (result4-result2) * 19 / 27;
                                            number17 = result2 + (result4-result2) * 22 / 27;
                                            number18 = result2 + (result4-result2) * 25 / 27;
                                            number19 = result2 + (result4-result2) * 28 / 27;
                                            number191 = result2 + (result4-result2) * 31 / 27;

                                            ss20 = (int)number10;
                                            ss21 = (int)number11;
                                            ss22 = (int)number12;
                                            ss23 = (int)number13;
                                            ss24 = (int)number14;
                                            ss25 = (int)number15;
                                            ss26 = (int)number16;
                                            ss27 = (int)number17;
                                            ss28 = (int)number18;
                                            ss29 = (int)number19;
                                            ss30 = (int)number191;






                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number0, number10),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );

                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number1, number11),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );
                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number2, number12),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );

                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number3, number13),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );
                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number4, number14),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );

                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number5, number15),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );
                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number6, number16),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );

                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number7, number17),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );
                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number8, number18),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );

                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number9, number19),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );
                                            Imgproc.circle (
                                                    dst,                 //Matrix obj of the image
                                                    new Point(number91, number191),    //Center of the circle
                                                    10,                    //Radius
                                                    new Scalar(255, 0, 0),  //Scalar object for color
                                                    3                  //Thickness of the circle
                                            );


                                        }
                                    }

                                }
                            }

                        }


                        /*number0 = min2;
                        number1 = (max1 - min2) * 2/ 26;
                        number2 = (max1 - min2) * 3/ 26;
                        number3 = (max1 - min2) * 5/ 26;




                        number4 = (max1 - min2) * 6/ 26;

                        number5 = (max1 - min2) * 8/ 26;

                        number6 = (max1 - min2) * 9/ 26;
                        number7 = (max1 - min2) * 11/ 26;
                        number8 = (max1 - min2) * 12/ 26;
                        number9 = (max1 - min2) * 14/ 26;
                        number10 = (max1 - min2) * 15/ 26;
                        number11 = (max1 - min2) * 17/ 26;
                        number12 = (max1 - min2) * 18/ 26;
                        number13 = (max1 - min2) * 20/ 26;
                        number14 = (max1 - min2) * 21/ 26;
                        number15 = (max1 - min2) * 23/ 26;
                        number16 = (max1 - min2) * 24/ 26;
                        number17 = (max1 - min2) * 1;


                        number18 = (max1 - min2) * 1/ 26;

 */


                       // Imgproc.rectangle(dst, new Point(max1  , min1), new Point(
                       //         min2  , max2  ), new Scalar( 255, 255, 255 ), 10
                       // );


/*
                        Imgproc.rectangle(dst, new Point(min2 +number1, min1 + (number18 * 2.5)), new Point(
                                min2  , max2 - (number18 * 2.5)  ), new Scalar(  0, 255 ,0), 5
                        );

                        Imgproc.rectangle(dst, new Point(min2 +number3, min1 + (number18 * 2.5)), new Point(
                                min2 +number2 , max2 - (number18 * 2.5)  ), new Scalar(  0, 255 ,0), 5
                        );

                        Imgproc.rectangle(dst, new Point(min2 +number5, min1 + (number18 * 2.5)), new Point(
                                min2 +number4 , max2 - (number18 * 2.5)), new Scalar(  0, 255 ,0), 5
                        );

                        Imgproc.rectangle(dst, new Point(min2 +number7, min1 + (number18 * 2.5)), new Point(
                                min2 +number6 , max2 - (number18 * 2.5) ), new Scalar(  0, 255 ,0), 5
                        );
                        Imgproc.rectangle(dst, new Point(min2 +number9, min1 + (number18 * 2.5)), new Point(
                                min2 +number8 , max2 - (number18 * 2.5) ), new Scalar(  0, 255 ,0), 5
                        );
                        Imgproc.rectangle(dst, new Point(min2 +number11, min1 + (number18 * 2.5)), new Point(
                                min2 +number10 , max2 - (number18 * 2.5) ), new Scalar(  0, 255 ,0), 5
                        );
                        Imgproc.rectangle(dst, new Point(min2 +number13, min1 + (number18 * 2.5)), new Point(
                                min2 +number12, max2 - (number18 * 2.5) ), new Scalar(  0, 255 ,0), 5
                        );
                        Imgproc.rectangle(dst, new Point(min2 +number15, min1 + (number18 * 2.5)), new Point(
                                min2 +number14 , max2 - (number18 * 2.5) ), new Scalar(  0, 255 ,0), 5
                        );

                        Imgproc.rectangle(dst, new Point(min2 +number17, min1 + (number18 * 2.5)), new Point(
                                min2 +number16, max2 - (number18 * 2.5) ), new Scalar(  0, 255 ,0), 5
                        );

                        Imgproc.rectangle(dst, new Point(max1 + (number18 * 1), min1 + (number18 * 2.5)), new Point(
                                max1 + (number18 * 3), max2 - (number18 * 2.5) ), new Scalar( 0, 255 ,0 ), 5
                        );

*/





                        Imgproc.putText(dst, "dude!"+ testNumber, new Point(w * 15 / 18, h * 2 / 7), 3, 1, new Scalar(0, 255, 0), 2);
                        Imgproc.rectangle(dst, new Point(w * 5 / 18, h * 1 / 7), new Point(
                                w * 13 / 18, h * 6 / 7), new Scalar(0, 255, 0), 10
                        );












                        File path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                        String filename = "barry2.png";
                        File file = new File(path, filename);

                        Boolean bool = null;
                        filename = file.toString();
                        bool = imwrite(filename, dst);

                        if (bool == true)
                            Log.d("tata", "SUCCESS writing image to external storage");
                        else
                            Log.d("tata", "Fail writing image to external storage");





                        double[] colors = dst.get(ss20, ss1);
                        double[] colors1 = dst.get(ss21, ss2);
                        double[] colors2 = dst.get(ss22, ss3);
                        double[] colors3 = dst.get(ss23, ss4);
                        double[] colors4 = dst.get(ss24, ss5);
                        double[] colors5 = dst.get(ss25, ss6);
                        double[] colors6 = dst.get(ss26, ss7);
                        double[] colors7 = dst.get(ss27, ss8);
                        double[] colors8 = dst.get(ss28, ss9);
                        double[] colors9 = dst.get(ss29, ss10);
                        double[] colors10 = dst.get(ss30, ss11);



                        String message1 = Double.toString(colors[0]);
                        String message2 = Double.toString(colors1[0]);
                        String message3 = Double.toString(colors2[0]);
                        String message4 = Double.toString(colors3[0]);
                        String message5 = Double.toString(colors4[0]);
                        String message6 = Double.toString(colors5[0]);
                        String message7 = Double.toString(colors6[0]);
                        String message8 = Double.toString(colors7[0]);
                        String message9 = Double.toString(colors8[0]);
                        String message10 = Double.toString(colors9[0]);
                        String message11 = Double.toString(colors[1]);
                        String message12 = Double.toString(colors1[1]);
                        String message13 = Double.toString(colors2[1]);
                        String message14 = Double.toString(colors3[1]);
                        String message15 = Double.toString(colors4[1]);
                        String message16 = Double.toString(colors5[1]);
                        String message17 = Double.toString(colors6[1]);
                        String message18 = Double.toString(colors7[1]);
                        String message19 = Double.toString(colors8[1]);
                        String message20 = Double.toString(colors9[1]);
                        String message21 = Double.toString(colors[2]);
                        String message22 = Double.toString(colors1[2]);
                        String message23 = Double.toString(colors2[2]);
                        String message24 = Double.toString(colors3[2]);
                        String message25 = Double.toString(colors4[2]);
                        String message26 = Double.toString(colors5[2]);
                        String message27 = Double.toString(colors6[2]);
                        String message28 = Double.toString(colors7[2]);
                        String message29 = Double.toString(colors8[2]);
                        String message30 = Double.toString(colors9[2]);






                        //다음 화면으로 넘어가는 로직


                        Intent registerIntent = new Intent(MainActivity.this, AfterDetectActivity.class);



                        registerIntent.putExtra("EXTRA_MESSAGE1",message1);
                        registerIntent.putExtra("EXTRA_MESSAGE2",message2);
                        registerIntent.putExtra("EXTRA_MESSAGE3",message3);
                        registerIntent.putExtra("EXTRA_MESSAGE4",message4);
                        registerIntent.putExtra("EXTRA_MESSAGE5",message5);
                        registerIntent.putExtra("EXTRA_MESSAGE6",message6);
                        registerIntent.putExtra("EXTRA_MESSAGE7",message7);
                        registerIntent.putExtra("EXTRA_MESSAGE8",message8);
                        registerIntent.putExtra("EXTRA_MESSAGE9",message9);
                        registerIntent.putExtra("EXTRA_MESSAGE10",message10);
                        registerIntent.putExtra("EXTRA_MESSAGE11",message11);
                        registerIntent.putExtra("EXTRA_MESSAGE12",message12);
                        registerIntent.putExtra("EXTRA_MESSAGE13",message13);
                        registerIntent.putExtra("EXTRA_MESSAGE14",message14);
                        registerIntent.putExtra("EXTRA_MESSAGE15",message15);
                        registerIntent.putExtra("EXTRA_MESSAGE16",message16);
                        registerIntent.putExtra("EXTRA_MESSAGE17",message17);
                        registerIntent.putExtra("EXTRA_MESSAGE18",message18);
                        registerIntent.putExtra("EXTRA_MESSAGE19",message19);
                        registerIntent.putExtra("EXTRA_MESSAGE20",message20);
                        registerIntent.putExtra("EXTRA_MESSAGE21",message21);
                        registerIntent.putExtra("EXTRA_MESSAGE22",message22);
                        registerIntent.putExtra("EXTRA_MESSAGE23",message23);
                        registerIntent.putExtra("EXTRA_MESSAGE24",message24);
                        registerIntent.putExtra("EXTRA_MESSAGE25",message25);
                        registerIntent.putExtra("EXTRA_MESSAGE26",message26);
                        registerIntent.putExtra("EXTRA_MESSAGE27",message27);
                        registerIntent.putExtra("EXTRA_MESSAGE28",message28);
                        registerIntent.putExtra("EXTRA_MESSAGE29",message29);
                        registerIntent.putExtra("EXTRA_MESSAGE30",message30);




                        MainActivity.this.startActivity(registerIntent);
                        //
                        //startActivityForResult(cameraIntent, 0);



                    }

                }
            }

        }
        return dst;
    }
    @Override
    protected void onPause() {
        super.onPause();
        if (cameraBridgeViewBase != null) {
            cameraBridgeViewBase.disableView();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        if (!OpenCVLoader.initDebug()) {
            Toast.makeText(getApplicationContext(), "There is a problem", Toast.LENGTH_SHORT).show();
        } else {
            baseLoaderCallback.onManagerConnected(BaseLoaderCallback.SUCCESS);
        }
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (cameraBridgeViewBase != null) {
            cameraBridgeViewBase.disableView();
        }
    }




    private static final int CAMERA_REQUEST = 100;
    private static final int STORAGE_PERMISSION_CODE = 1;

    //protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//
//        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
//        Intent intent = new Intent(MainActivity.this, AfterDetectActivity.class);
//        intent.putExtra("image", thumbnail);
//        startActivity(intent);
//
  //  }

    private static double angle(Point pt1, Point pt2, Point pt0) {
        double dx1 = pt1.x - pt0.x;
        double dy1 = pt1.y - pt0.y;
        double dx2 = pt2.x - pt0.x;
        double dy2 = pt2.y - pt0.y;
        return (dx1 * dx2 + dy1 * dy2) / Math.sqrt((dx1 * dx1 + dy1 * dy1) * (dx2 * dx2 + dy2 * dy2) + 1e-10);
    }
    private void setLabel(Mat im, String label, MatOfPoint contour) {
        int fontface = Core.FONT_HERSHEY_SIMPLEX;
        double scale = 1;//0.4;
        int thickness = 2;//1;
        int[] baseline = new int[1];
        Size text = Imgproc.getTextSize(label, fontface, scale, thickness, baseline);
        Rect r = Imgproc.boundingRect(contour);
        Point pt = new Point(r.x + ((r.width - text.width) / 2),r.y + ((r.height + text.height) / 2));
        Imgproc.putText(im, label, pt, fontface, scale, new Scalar(255, 0, 0), thickness);
    }
}





















