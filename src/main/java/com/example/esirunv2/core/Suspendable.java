package com.example.esirunv2.core;
public interface Suspendable extends Comparable<Suspendable> {
    
    void suspendre();
    void reactiver();
    public boolean estSuspendu();
    public String getEtat(); // retourne "suspendu" ou bien "actif"
    
}
