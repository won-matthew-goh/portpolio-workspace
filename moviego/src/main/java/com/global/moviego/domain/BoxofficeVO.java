package com.global.moviego.domain;

public class BoxofficeVO {
    private String movieNm;
    private String openDt;
    private int audiCnt;
    private int audiInten;
    private int audiAcc;
    private int rank;

    // Getters and Setters
    public String getMovieNm() {
        return movieNm;
    }

    public void setMovieNm(String movieNm) {
        this.movieNm = movieNm;
    }

    public int getRank() {
      return rank;
    }

    public void setRank(int rrank) {
      this.rank = rrank;
    }

    public String getOpenDt() {
        return openDt;
    }

    public void setOpenDt(String openDt) {
        this.openDt = openDt;
    }

    public int getAudiCnt() {
        return audiCnt;
    }

    public void setAudiCnt(int audiCnt) {
        this.audiCnt = audiCnt;
    }

    public int getAudiInten() {
        return audiInten;
    }

    public void setAudiInten(int audiInten) {
        this.audiInten = audiInten;
    }

    public int getAudiAcc() {
        return audiAcc;
    }

    public void setAudiAcc(int audiAcc) {
        this.audiAcc = audiAcc;
    }
}
