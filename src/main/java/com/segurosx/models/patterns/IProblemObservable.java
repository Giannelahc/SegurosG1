package com.segurosx.models.patterns;

public interface IProblemObservable {

    public void notifyProblem();

    public void add(IVehicularObserver iVehicularObserver);

    public void remove(IVehicularObserver iVehicularObserver);

}
