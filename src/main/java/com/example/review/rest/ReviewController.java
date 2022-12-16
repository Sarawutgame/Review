package com.example.review.rest;


import com.example.review.command.CreateReviewCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final CommandGateway commandGateway;

    @Autowired
    public ReviewController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @GetMapping
    public String getReview(){
        return "Hello_Ja";
    }

    @PostMapping
    public String newReview(@RequestBody CreateReviewModel model){

        CreateReviewCommand command = CreateReviewCommand.builder()
                .reviewId(UUID.randomUUID().toString())
                .name(model.getName())
                .branch(model.getBranch())
                .store_type(model.getStore_type())
                .description(model.getDescription())
                .imageId(model.getImageId())
                .address(model.getAddress())
                .timeOpen(model.getTimeOpen())
                .timeClose(model.getTimeClose())
                .personReview(model.getPersonReview())
                .phone(model.getPhone())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        }catch (Exception e){
            result = e.getLocalizedMessage();
        }

        return result;
//        return "create Review : " + model.getName();
    }

    @DeleteMapping
    public String deleteReview(){
        return "Delete Review";
    }
}
