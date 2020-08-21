package com.segurosx.models.patterns;

public interface ISeguroObservable {

    void addObserver(IObserver observer);
    void removeObserver(IObserver observer);
    
}