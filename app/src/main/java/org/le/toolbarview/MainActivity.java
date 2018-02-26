package org.le.toolbarview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import org.le.toolbar.ToolBarView;
import org.le.toolbar.interfaces.OnToolBarViewListener;

public class MainActivity extends AppCompatActivity implements OnToolBarViewListener{

    ToolBarView toolBarView;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);//取消标题栏
        toast = Toast.makeText(this,"",Toast.LENGTH_SHORT);
        setContentView(R.layout.activity_main);
        toolBarView = findViewById(R.id.toolBarView);
        toolBarView
                .setTitle("标题",18, Color.BLACK)
                .setLeftVisible(true,false)
                .setRightVisible(true,false)
                .setOnToolBarClickListener(this)
                .show();
    }

    @Override
    public void onToolBarLeftClickListener() {
        toast.setText("点击的左边");
        toast.show();
    }

    @Override
    public void onToolBarTitleClickListener(TextView title) {
        toast.setText("点击的title");
        toast.show();
        title.setText("我被点击了");
    }

    @Override
    public void onToolBarRightClickListener() {
        toast.setText("点击的右边");
        toast.show();
    }
}
