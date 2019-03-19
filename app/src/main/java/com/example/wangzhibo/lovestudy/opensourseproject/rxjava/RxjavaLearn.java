package com.example.wangzhibo.lovestudy.opensourseproject.rxjava;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;

/**
 * Created by samwangzhibo on 2019/3/18.
 */

public class RxjavaLearn {
    public static void main(String[] args) {
        helloWorld("wang", "zhibo");
    }

    private static void helloWorld(String... args) {
//        Flowable.fromArray(args).subscribe(new Consumer<String>() {
//            @Override
//            public void accept(String s) throws Exception {
//                System.out.println("Hello " + s + "!");
//            }
//        });

        Flowable.fromArray(args).subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription s) {
                System.out.println("onSubscribe : " + s);
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext : " + s);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Throwable : " + t);
            }

            @Override
            public void onComplete() {
                System.out.println("onComplete");
            }
        });
    }
}
