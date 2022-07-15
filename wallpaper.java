package com.example.wallpapernew;
import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
public class MainActivity extends AppCompatActivity implements
        View.OnClickListener {
    Button btn;
    Boolean Running = false;
    int[] ia = new int[]{R.drawable.img, R.drawable.img_1,
            R.drawable.img_2,R.drawable.img_3,R.drawable.img_4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn_wall);
        btn.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if (!Running) {
            new Timer().schedule(new MyTimer(), 0, 5000);
            Running = true;
        }
    }
    private class MyTimer extends TimerTask {
        public void run() {
            try { WallpaperManager wallpaperManager = WallpaperManager.getInstance(getBaseContext());
                Random random = new Random();
                int randomInt = random.nextInt(3);
                Bitmap bitmap =
                        BitmapFactory.decodeResource(getResources(), ia[randomInt]);

                wallpaperManager.setBitmap(bitmap);
                
            } catch (IOException e) {
                e.printStackTrace();

            }
        }
    }
}
