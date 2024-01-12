package pojo;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

public class QuotesPages {
	private int page;
	private boolean lastPage;
	private ArrayList<Quote> quotes;
    
	QuotesPages() {}
	
    public void setPage(int page) {
        this.page = page;
    }

    public void setLastPage(boolean last_page) {
        this.lastPage = last_page;
    }

    public void setQuotes(ArrayList<Quote> quotes) {
        this.quotes = quotes;
    }
    
    public int getPage() {
        return page;
    }

    public boolean getLastPage() {
        return lastPage;
    }

    public ArrayList<Quote> getQuotes() {
        return quotes;
    }
}