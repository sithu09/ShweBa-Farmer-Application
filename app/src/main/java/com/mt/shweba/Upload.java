package com.mt.shweba;

public class Upload {
    private String mName;
    private String mImageUrl;

    private String Date;
    private String Proposal;

public Upload(){

}
//    public Upload(String name, String imageUrl) {
//        this.mName = name;
//        this.mImageUrl = imageUrl;
//    }


    public Upload(String name, String imageUrl, String date, String proposal) {
        this.mName = name;
        this.mImageUrl = imageUrl;
        Date = date;
        Proposal = proposal;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        this.mName = name;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.mImageUrl = imageUrl;
    }

    public String getProposal() {
        return Proposal;
    }

    public void setProposal(String proposal) {
        Proposal = proposal;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
