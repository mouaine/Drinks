package fr.masciulli.drinks.util;

import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.ViewPropertyAnimator;

import java.util.Timer;
import java.util.TimerTask;

public class AnimUtils {
    public static void scheduleEndAction(ViewPropertyAnimator animator, final Runnable endAction, long duration, long startDelay) {
        if (VERSION.SDK_INT >= 16) {
            animator.withEndAction(endAction);
        } else {
            Timer timer = new Timer();
            final Handler handler = new Handler() {
                public void handleMessage(Message msg) {
                    endAction.run();
                }
            };
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    handler.obtainMessage().sendToTarget();
                }
            };
            timer.schedule(task, startDelay + duration);
        }
    }

    public static void scheduleEndAction(ViewPropertyAnimator animator, final Runnable endAction, long duration) {
        scheduleEndAction(animator, endAction, duration, 0);
    }

    public static void scheduleStartAction(ViewPropertyAnimator animator, final Runnable endAction, long startDelay) {
        if (VERSION.SDK_INT >= 16) {
            animator.withStartAction(endAction);
        } else {
            Timer timer = new Timer();
            final Handler handler = new Handler() {
                public void handleMessage(Message msg) {
                    endAction.run();
                }
            };
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    handler.obtainMessage().sendToTarget();
                }
            };
            timer.schedule(task, startDelay);
        }
    }
}
