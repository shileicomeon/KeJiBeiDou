package bwei.com.kejibeidou.base;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import butterknife.ButterKnife;

/**
 * Created by QinQinBaoBei on 2018/1/22.
 */

    public abstract class BaseFragment extends Fragment {
        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            return inflater.inflate(bindLayout(),container,false);
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            initView();
            initData();
            bindEvent();
        }
        //绑定视图
        protected abstract int bindLayout();
        //绑定组件
        protected abstract void initView();
        //操作数据
        protected abstract void initData();
        //设置监听
        protected abstract void bindEvent();

        protected <T extends View > T bindView(int resId){
            return (T) getView().findViewById(resId);
        }
        //绑定某个特定的视图
        protected <T extends View> T bindView(View view ,int resId){

            return (T) view.findViewById(resId);
        }

}
