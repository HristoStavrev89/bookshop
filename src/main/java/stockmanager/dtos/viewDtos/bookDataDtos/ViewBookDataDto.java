package stockmanager.dtos.viewDtos.bookDataDtos;

import com.google.gson.annotations.Expose;
import stockmanager.dtos.viewDtos.bookDtos.ViewBookDto;


public class ViewBookDataDto {
    @Expose
    private int onStock;
    @Expose
    private boolean isAvailable;

    @Expose
    private ViewBookDto book;

    public ViewBookDataDto() {
    }

    public int getOnStock() {
        return onStock;
    }

    public void setOnStock(int onStock) {
        this.onStock = onStock;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }


    public ViewBookDto getBook() {
        return book;
    }

    public void setBook(ViewBookDto book) {
        this.book = book;
    }
}
