package com.notebook.cvxt001122.unique;

public class Model {

    private String bookName,issuedDate,returningDate,interval;
    private boolean isBroadcasted;
    private String bookId;

    public Model(){}
    public Model(String bookName,String issuedDate,String returningDate,String interval,boolean isBroadcasted,String bookId){
        this.bookName=bookName;
        this.issuedDate=issuedDate;
        this.returningDate=returningDate;
        this.interval=interval;
        this.isBroadcasted=isBroadcasted;
        this.bookId=bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getIssuedDate() {
        return issuedDate;
    }

    public String getReturningDate() {
        return returningDate;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    public void setReturningDate(String returningDate) {
        this.returningDate = returningDate;
    }

    public String getInterval() {
        return interval;
    }

    public String getBookId() {
        return bookId;
    }
}

