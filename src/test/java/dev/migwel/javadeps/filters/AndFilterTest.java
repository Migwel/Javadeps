package dev.migwel.javadeps.filters;

import dev.migwel.javadeps.Province;
import dev.migwel.javadeps.filters.DateFilter;
import dev.migwel.javadeps.filters.Filter;
import dev.migwel.javadeps.filters.AndFilter;
import dev.migwel.javadeps.filters.ProvinceFilter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AndFilterTest {

    @Test
    public void testValidProvince() {
        Filter provinceFilter = new ProvinceFilter(Province.LIEGE);
        AndFilter andFilter = new AndFilter();
        andFilter.addFilter(provinceFilter);
        assertEquals("(province: Liège)", andFilter.getQuery());
    }

    @Test
    public void testValidDates() {
        Filter dateFilter = new DateFilter(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 3, 1));
        AndFilter andFilter = new AndFilter();
        andFilter.addFilter(dateFilter);
        assertEquals("(date: [2021-01-01 TO 2021-03-01])", andFilter.getQuery());
    }

    @Test
    public void testProvinceAndDate() {
        Filter provinceFilter = new ProvinceFilter(Province.LIEGE);
        Filter dateFilter = new DateFilter(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 3, 1));
        AndFilter andFilter = new AndFilter();
        andFilter.addFilter(provinceFilter);
        andFilter.addFilter(dateFilter);
        assertEquals("(province: Liège AND date: [2021-01-01 TO 2021-03-01])", andFilter.getQuery());
    }

}