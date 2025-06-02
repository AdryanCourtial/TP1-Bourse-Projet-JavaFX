package com.example.tp1bourseprojetjavafx.model;

public class Expense {
    private String periode;
    private double total;
    private double logement;
    private double nourriture;
    private double sorties;
    private double transport;
    private double voyage;
    private double impots;
    private double autres;

    public Expense(String periode, double total, double logement, double nourriture, double sorties,
                   double transport, double voyage, double impots, double autres) {
        this.periode = periode;
        this.total = total;
        this.logement = logement;
        this.nourriture = nourriture;
        this.sorties = sorties;
        this.transport = transport;
        this.voyage = voyage;
        this.impots = impots;
        this.autres = autres;
    }

    public String getPeriode() { return periode; }
    public double getTotal() { return total; }
    public double getLogement() { return logement; }
    public double getNourriture() { return nourriture; }
    public double getSorties() { return sorties; }
    public double getTransport() { return transport; }
    public double getVoyage() { return voyage; }
    public double getImpots() { return impots; }
    public double getAutres() { return autres; }
}
