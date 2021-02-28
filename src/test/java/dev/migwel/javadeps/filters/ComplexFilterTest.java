package dev.migwel.javadeps.filters;

import dev.migwel.javadeps.Province;
import dev.migwel.javadeps.data.Status;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ComplexFilterTest {

    @Test
    void complexFilterTest() {
        OrFilter orFilter = new OrFilter(new ProvinceFilter(Province.LIEGE), new ProvinceFilter(Province.LUXEMBOURG));
        AndFilter andFilter = new AndFilter(new StatusFilter(Status.OK), new DateFilter(LocalDate.of(2020, 3, 1), null), orFilter);
        assertEquals("(statut: \"OK\" AND date >= 2020-03-01 AND (province: Liège OR province: Luxembourg))", andFilter.getQuery());
    }
}
