package pagination;

public class PaginationBuilder {
    private int page = 1;
    private int countOnPage = 2;
    private int countOfElement;

    public PaginationBuilder(String page) {
        if (page != null) {
            this.page = Integer.parseInt(page);
        }
    }

    public PaginationBuilder(int page, int countOfElement) {
        this.page = page;
        this.countOfElement = countOfElement;
    }

    public PaginationBuilder(String page, int countOfElement) {
        if (page != null) {
            this.page = Integer.parseInt(page);
        }
        this.countOfElement = countOfElement;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getCountOnPage() {
        return countOnPage;
    }

    public void setCountOnPage(int countOnPage) {
        this.countOnPage = countOnPage;
    }

    public int getCountOfElement() {
        return countOfElement;
    }

    public void setCountOfElement(int countOfElement) {
        this.countOfElement = countOfElement;
    }

    public int getStartElement() {
        return (page - 1) * countOnPage + 1;
    }

    public int getNumberOfPages() {
        int nOfPages = countOfElement / countOnPage;
        if (countOfElement % countOnPage > 0) {
            nOfPages++;
        }
        return nOfPages;
    }
}
