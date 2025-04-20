package LLD.designpatterns.iteratordesignpattern;

import java.util.ArrayList;
import java.util.List;

// Iterator Interface
interface  Iterator {
    Boolean hasNext();
    User next();
}

// Concrete Iterator
class UserIterator  implements Iterator{
    List<User> users ;
    int index =0;

    public  UserIterator(  List<User> users ){
       this.users= users;
    }

    @Override
    public Boolean hasNext(){
     return index<users.size();
    }

    @Override
    public User next(){
        return users.get(index++);
    }

}

// Aggregate Interface
interface Collection{
    Iterator createIterator();
}

// Concrete Aggregate (Stores a list of Users)
class UserCollection implements  Collection {
    List<User> users ;

    public UserCollection(){
        users = new ArrayList<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    @Override
    public Iterator createIterator() {
        return new UserIterator(users);
    }
}

class User{
    String name ;
    public User(String name ){
        this.name= name;
    }

    public String getName(){
        return name;
    }
}

public class IteratorDesignPattenExample {

    public static void main(String[] args) {
            UserCollection userCollection = new UserCollection();
            userCollection.addUser(new User("yash"));
            userCollection.addUser(new User("ankit"));
            userCollection.addUser(new User("gitesh"));
            Iterator userIterator = userCollection.createIterator();

            while (userIterator.hasNext()){
                System.out.println(userIterator.next().getName());
            }
    }

}
