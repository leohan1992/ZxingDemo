package xyz.leohan.zxingdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int RESULT_CODE_CAPTURE_WECHAT = 0;
    private static final int RESULT_CODE_CAPTURE_DEFAULT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startWeChatCapture(View view) {
        //just for demo,I do not check the Runtime permission
        //remember to do it in real project
        Intent intent = new Intent(this, CaptureActivity.class);
        startActivityForResult(intent,RESULT_CODE_CAPTURE_WECHAT);
    }

    public void startDefaultCapture(View view) {
        //just for demo,I do not check the Runtime permission
        //remember to do it in real project
        Intent intent=new Intent(this,DefaultCaptureActivity.class);
        startActivityForResult(intent,RESULT_CODE_CAPTURE_DEFAULT);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case RESULT_CODE_CAPTURE_WECHAT:
                //TODO do something
                break;
            case RESULT_CODE_CAPTURE_DEFAULT:
                //TODO do something
                break;
        }
    }
}
