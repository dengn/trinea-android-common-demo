package com.trinea.common.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.trinea.common.R;
import com.trinea.common.view.CompoundDrawablesTextView;
import com.trinea.common.view.CompoundDrawablesTextView.DrawableClickListener;

/**
 * 一个可以响应CompoundDrawables点击操作的TextView的Demo
 * 
 * @author Trinea 2012-6-15 上午10:34:34
 */
public class CompoundDrawablesTextViewDemo extends Activity {

    protected Context                 context       = null;
    private CompoundDrawablesTextView textWithImage = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.compound_drawables_textview_demo);
        context = getApplicationContext();

        textWithImage = (CompoundDrawablesTextView)findViewById(R.id.compoundDrawablesTextView);
        textWithImage.setText("点击相应图片查看效果");
        textWithImage.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(context, "click", Toast.LENGTH_SHORT).show();
            }
        });

        // 设置图片及图片点击的listener
        textWithImage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.image, R.drawable.image, R.drawable.image,
                                                              R.drawable.image);
        // 也可以试试某个图片不存在的情况
        // textWithImage.setCompoundDrawablesWithIntrinsicBounds(R.drawable.image, 0, R.drawable.image,
        // R.drawable.image);
        textWithImage.setDrawableClickListener(new ImageClickListener());

        textWithImage.setAllDrawableTouchedResponse(true);
        // 试试不同的效果
        // textWithImage.setAllDrawableTouchedResponse(false);
        textWithImage.setAlwaysClick(true);
        // textWithImage.setAlwaysClick(false);
    }

    class ImageClickListener implements DrawableClickListener {

        @Override
        public void onClick(DrawablePosition position) {
            switch (position) {
                case LEFT:
                    // 左边图片被点击的响应
                    Toast.makeText(context, "left", Toast.LENGTH_SHORT).show();
                    break;
                case RIGHT:
                    // 右边图片被点击的响应
                    Toast.makeText(context, "right", Toast.LENGTH_SHORT).show();
                    break;
                case BOTTOM:
                    // 底部图片被点击的响应
                    Toast.makeText(context, "bottom", Toast.LENGTH_SHORT).show();
                    break;
                case TOP:
                    // 上边图片被点击的响应
                    Toast.makeText(context, "top", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }
        }
    };
}
