package com.mojitox.mxflutter.framework.executor;

import android.os.Process;

import com.mojitox.mxflutter.BuildConfig;

public abstract class JsTask implements Runnable {

    private static final String TAG = "MXJsTask";

    private long runTime; //运行时间
    private String taskName;

    protected JsTask() {

    }

    @Override
    public void run() {
        try {
            Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT);
            final long s = System.currentTimeMillis();
            execute();
            final long e = System.currentTimeMillis();
            runTime = e - s;
            debug();
        } catch (Throwable t) {
            android.util.Log.e(TAG, "Exception:JSMessage:" + t.getMessage());
        }
    }

    private void debug() {
        if(BuildConfig.DEBUG) {
            android.util.Log.e(TAG, getTaskName() + "###########time:" + runTime);
        }
    }

    protected abstract void execute();

    /**
     * 线程任务执行时间
     *
     * @return 毫秒数
     */
    public long getRunTime() {
        return runTime;
    }

    public String getTaskName() {
        return taskName;
    }

    public JsTask setTaskName(String taskName) {
        this.taskName = taskName;
        return this;
    }
}