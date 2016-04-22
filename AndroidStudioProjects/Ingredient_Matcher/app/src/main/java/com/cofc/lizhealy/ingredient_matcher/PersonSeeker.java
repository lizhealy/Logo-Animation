package com.cofc.lizhealy.ingredient_matcher;

/**
 * Created by lizhealy on 4/14/16.
 */
import android.util.Log;

import java.util.ArrayList;

public class PersonSeeker extends GenericSeeker<Person> {

    private static final String PERSON_SEARCH_PATH = "Person.search/";

    public ArrayList<Person> find(String query) {
        ArrayList<Person> personList = retrievePersonList(query);
        return personList;
    }

    public ArrayList<Person> find(String query, int maxResults) {
        ArrayList<Person> personList = retrievePersonList(query);
        return retrieveFirstResults(personList, maxResults);
    }

    private ArrayList<Person> retrievePersonList(String query) {
        String url = constructSearchUrl(query);
        String response = httpRetriever.retrieve(url);
        Log.d(getClass().getSimpleName(), response);
        return xmlParser.parsePeopleResponse(response);
    }

    @Override
    public String retrieveSearchMethodPath() {
        return PERSON_SEARCH_PATH;
    }

}
