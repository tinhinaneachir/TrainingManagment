package com.example.GestionFormationEntreprise.dto;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String titre;
    @Column(name = "description")
    private String description;
    @Column(name = "statut")
    private String statut;
    @Column(name = "start_date")
    private Date dateDebut;
    @Column(name = "end_date")
    private Date dateFin;
    @Column(name = "nbMaxParticipants")
    private int nbMaxParticipants;

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Formation(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public int getNbMaxParticipants() {
        return nbMaxParticipants;
    }

    public void setNbMaxParticipants(int nbMaxParticipants) {
        this.nbMaxParticipants = nbMaxParticipants;
    }

}
