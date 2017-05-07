package main.base.baseFragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.lang.ref.WeakReference;

import main.application.ISubscriber;
import main.base.baseFragmentPresenter.BaseFragmentPresenter;


/**
 * Created by hzdengliuyitai on 2016/8/22.
 */
public abstract class BaseFragment<T extends BaseFragmentPresenter> extends Fragment implements ISubscriber {
    protected T presenter;
    protected FrameLayout rootView;
    protected WeakReference<View> rootViewRef;
    /**
     * 用于监听滑动的view
     */
    protected FrameLayout contentView;
    protected View touchView;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (presenter != null) {
            presenter.onAttach();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initPresenter();
        if (presenter != null) {
            presenter.onCreate();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        inflateRootView(inflater);
        if (presenter != null) {
            presenter.onCreateView();
        }
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter != null) {
            presenter.onActivityCreated(savedInstanceState);
        }
    }

    /**
     * Inflate a content view for the activity.
     *
     * @param resId ID for an XML layout resource as the content view
     */
    public void setRealContentView(@LayoutRes int resId) {
        getActivity().getLayoutInflater().inflate(resId, contentView);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (presenter != null) {
            presenter.onStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (presenter != null) {
            presenter.onPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (presenter != null) {
            presenter.onStop();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null) {
            presenter.onDestroyView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter != null) {
            presenter.onDestroy();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if (presenter != null) {
            presenter.onDetach();
        }
    }

    abstract protected void initPresenter();



    protected void inflateRootView(LayoutInflater inflater) {
    }



}
