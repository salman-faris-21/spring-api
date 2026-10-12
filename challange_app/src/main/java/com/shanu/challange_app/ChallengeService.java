package com.shanu.challange_app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChallengeService {
    private List<Challenge> challenges=new ArrayList<>();
    private long id=1L;

    public ChallengeService(){

        Challenge challenge1=new Challenge("january",1L,"learn spring");
        challenges.add(challenge1);
    }
    public List<Challenge> getAllChallenges(){
        return challenges;
    }
    public boolean addChallenge(Challenge challenge){
        if (challenge!=null) {
            challenge.setId(id++);
            challenges.add(challenge);
            return true;
        }

        return false;
    }

    public Challenge getChallenge(String month) {
        for (Challenge challenge:challenges){
            if (challenge.getMonth().equalsIgnoreCase(month)){
                return challenge;

            }

        }
        return null;
    }

    public boolean updateChallange(long id, Challenge updateChallenge) {
        for (Challenge challange:challenges){
            if (challange.getId()==(id)){
                challange.setMonth(updateChallenge.getMonth());
                challange.setDescription(updateChallenge.getDescription());
                return true;
            }

        }
         return false;
    }
}
