package kr.ac.kpu.ondot.Main;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import kr.ac.kpu.ondot.Board.BoardMain;
import kr.ac.kpu.ondot.CustomTouch.CustomTouchConnectListener;
import kr.ac.kpu.ondot.CustomTouch.CustomTouchEvent;
import kr.ac.kpu.ondot.CustomTouch.CustomTouchEventListener;
import kr.ac.kpu.ondot.CustomTouch.FingerFunctionType;
import kr.ac.kpu.ondot.Educate.EducateMain;
import kr.ac.kpu.ondot.Quiz.QuizMain;
import kr.ac.kpu.ondot.R;
import kr.ac.kpu.ondot.Screen;
import kr.ac.kpu.ondot.Translate.TranslateMain;

public class MainActivity extends AppCompatActivity implements CustomTouchEventListener {
    private final String DEBUG_TYPE = "type";

    private ViewPager mViewpager;
    private MainPagerAdapter mAdapter;
    private int currentView;

    private CustomTouchConnectListener customTouchConnectListener;
    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDisplaySize();
        initTouchEvent();

        mViewpager = findViewById(R.id.main_viewpager);
        mAdapter = new MainPagerAdapter(getSupportFragmentManager());
        mViewpager.setAdapter(mAdapter);
        mViewpager.setClipToPadding(false);

        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                currentView = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public void activitySwitch(int currentView) {
        Intent intent;
        switch (currentView) {
            case 0:
                intent =  new Intent(MainActivity.this, EducateMain.class);
                startActivity(intent);
                break;
            case 1:
                intent =  new Intent(MainActivity.this, QuizMain.class);
                startActivity(intent);
                break;
            case 2:
                intent =  new Intent(MainActivity.this, TranslateMain.class);
                startActivity(intent);
                break;
            case 3:
                intent =  new Intent(MainActivity.this, BoardMain.class);
                startActivity(intent);
                break;
        }
    }

    private void initTouchEvent() {
        customTouchConnectListener = new CustomTouchEvent(this, this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(customTouchConnectListener != null){
            customTouchConnectListener.touchEvent(event);
        }

        return false;


        /*switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                activitySwitch(currentView);
                break;
        }

        return false;*/
    }

    // 해상도 구하기
    private void initDisplaySize(){
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);




        Screen.displayX = size.x;
        Screen.displayY = size.y;
    }

    @Override
    public void onOneFingerFunction(FingerFunctionType fingerFunctionType) {

        /*runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(fingerFunctionType == FingerFunctionType.ENTER){
                    Toast.makeText(getApplicationContext(),"ENTER",Toast.LENGTH_SHORT).show();
                }else if(fingerFunctionType == FingerFunctionType.LEFT){
                    Toast.makeText(getApplicationContext(),"LEFT",Toast.LENGTH_SHORT).show();
                }else if(fingerFunctionType == FingerFunctionType.RIGHT){
                    Toast.makeText(getApplicationContext(),"RIGHT",Toast.LENGTH_SHORT).show();
                }else if(fingerFunctionType == FingerFunctionType.UP){
                    Toast.makeText(getApplicationContext(),"UP",Toast.LENGTH_SHORT).show();
                }else if(fingerFunctionType == FingerFunctionType.DOWN){
                    Toast.makeText(getApplicationContext(),"DOWN",Toast.LENGTH_SHORT).show();
                }else if(fingerFunctionType == FingerFunctionType.LONG){
                    Toast.makeText(getApplicationContext(),"LONG",Toast.LENGTH_SHORT).show();
                }else if(fingerFunctionType == FingerFunctionType.NONE){
                    Toast.makeText(getApplicationContext(),"NONE",Toast.LENGTH_SHORT).show();
                }

            }
        });*/


        Log.d(DEBUG_TYPE,"MainActivity - fingerFunctionType : " + fingerFunctionType);
        if(fingerFunctionType == FingerFunctionType.ENTER){
            activitySwitch(currentView);

            Log.d(DEBUG_TYPE,"MainActivity - fingerFunctionType : " + fingerFunctionType);
        }
    }

    @Override
    public void onTwoFingerFunction(FingerFunctionType fingerFunctionType) {
        switch (fingerFunctionType){
            case BACK:
                Toast.makeText(this,"BACK",Toast.LENGTH_SHORT).show();
                break;
            case SPECIAL:
                Toast.makeText(this,"SPECIAL",Toast.LENGTH_SHORT).show();
                break;
            case NONE:
                Toast.makeText(this,"NONE",Toast.LENGTH_SHORT).show();
                break;

        }
    }
}
