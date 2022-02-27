package com.alicode.liststudentmvvm.main;

import com.alicode.liststudentmvvm.model.ApiService;
import com.alicode.liststudentmvvm.model.Student;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.subjects.BehaviorSubject;

public class MainViewModel {
    private ApiService apiService;
    private BehaviorSubject<Boolean> progressBarSubject = BehaviorSubject.create();

    public MainViewModel(ApiService apiService) {
        this.apiService = apiService;
    }

    public Single<List<Student>> students() {
        progressBarSubject.onNext(true);
        return apiService.getStudents()
                .doFinally(() -> progressBarSubject.onNext(false));
    }

    public BehaviorSubject<Boolean> getProgressBarSubject() {
        return progressBarSubject;
    }
}
