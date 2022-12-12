package steps;

public class SearchCriteria {

    String include;

    String exclude;

    int minPrice;

    int maxPrice;

    public SearchCriteria() {
    }
    public SearchCriteria(String include, String exclude, int minPrice, int maxPrice) {
        this.include = include;
        this.exclude = exclude;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
    }

    public String getInclude() {
        return include;
    }

    public void setInclude(String include) {
        this.include = include;
    }

    public String getExclude() {
        return exclude;
    }

    public int getMinPrice() {
        return minPrice;
    }

    public int getMaxPrice() {
        return maxPrice;
    }

    public SearchCriteria createSearchCriteria(String include){
        SearchCriteria person = new SearchCriteria();
        person.setInclude(include);
        return person;
    }
}
