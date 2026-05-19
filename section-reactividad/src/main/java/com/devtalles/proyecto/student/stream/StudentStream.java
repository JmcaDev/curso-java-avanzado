package com.devtalles.proyecto.student.stream;

import com.devtalles.proyecto.task.student.model.Student;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class StudentStream {
    private final Subject<Student> studentSubject = PublishSubject.<Student>create().toSerialized();

    public void publish(Student student) {
        studentSubject.onNext(student);
    }

    public Subject<Student> getStream() {
        return studentSubject;
    }

    public void complete(){
        studentSubject.onComplete();
    }

    public void error(Throwable throwable){
        studentSubject.onError(throwable);
    }
}
