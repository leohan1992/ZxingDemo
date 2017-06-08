package xyz.leohan.zxingdemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.widget.Toast;

import com.google.zxing.Result;
import com.google.zxing.client.android.BaseCaptureActivity;
import com.google.zxing.client.android.ViewfinderView;

/**
 * Created by leo on 2017/6/8.
 * a default use
 */

public class DefaultCaptureActivity extends BaseCaptureActivity {

    private static final String TAG = DefaultCaptureActivity.class.getSimpleName();

    private SurfaceView surfaceView;
    private ViewfinderView viewfinderView;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_capture);
        surfaceView = (SurfaceView) findViewById(R.id.preview_view);
        viewfinderView = (ViewfinderView) findViewById(R.id.viewfinder_view);
        intent = getIntent();
    }

    @Override
    public SurfaceView getSurfaceView() {
        return (surfaceView == null) ? (SurfaceView) findViewById(R.id.preview_view) : surfaceView;
    }

    @Override
    public ViewfinderView getViewfinderHolder() {
        return (viewfinderView == null) ? (ViewfinderView) findViewById(R.id.viewfinder_view) : viewfinderView;
    }

    @Override
    public void dealDecode(Result rawResult, Bitmap barcode, float scaleFactor) {
        Log.i(TAG, "dealDecode ~~~~~ " + rawResult.getText() + " " + barcode + " " + scaleFactor);
        playBeepSoundAndVibrate();
        Toast.makeText(this, rawResult.getText(), Toast.LENGTH_LONG).show();
        intent.putExtra("rawResult", rawResult.getText());
        setResult(Activity.RESULT_OK, intent);
        this.finish();
//        对此次扫描结果不满意可以调用
//        reScan(); you can also do rescan when necessary
    }
}