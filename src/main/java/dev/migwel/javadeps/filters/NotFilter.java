package dev.migwel.javadeps.filters;

public class NotFilter implements Filter {

    private final Filter filter;

    public NotFilter(Filter filter) {
        this.filter = filter;
    }

    @Override
    public String getQuery() {
        return "(NOT "+ filter.getQuery() + ")";
    }
}
