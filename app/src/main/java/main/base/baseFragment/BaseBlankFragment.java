package main.base.baseFragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.phd91.m_nurse.R;

import main.base.baseFragmentPresenter.BaseFragmentPresenter;


/**
 * Created by hzdengliuyitai on 2016/8/22.
 */
public abstract class BaseBlankFragment<T extends BaseFragmentPresenter>
        extends BaseFragment<T> {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        initContentView();
        return rootView;
    }

    @Override
    protected void inflateRootView(LayoutInflater inflater) {
        rootView = (FrameLayout) inflater.inflate(R.layout.activity_blank, null);
    }

    private void initContentView() {
        contentView = (FrameLayout) rootView.findViewById(R.id.content_view);
//        contentView.setOnSlidingFinishListener(this);

        touchView = rootView.findViewById(R.id.touch_view);
//        contentView.setTouchView(touchView);
    }
}
