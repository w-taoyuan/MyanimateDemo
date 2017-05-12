package m520it.com.myanimatedamo;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTv = (TextView) findViewById(R.id.tv);

    }
    public void click(View v){
//        ObjectAnimator.ofFloat(mTv,"");
//        ObjectAnimator a1 = ObjectAnimator.ofFloat(mTv, "alpha", 1.0f, 0f);
//        ObjectAnimator a2 = ObjectAnimator.ofFloat(mTv, "translationY", 0f, mTv.getWidth());
//        AnimatorSet animSet = new AnimatorSet();
//        animSet.setDuration(5000);
//        animSet.setInterpolator(new LinearInterpolator());
//animSet.playTogether(a1, a2, ...); //两个动画同时执行
//        animSet.play(a1).after(a2); //先后执行
        //其他组合方式
//        animSet.start();
        ValueAnimator animator = ValueAnimator.ofInt(0,600);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                mTv.layout(mTv.getLeft(),curValue,mTv.getRight(),curValue+mTv.getHeight());
            }
        });
        animator.setDuration(1000);
        animator.setInterpolator(new BounceInterpolator());
        animator.start();
//        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:12345678");
//        startActivity(callIntent);
    }
}
