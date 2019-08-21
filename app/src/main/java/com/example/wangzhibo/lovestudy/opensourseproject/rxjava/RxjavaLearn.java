package com.example.wangzhibo.lovestudy.opensourseproject.rxjava;

import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

/**
 * Created by samwangzhibo on 2019/3/18.
 */

public class RxjavaLearn {
  public static void main(String[] args) {
    helloWorld("wang", "zhibo");
  }

  private static void helloWorld(String... args) {
//      simpleUse(args);

    doOnNext();
  }

  private static void simpleUse(String... args) {
//    Flowable.fromArray(args).subscribe(new Consumer<String>() {
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

  private static void doOnNext() {
    /**
     * onSubscribe()
     * onNext()->1
     * doOnNext accept()->integer:1
     * onNext()->value:1
     * subscribe()->2
     * doOnNext accept()->integer:2
     * onNext()->value:2
     * subscribe()->3
     * doOnNext accept()->integer:3
     * onNext()->value:3
     * subscribe()->onComplete()
     * onComplete()
     */
    Observable
        .create(new ObservableOnSubscribe<Integer>() {
          @Override
          public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
            System.out.println("onNext()->1"); // 2
            emitter.onNext(1);
            System.out.println("subscribe()->2");
            emitter.onNext(2);
            System.out.println("subscribe()->3");
            emitter.onNext(3);
            System.out.println("subscribe()->onError");
            emitter.onError(new Exception());
            System.out.println("subscribe()->onComplete()");
            emitter.onComplete();
          }
        })
        .doOnNext(new Consumer<Integer>() {
          @Override
          public void accept(Integer integer) throws Exception {
            System.out.println("doOnNext accept()->integer:" + integer); // 3
          }
        })
        .onErrorReturnItem(4)
        .doOnError(new Consumer<Throwable>() {
          @Override
          public void accept(Throwable throwable) throws Exception {
            System.out.println("doOnError accept()");
          }
        })
        .subscribe(new Observer<Integer>() {
          @Override
          public void onSubscribe(Disposable disposable) {
            System.out.println("onSubscribe()"); // 1
          }

          @Override
          public void onNext(Integer value) {
            System.out.println("onNext()->value:" + value); // 4
          }

          @Override
          public void onError(Throwable e) {
            System.out.println("onError()");
          }

          @Override
          public void onComplete() {
            System.out.println("onComplete()");
          }
        });
  }

}
