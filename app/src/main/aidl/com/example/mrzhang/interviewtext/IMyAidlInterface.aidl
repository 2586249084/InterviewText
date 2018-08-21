// IMyAidlInterface.aidl
package com.example.mrzhang.interviewtext;

import com.example.mrzhang.interviewtext.bean.Person;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    void addPerson(in Person person);
    List<Person> getPersonList();
}
