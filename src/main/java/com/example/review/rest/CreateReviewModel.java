package com.example.review.rest;


import lombok.Data;

@Data
public class CreateReviewModel {
    private String name;
    private String branch;
    private String store_type;
    private String description;
    private String imageId;
    private String address;
    private String timeOpen;
    private String timeClose;
    private int rating;
    private int personReview;
    private String phone;
}
