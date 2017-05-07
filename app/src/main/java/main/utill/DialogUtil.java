package main.utill;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.phd91.m_nurse.R;

import main.commonview.PopupWindowView;


/**
 * Created by hzdengliuyitai on 2016/9/7.
 */
public class DialogUtil {

    public interface IClick {
        /**
         * @param viewId     点击按钮控件的id
         * @param operatorId 操作的id，外面传进来
         * @return true，dismiss当前对话框；false，不dismiss
         */
        boolean onDialogClick(int viewId, int operatorId);
    }


    public static void showStatusDialog(Context context,
                                        View rootView,
                                        final IClick positiveBtnClick,
                                        final IClick negativeBtnClick,
                                        String tittle,
                                        String content,
                                        String positivebtn,
                                        String negtivebtn,
                                        final int operatorId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.alert_dialog);
        final View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_show_status_layout, null);
        builder.setView(dialogView);
        final PopupWindowView popMenses = new PopupWindowView(context, Gravity.CENTER);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        popMenses.addSubView(dialogView, layoutParams);

        TextView tittleview = (TextView) dialogView.findViewById(R.id.dialog_report_tittle);
        TextView contentview = (TextView) dialogView.findViewById(R.id.dialog_report_content);
        Button btnNegative = (Button) dialogView.findViewById(R.id.btn_alert_negative);
        Button btnPositive = (Button) dialogView.findViewById(R.id.btn_alert_positive);

        tittleview.setText(tittle);
        contentview.setText(content);
        btnNegative.setText(negtivebtn);
        btnPositive.setText(positivebtn);

        popMenses.setOutSideTouchListener(new PopupWindowView.OutsideTouchListener() {
            @Override
            public void outsideTouchListener() {
                Log.i("setOutSideTouchListener", "outsideTouchListener: ");
            }
        });

        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDismiss = (positiveBtnClick != null) ? positiveBtnClick.onDialogClick(v.getId(), operatorId) : true;
                if (isDismiss) popMenses.dismiss();
            }
        });

        if (negativeBtnClick == null) {
            btnNegative.setVisibility(View.GONE);
        } else {

            btnNegative.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isDismiss = (negativeBtnClick != null) ? negativeBtnClick.onDialogClick(v.getId(), operatorId) : true;
                    if (isDismiss) popMenses.dismiss();
                }
            });
        }
        popMenses.showInCenter(rootView, true);
    }

    public static void showMsgDialog(Context context,
                                        View rootView,
                                        final IClick positiveBtnClick,
                                        String tittle,
                                        String content,
                                        String positivebtn,
                                        final int operatorId) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context, R.style.alert_dialog);
        final View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_show_msg, null);
        builder.setView(dialogView);
        final PopupWindowView popMenses = new PopupWindowView(context, Gravity.CENTER);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        popMenses.addSubView(dialogView, layoutParams);

        TextView tittleview = (TextView) dialogView.findViewById(R.id.dialog_report_tittle);
        TextView contentview = (TextView) dialogView.findViewById(R.id.dialog_report_content);

        Button btnPositive = (Button) dialogView.findViewById(R.id.btn_alert_positive);
        tittleview.setText(tittle);
        contentview.setText(content);
        btnPositive.setText(positivebtn);
        popMenses.setOutSideTouchListener(new PopupWindowView.OutsideTouchListener() {
            @Override
            public void outsideTouchListener() {
                Log.i("setOutSideTouchListener", "outsideTouchListener: ");
            }
        });

        btnPositive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDismiss = (positiveBtnClick != null) ? positiveBtnClick.onDialogClick(v.getId(), operatorId) : true;
                if (isDismiss) popMenses.dismiss();
            }
        });


        popMenses.showInCenter(rootView, true);
    }
}
