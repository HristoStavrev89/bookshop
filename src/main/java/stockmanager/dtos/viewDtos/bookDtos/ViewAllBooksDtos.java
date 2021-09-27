package stockmanager.dtos.viewDtos.bookDtos;

import com.google.gson.annotations.Expose;

import java.util.List;

public class ViewAllBooksDtos {
    @Expose
    private long count;
    @Expose
    private List<ViewBookDto> allBooks;

    public ViewAllBooksDtos() {
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public List<ViewBookDto> getAllBooks() {
        return allBooks;
    }

    public void setAllBooks(List<ViewBookDto> allBooks) {
        this.allBooks = allBooks;
    }
}
