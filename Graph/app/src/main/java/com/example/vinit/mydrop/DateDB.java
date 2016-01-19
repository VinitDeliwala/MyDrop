package com.example.vinit.mydrop;

public class DateDB {

    private int _id;
    private String _idd;
    private String _attr;
    private String _jan;
    private String _feb;
    private String _mar;
    private String _apr;
    private String _may;
    private String _jun;
    private String _jul;
    private String _aug;
    private String _sep;
    private String _oct;
    private String _nov;
    private String _dec;



    public DateDB(){

    }

    public DateDB(String idd,String attr, String jan, String feb, String mar,
                  String apr, String may,String jun,String jul,String aug,String sep,String oct,String nov,String dec) {

        this._idd = idd;
        this._attr = attr;
        this._jan = jan;
        this._feb = feb;
        this._mar = mar;
        this._apr = apr;
        this._may = may;
        this._jun = jun;
        this._jul = jul;
        this._aug = aug;
        this._sep = sep;
        this._oct = oct;
        this._nov = nov;
        this._dec = dec;
    }

    public String get_idd() {
        return _idd;
    }

    public void set_idd(String _idd) {
        this._idd = _idd;
    }

    public String get_attr() {
        return _attr;
    }

    public void set_attr(String _attr) {
        this._attr = _attr;
    }

    public String get_jan() {
        return _jan;
    }

    public void set_jan(String _jan) {
        this._jan = _jan;
    }

    public String get_feb() {
        return _feb;
    }

    public void set_feb(String _feb) {
        this._feb = _feb;
    }

    public String get_mar() {
        return _mar;
    }

    public void set_mar(String _mar) {
        this._mar = _mar;
    }

    public String get_apr() {
        return _apr;
    }

    public void set_apr(String _apr) {
        this._apr = _apr;
    }

    public String get_may() {
        return _may;
    }

    public void set_may(String _may) {
        this._may = _may;
    }

    public String get_jun() {
        return _jun;
    }

    public void set_jun(String _jun) {
        this._jun = _jun;
    }

    public String get_jul() {
        return _jul;
    }

    public void set_jul(String _jul) {
        this._jul = _jul;
    }

    public String get_aug() {
        return _aug;
    }

    public void set_aug(String _aug) {
        this._aug = _aug;
    }

    public String get_sep() {
        return _sep;
    }

    public void set_sep(String _sep) {
        this._sep = _sep;
    }

    public String get_oct() {
        return _oct;
    }

    public void set_oct(String _oct) {
        this._oct = _oct;
    }

    public String get_nov() {
        return _nov;
    }

    public void set_nov(String _nov) {
        this._nov = _nov;
    }

    public String get_dec() {
        return _dec;
    }

    public void set_dec(String _dec) {
        this._dec = _dec;
    }


}
