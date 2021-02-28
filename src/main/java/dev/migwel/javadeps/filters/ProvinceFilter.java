package dev.migwel.javadeps.filters;

import dev.migwel.javadeps.Province;
import org.jetbrains.annotations.NotNull;

public class ProvinceFilter implements Filter {

    private final Province province;

    public ProvinceFilter(@NotNull Province province) {
        this.province = province;
    }

    @Override
    public String getQuery() {
        return "province: "+ province.getProvinceName();
    }
}
