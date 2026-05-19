package com.devtalles.proyecto.filterAndCondition;

import io.reactivex.rxjava3.core.Observable;

public class FilterAndCondition {
    static void main() {
        Observable<Integer> ages = Observable.just(11, 12, 20, 20, 30, 12, 14, 18, 60, 70);

        //Filter
        //ages.filter(age -> age >=21).subscribe(System.out::println);

        //Distinct
        //ages.distinct().subscribe(System.out::println);

        //Take
        //ages.take(4).subscribe(System.out::println);

        //Take While
        ages.takeWhile(age -> age < 21)
                .subscribe(System.out::println);
    }
}
