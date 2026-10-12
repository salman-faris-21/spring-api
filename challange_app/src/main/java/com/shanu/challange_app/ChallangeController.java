package com.shanu.challange_app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ChallangeController {
    private ChallengeService challengeService;
    private long id;

    public ChallangeController (ChallengeService challengeService){
         this.challengeService=challengeService;
    }

    @GetMapping("/challenges")
    public ResponseEntity<List<Challenge>> getAllChallenges(){
      return new ResponseEntity<>(challengeService.getAllChallenges(),HttpStatus.OK);
    }

    @GetMapping("/challenges/{month}")
    public ResponseEntity<Challenge> getMonthlyChallenges(@PathVariable String  month){
        Challenge challange=challengeService.getChallenge(month);
        if (challange!=null) return new ResponseEntity<>(challange, HttpStatus.OK);
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @PutMapping("challenges/{id}")
    public ResponseEntity<String> updateChallange(@PathVariable long id ,@RequestBody Challenge updateChallenge){
        boolean isUpdated=challengeService.updateChallange(id,updateChallenge);
        if (isUpdated){
            return  new ResponseEntity<>("challenge updated succesfully",HttpStatus.OK);
        }
        else  return  new ResponseEntity<>("challenge not updated succesfully",HttpStatus.NOT_FOUND);
    }


    @PostMapping("challenges")
    public ResponseEntity< String >addChallange(@RequestBody Challenge challenge){
        boolean isChallangeAdded=challengeService.addChallenge(challenge);
        if(isChallangeAdded){
            return new ResponseEntity<>("challange added suxxesfully",HttpStatus.OK) ;

        }
        else return new ResponseEntity<>("challange couldn't add succesfully",HttpStatus.NOT_FOUND);
    }

}
