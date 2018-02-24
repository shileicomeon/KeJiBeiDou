package bwei.com.kejibeidou;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.OnClick;
import bwei.com.kejibeidou.base.BaseActivity;
import bwei.com.kejibeidou.fragment.FourFragment;
import bwei.com.kejibeidou.fragment.OneFragment;
import bwei.com.kejibeidou.fragment.ThreeFragment;
import bwei.com.kejibeidou.fragment.TwoFragment;

public class MainActivity extends BaseActivity {
    private int mIndex;
    @BindView(R.id.frameLayout)
    FrameLayout mFrameLayout;
    @BindView(R.id.radio01)
    LinearLayout mRadio01;
    @BindView(R.id.radio02)
    LinearLayout mRadio02;
    @BindView(R.id.radio03)
    LinearLayout mRadio03;
    @BindView(R.id.radio04)
    LinearLayout mRadio04;
    @BindView(R.id.group)
    RadioGroup mGroup;
    private Fragment[] mFragments;
    @Override
    protected int getRootView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
      initFragment();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void processClick(View v) {

    }
    private void initFragment() {
        //首页
        OneFragment oneFragment =new OneFragment();
        TwoFragment twoFragment = new TwoFragment();
        ThreeFragment threeFragment = new ThreeFragment();
        FourFragment fourFragment = new FourFragment();

        //添加到数组
        mFragments = new Fragment[]{oneFragment,twoFragment,threeFragment,fourFragment};

        //开启事务

        FragmentTransaction ft =
                getSupportFragmentManager().beginTransaction();

        //添加首页
        ft.add(R.id.frameLayout,oneFragment).commit();

        //默认设置为第0个
        setIndexSelected(0);


    }



    private void setIndexSelected(int index) {

        if(mIndex==index){
            return;
        }
        FragmentManager    fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft              = fragmentManager.beginTransaction();


        //隐藏
        ft.hide(mFragments[mIndex]);
        //判断是否添加
        if(!mFragments[index].isAdded()){
            ft.add(R.id.frameLayout,mFragments[index]).show(mFragments[index]);
        }else {
            ft.show(mFragments[index]);
        }

        ft.commit();
        //再次赋值
        mIndex=index;

    }

    @Override
    @OnClick({R.id.radio01, R.id.radio02, R.id.radio03, R.id.radio04})
    public void onClick(View view) {

        switch (view.getId()) {
            default:break;
            case R.id.radio01:
                setIndexSelected(0);
                break;
            case R.id.radio02:
                setIndexSelected(1);
                break;
            case R.id.radio03:
                setIndexSelected(2);
                break;
            case R.id.radio04:
                setIndexSelected(3);
                break;
        }

    }
}
