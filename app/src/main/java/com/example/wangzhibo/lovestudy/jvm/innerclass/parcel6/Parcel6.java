package com.example.wangzhibo.lovestudy.jvm.innerclass.parcel6;

/**
 * Created by samwangzhibo on 2019/3/10.
 */

public class Parcel6 {
    private int num1 = 10;
    private void internalTracking(boolean b){
        if(b){
            class TrackingSlip{
                private String id;
                TrackingSlip(String s) {
                    id = s;
                }
                String getSlip(){
                    return id + num1;
                }
            }
            TrackingSlip ts = new TrackingSlip("chenssy");
            String string = ts.getSlip();
        }
    }

    public void track(){
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 parcel6 = new Parcel6();
        parcel6.track();
    }
}