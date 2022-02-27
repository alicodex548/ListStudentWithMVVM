package com.alicode.liststudentmvvm.student.add;

import com.alicode.liststudentmvvm.model.ApiService;
import com.alicode.liststudentmvvm.model.Student;

import io.reactivex.Single;

public class AddStudentFormViewModel {

    private ApiService apiService;

    public AddStudentFormViewModel(ApiService apiService) {

        this.apiService = apiService;
    }

    public Single<Student> save(String firstName, String lastName, String course, int score) {
        return apiService.saveStudent(firstName, lastName, course, score);
    }
}
