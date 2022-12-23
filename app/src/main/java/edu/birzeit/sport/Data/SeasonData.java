package edu.birzeit.sport.Data;

import edu.birzeit.sport.models.Season;

import java.util.ArrayList;

public class SeasonData {
    private static ArrayList<Season> seasons;

    public SeasonData(){
        seasons=new ArrayList<>();
        seasons.add(new Season(2022,"real madrid","chelse"));
    }
}
