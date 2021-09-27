package stockmanager.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "book_data")
public class BookData extends BaseEntity{
    private int onStock;
    private boolean isAvailable;

    private Book book;

    public BookData() {
    }

    @Column
    public int getOnStock() {
        return onStock;
    }

    public void setOnStock(int stock) {
        this.onStock = stock;
    }

    @Column
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @OneToOne
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
