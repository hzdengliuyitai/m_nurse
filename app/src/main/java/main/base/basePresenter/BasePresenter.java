package main.base.basePresenter;

/**
 * Created by hzdengliuyitai on 2016/8/22.
 */
public abstract class BasePresenter<T> {
    protected T target;

    public BasePresenter(T target) {
        this.target = target;
    }

    public void onCreate() {
    }

    public void onStart() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStop() {

    }

    public void onDestroy() {
    }


}
