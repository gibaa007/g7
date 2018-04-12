package com.g7.gibaa007.g.utils;

import android.util.Log;

import com.g7.gibaa007.g.BuildConfig;

/**
 * Created by newagesmb on 19/7/16.
 */
public class CustomLogs {
    private static String TAG = CustomLogs.class.getSimpleName()+" : ";
    public static void e(String message){
        if (BuildConfig.DEBUG) {
            Out out = getInfo(Thread.currentThread().getStackTrace(), 3);
            Log.e(TAG+out.getFileName()+out.getMethodName()+out.getLineNumber()+" :",message);
        }
    }
    public static void w(String message){
        if (BuildConfig.DEBUG) {
            Out out = getInfo(Thread.currentThread().getStackTrace(), 3);
            Log.w(TAG+out.getFileName()+out.getMethodName()+out.getLineNumber()+" :",message);
        }
    }
    public static void i(String message){
        if (BuildConfig.DEBUG) {
            Out out = getInfo(Thread.currentThread().getStackTrace(), 3);
            Log.i(TAG+out.getFileName()+out.getMethodName()+out.getLineNumber()+" :",message);
        }
    }
    public static void d(String message){
        if (BuildConfig.DEBUG) {
            Out out = getInfo(Thread.currentThread().getStackTrace(), 3);
            Log.d(TAG+out.getFileName()+out.getMethodName()+out.getLineNumber()+" :",message);
        }
    }
    public static void v(String message){
        if (BuildConfig.DEBUG) {
            Out out = getInfo(Thread.currentThread().getStackTrace(), 3);
            Log.v(TAG+out.getFileName()+out.getMethodName()+out.getLineNumber()+" :",message);
        }
    }
    public static void wtf(String message){
        if (BuildConfig.DEBUG) {
            Out out = getInfo(Thread.currentThread().getStackTrace(), 3);
            Log.wtf(TAG+out.getFileName()+out.getMethodName()+out.getLineNumber()+" :",message);
        }
    }

    public static void check(){
        if (BuildConfig.DEBUG) {
            Out out = getInfo(Thread.currentThread().getStackTrace(), 3);
            Log.e(TAG,out.getFileName()+out.getMethodName()+out.getLineNumber());
        }
    }

    private static Out getInfo(final StackTraceElement e[], final int level) {

        if (e != null && e.length >= level) {
            final StackTraceElement s = e[level];
            if (s != null) {
                Out out = new Out();
                out.setClassName(s.getClassName());
                out.setFileName(s.getFileName());
                out.setMethodName(s.getMethodName());
                out.setLineNumber(Integer.toString(s.getLineNumber()));


                if(!out.getClassName().equals("")){
                    out.setClassName(out.getClassName()+"");
                }
                if(!out.getFileName().equals("")){
                    out.setFileName(out.getFileName()+"");
                }
                if(!out.getMethodName().equals("")){
                    out.setMethodName(" -> "+out.getMethodName()+"()");
                }
                if(!out.getLineNumber().equals("")){
                    out.setLineNumber(" -> "+out.getLineNumber());
                }
                return out;
            }
        }
        return null;
    }
    static class Out{
        private String className = "";
        private String fileName = "";
        private String methodName = "";
        private String lineNumber = "";

        public String getClassName() {
            return className;
        }

        public void setClassName(String className) {
            this.className = className;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getMethodName() {
            return methodName;
        }

        public void setMethodName(String methodName) {
            this.methodName = methodName;
        }

        public String getLineNumber() {
            return lineNumber;
        }

        public void setLineNumber(String lineNumber) {
            this.lineNumber = lineNumber;
        }
    }
}