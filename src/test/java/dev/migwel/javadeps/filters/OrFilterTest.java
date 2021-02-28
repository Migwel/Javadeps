package dev.migwel.javadeps.filters;

import dev.migwel.javadeps.Province;
import dev.migwel.javadeps.filters.DateFilter;
import dev.migwel.javadeps.filters.Filter;
import dev.migwel.javadeps.filters.OrFilter;
import dev.migwel.javadeps.filters.ProvinceFilter;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OrFilterTest {

    @Test
    public void testValidProvince() {
        Filter provinceFilter = new ProvinceFilter(Province.LIEGE);
        OrFilter orFilter = new OrFilter();
        orFilter.addFilter(provinceFilter);
        assertEquals("(province: Liège)", orFilter.getQuery());
    }

    @Test
    public void testValidDates() {
        Filter dateFilter = new DateFilter(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 3, 1));
        OrFilter orFilter = new OrFilter();
        orFilter.addFilter(dateFilter);
        assertEquals("(date: [2021-01-01 TO 2021-03-01])", orFilter.getQuery());
    }

    @Test
    public void testProvinceAndDate() {
        Filter provinceFilter = new ProvinceFilter(Province.LIEGE);
        Filter dateFilter = new DateFilter(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 3, 1));
        OrFilter orFilter = new OrFilter();
        orFilter.addFilter(provinceFilter);
        orFilter.addFilter(dateFilter);
        assertEquals("(province: Liège OR date: [2021-01-01 TO 2021-03-01])", orFilter.getQuery());
    }

}