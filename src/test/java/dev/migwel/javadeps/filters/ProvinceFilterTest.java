package dev.migwel.javadeps.filters;

import dev.migwel.javadeps.Province;
import dev.migwel.javadeps.filters.Filter;
import dev.migwel.javadeps.filters.ProvinceFilter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProvinceFilterTest {

    @Test
    public void testValidProvince() {
        Filter provinceFilter = new ProvinceFilter(Province.LIEGE);
        assertEquals("province: Liège", provinceFilter.getQuery());
    }

}