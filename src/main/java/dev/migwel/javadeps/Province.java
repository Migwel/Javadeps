package dev.migwel.javadeps;

public enum Province {
    LIEGE("Liège"),
    LUXEMBOURG("Luxembourg"),
    NAMUR("Namur"),
    HAINAUT_EST("Hainaut Est"),
    HAINAUT_OUEST("Hainaut Ouest"),
    BRABANT_WALLON("Brabant Wallon"),
    BRUXELLES("Bruxelles"),
    ;
    private final String provinceName;


    Province(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceName() {
        return provinceName;
    }
}
