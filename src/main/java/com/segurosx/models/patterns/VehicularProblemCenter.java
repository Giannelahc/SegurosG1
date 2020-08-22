package com.segurosx.models.patterns;

import java.util.ArrayList;
import java.util.List;

public class VehicularProblemCenter implements IProblemObservable {

    private List<IVehicularObserver> vehicularObserverList = new ArrayList<>();
    private String problem;
    private Double amount;

    @Override
    public void notifyProblem() {
        for (IVehicularObserver vehicularObserver : vehicularObserverList) {
            vehicularObserver.update();
        }
    }

    @Override
    public void add(IVehicularObserver iVehicularObserver) {
        this.vehicularObserverList.add(iVehicularObserver);
    }

    @Override
    public void remove(IVehicularObserver iVehicularObserver) {
        this.vehicularObserverList.remove(iVehicularObserver);
    }

    public List<IVehicularObserver> getVehicularObserverList() {
        return vehicularObserverList;
    }
    
    public void setProblem(String problem, Double amount){
        this.problem = problem;
        this.amount = amount;
        notifyProblem();
    }

    public Double getAmount(){
        return this.amount;
    }

    public void describeProblem(){
        System.out.println(" Problema: " + this.problem + "     Carga extra: " + this.amount);
    }

}
