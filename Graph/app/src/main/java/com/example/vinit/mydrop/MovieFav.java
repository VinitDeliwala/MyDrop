package com.example.vinit.mydrop;

public class MovieFav {

    private int _id;
    private String _moviename;
    private String _nlike;
    private String _nshare;
    private String _ncomment;
    private String _nevents;
    private String _nalbums;



    public MovieFav(){

    }

    public MovieFav(String moviename, String genre, String plot, String director,
                    String youtube, String released) {
        this._moviename = moviename;
        this._nlike = genre;
        this._nshare = plot;
        this._ncomment = director;
        this._nevents = youtube;
        this._nalbums = released;
    }



    public String get_director() {
        return _ncomment;
    }

    public void set_director(String _director) {
        this._ncomment = _director;
    }

    public String get_genere() {
        return _nlike;
    }

    public void set_genere(String _genere) {
        this._nlike = _genere;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_moviename() {
        return _moviename;
    }

    public void set_moviename(String _moviename) {
        this._moviename = _moviename;
    }

    public String get_plot() {
        return _nshare;
    }

    public void set_plot(String _plot) {
        this._nshare = _plot;
    }


    public String get_released() {
        return _nalbums;
    }

    public void set_released(String _released) {
        this._nalbums = _released;
    }



    public String get_youtube() {
        return _nevents;
    }

    public void set_youtube(String _youtube) {
        this._nevents = _youtube;
    }
}
