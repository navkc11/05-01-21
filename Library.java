package com.company;

import java.util.ArrayList;

public class Library {
    ArrayList<Book> books;
    ArrayList<Rental> rental;
    //banai
    public Library(){
        books = new ArrayList<>();
        rental = new ArrayList<>();
    }
    //method 1
    public Author mostPopular(){
        int flag=0, mostBooks=0, mostBooksLocation=0;
        //list of all authors
        ArrayList<Author> authors=new ArrayList<>();
        //list of how many books each of the authors has
        ArrayList<Integer> booksPerAuthor=new ArrayList<>();
        //add new authors to the "authors" ArrayList
        for (int i=0; i< books.size();i++){
            for(int j=0;j< authors.size();j++){
                if(books.get(i).getAuthor()==authors.get(j))flag=1;
            }
            //if the author isn't in the list add him and set his book amount to 1
            if (flag==0){
                authors.add(books.get(i).getAuthor());
                booksPerAuthor.add(1);
            }
            //if the author is already in the list add to his book total
            else{
                for(int j=0;j < authors.size();j++){
                    if (authors.get(j)==books.get(i).getAuthor())booksPerAuthor.add(j,booksPerAuthor.get(j)+1);
                }
            }
        }
        //go through book totals find highest and it's location
        for (int i=0;i<booksPerAuthor.size();i++){
            if (booksPerAuthor.get(i)>mostBooks){
                mostBooks = booksPerAuthor.get(i);
                mostBooksLocation = i;
            }
        }
        return authors.get(mostBooksLocation);
    }
}
