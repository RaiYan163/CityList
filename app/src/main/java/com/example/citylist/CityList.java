package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */


public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of cities
     * @author Raiyan 1907023
     * @version 1.0
     * @since 3-28-23
     * @param ck, integer, fixes the sort technique.
     * @return
     *      Return the sorted list of cities
     *
     */
    public List<City> getCities(int ck) {
        List<City> cityList = cities;
        if(ck == 0) {
            Collections.sort(cityList);
        }
        else
        {
            Collections.sort(cityList, new comparator());
        }

        return cityList;
    }

    /**
     * Deletes an existing city from a CityList
     * @author Raiyan 1907023
     * @version 1.0
     * @since 3-28-23
     * @param city
     * @author Raiyan 1907023
     * @since 3-28-23
     */

    public void delete(City city)
    {
        if(!cities.contains(city))
        {
            throw new IllegalArgumentException();
        }

        cities.remove(city);
    }

    /**
     * Counts the total number of cities in a CityList.
     * @author Raiyan 1907023
     * @version 1.0
     * @since 3-28-23
     * @return
     *    Integer value as the number of city in an existing CityList.
     */

    public int count()
    {
        return cities.size();
    }


}
