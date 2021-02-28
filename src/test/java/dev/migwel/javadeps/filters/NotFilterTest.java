package dev.migwel.javadeps.filters;

import dev.migwel.javadeps.Province;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotFilterTest {

    @Test
    void notProvince() {
        Filter provinceFilter = new ProvinceFilter(Province.LIEGE);
        Filter notFilter = new NotFilter(provinceFilter);
        assertEquals("(NOT province: Liège)", notFilter.getQuery());
    }

}