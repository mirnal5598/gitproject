package com.example.demo.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "author_mtom")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String  name;
    private int age;
    @Embedded
    private Address address;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_book", joinColumns = @JoinColumn(name = "author_id"
            , referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "book_id"
            , referencedColumnName = "id"))
    private Set<Book> books;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }


    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}
