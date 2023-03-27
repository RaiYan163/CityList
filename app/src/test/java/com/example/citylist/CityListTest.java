package com.example.citylist;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "AB");
    }

    @Test
    public void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities(1).size());

        City city = new City("Regina", "SK");
        cityList.add(city);

        assertEquals(2, cityList.getCities(0).size());
        assertTrue(cityList.getCities(0).contains(city));
    }

    @Test
    public void testAddException() {
        CityList cityList = new CityList();
        City city = mockCity();
        cityList.add(city);

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    public void testGetCities() {
        CityList cityList = mockCityList();
        assertEquals(0, mockCity().compareTo(cityList.getCities(1).get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities(0).get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities(0).get(1)));
    }

    /**
     * tests the Delete Function of CityList(normal case).
     * @author Raiyan 1907023
     * @version 1.0
     * @since 3-28-23
     */

    @Test
    public void testDelete()
    {
        CityList cityList = new CityList();
        City city = new City("Azimpur", "Dhaka");
        City city2 = new City("Fulbaria", "Mymensingh");
        cityList.add(city);
        cityList.add(city2);

        cityList.delete(city);
        assertTrue(!cityList.getCities(0).contains(city));
    }

    /**
     * tests the Delete function of CityList on the exception case.
     * @author Raiyan 1907023
     * @version 1.0
     * @since 3-28-23
     */

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteException()
    {
        CityList sample = new CityList();
        City city = new City("Ajob Nagar", "Jadur Desh");
        City city2 = new City("munich", "Germany");
        sample.add(city);
        sample.delete(city2);
    }

    /**
     * tests the Count function of CityList.
     * @author Raiyan 1907023
     * @version 1.0
     * @since 3-28-23
     */
    @Test
    public void testCount()
    {
        CityList sample = new CityList();
        City city1 = new City("Ajob Nagar", "Jadur Desh");
        City city2 = new City("munich", "Germany");
        City city3 = new City("Azimpur", "Dhaka");
        City city4 = new City("Fulbaria", "Mymensingh");
        sample.add(city1);
        sample.add(city2);
        sample.add(city3);
        sample.add(city4);

        assertTrue((sample.count() == 4));
    }
    /**
     * tests the Sort function of CityList on basis of City.
     * @author Raiyan 1907023
     * @version 1.0
     * @since 3-28-23
     */

    @Test
    public void testSortCity()
    {
        CityList cityList = new CityList();
        City city1 = new City("A", "C");
        City city2 = new City("B", "A");
        City city3 = new City("C", "D");
        City city4 = new City("D", "B");

        cityList.add(city4);
        cityList.add(city2);
        cityList.add(city1);
        cityList.add(city3);

        List<City> expected_list = new ArrayList<>();
        expected_list.add(city1);
        expected_list.add(city2);
        expected_list.add(city3);
        expected_list.add(city4);

        assertEquals(expected_list, cityList.getCities(0));

    }

    /**
     * tests the Sort function of CityList on basis of province.
     * @author Raiyan 1907023
     * @version 1.0
     * @since 3-28-23
     */

    @Test
    public void testSortProvince()
    {
        CityList cityList = new CityList();
        City city1 = new City("A", "E");
        City city2 = new City("B", "C");
        City city3 = new City("C", "H");
        City city4 = new City("D", "J");

        cityList.add(city1);
        cityList.add(city2);
        cityList.add(city3);
        cityList.add(city4);

        List<City> expected_list = new ArrayList<>();
        expected_list.add(city2);
        expected_list.add(city1);
        expected_list.add(city3);
        expected_list.add(city4);

        assertEquals(expected_list, cityList.getCities(1));
    }





}
