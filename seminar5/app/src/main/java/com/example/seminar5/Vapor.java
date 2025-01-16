package com.example.seminar5;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Vapor implements Parcelable {
    private String nume; //rez
    private int numar;//rez
    private String detalii;//rez
    private boolean de_marfa;//rez
    private float lungime;//rez

    public Vapor(String nume, int numar, String detalii, boolean de_marfa, float lungime) {
        this.nume = nume;
        this.numar = numar;
        this.detalii = detalii;
        this.de_marfa = de_marfa;
        this.lungime = lungime;
    }

    protected Vapor(Parcel in) {
        nume = in.readString();
        numar = in.readInt();
        detalii = in.readString();
        de_marfa = in.readByte() != 0;
        lungime = in.readFloat();
    }

    public static final Creator<Vapor> CREATOR = new Creator<Vapor>() {
        @Override
        public Vapor createFromParcel(Parcel in) {
            return new Vapor(in);
        }

        @Override
        public Vapor[] newArray(int size) {
            return new Vapor[size];
        }
    };

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNumar() {
        return numar;
    }

    public void setNumar(int numar) {
        this.numar = numar;
    }

    public String getDetalii() {
        return detalii;
    }

    public void setDetalii(String detalii) {
        this.detalii = detalii;
    }

    public boolean isDe_marfa() {
        return de_marfa;
    }

    public void setDe_marfa(boolean de_marfa) {
        this.de_marfa = de_marfa;
    }

    public float getLungime() {
        return lungime;
    }

    public void setLungime(float lungime) {
        this.lungime = lungime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vapor{");
        sb.append("nume='").append(nume).append('\'');
        sb.append(", numar=").append(numar);
        sb.append(", detalii='").append(detalii).append('\'');
        sb.append(", de marfa=").append(de_marfa);
        sb.append(", lungime=").append(lungime);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(nume);
        dest.writeInt(numar);
        dest.writeString(detalii);
        dest.writeByte((byte)(de_marfa?1:0));
        dest.writeFloat(lungime);


    }
}
