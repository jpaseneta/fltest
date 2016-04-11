package test.freelancer.com.fltest.Model;

import java.util.ArrayList;

/**
 * Created by V15 on 11/04/2016.
 */
public class ProgramsResponse {
    public ArrayList<Programs> results;
    public int count;
    // public constructor is necessary for collections
    public ProgramsResponse() {
        results = new ArrayList<Programs>();
    }
}
