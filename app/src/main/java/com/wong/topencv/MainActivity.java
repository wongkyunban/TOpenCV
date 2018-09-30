package com.wong.topencv;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.wong.topencv.adapter.SectionsAdapter;
import com.wong.topencv.bean.ItemBean;
import com.wong.topencv.inter.OnItemViewClickListener;

import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRv;
    private SectionsAdapter<ItemBean> adapter;
    private List<ItemBean> list = new ArrayList<>();
    private String[] titles = new String[]{
            "OpenCV Android 开发框架",
            "Mat与Bitmap对象",
            "Mat像素操作",
            "图像操作",
            "基本特征检测",
            "特征检测与匹配",
            "相机使用",
            "OpenCV4Android应用实践",
            "人脸美颜",
            "人眼实时跟踪与渲染"};
    private Paint mPaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRv = (RecyclerView)findViewById(R.id.rv_list_view);
        mRv.setLayoutManager(new LinearLayoutManager(this));

        for(int i =0;i<10;i++){

            list.add(new ItemBean(i,titles[i]));
        }


        adapter = new SectionsAdapter<>(list);
        adapter.setListener(new OnItemViewClickListener<ItemBean>() {
            @Override
            public void onClick(ItemBean bean) {

                switch (bean.getId()){
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:

                        break;
                }

            }
        });
        mPaint = new Paint();
        mRv.setAdapter(adapter);
        mRv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
                super.onDraw(c, parent, state);

                mPaint.setAntiAlias(true);
                mPaint.setARGB(238,238,238,238);
                int childCount = parent.getChildCount();

                for ( int i = 0; i < childCount; i++ ) {
                    View view = parent.getChildAt(i);

                    int index = parent.getChildAdapterPosition(view);
                    //第一个ItemView不需要绘制
                    if (index == 0) {
                        continue;
                    }

                    float dividerTop = view.getTop() - 2;
                    float dividerLeft = parent.getPaddingLeft()+20;
                    float dividerBottom = view.getTop();
                    float dividerRight = parent.getWidth() - parent.getPaddingRight()-20;


                    c.drawRect(dividerLeft, dividerTop, dividerRight, dividerBottom, mPaint);
                }
            }

        });

//        initLoadOpenCV();
//        findViewById(R.id.btn_process).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bitmap bitmap = BitmapFactory.decodeResource(MainActivity.this.getResources(),R.drawable.pic);
//                Mat src = new Mat();
//                Mat dst = new Mat();
//                Utils.bitmapToMat(bitmap,src);
//                Imgproc.cvtColor(src,dst, Imgproc.COLOR_BGRA2GRAY);
//                Utils.matToBitmap(dst,bitmap);
//                ImageView iv = (ImageView)MainActivity.this.findViewById(R.id.iv_img);
//                iv.setImageBitmap(bitmap);
//                src.release();
//                dst.release();
//            }
//        });
    }
//    private void initLoadOpenCV(){
//        boolean success = OpenCVLoader.initDebug();
//        if(success){
//            Toast.makeText(this,"OpenCV Libraries loaded...",Toast.LENGTH_SHORT).show();
//        }else{
//            Toast.makeText(this,"Can not load OpenCV Libraries...",Toast.LENGTH_SHORT).show();
//
//        }
//    }
}
