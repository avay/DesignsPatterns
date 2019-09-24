package DesignPatterns.StructuralDesignPatterns;

public class ProxyPattern {

    public static void main(String[] args) {

            User usr = new User("dev","dev");
            ProxyFolder p = new ProxyFolder(usr);
            p.folderOperation();

            User usr1 = new User("dev","invalid");
            ProxyFolder p1 = new ProxyFolder(usr1);
            p1.folderOperation();


    }
}

class User{
    private String username;
    private  String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

interface IFolder{
    public void folderOperation();
}

class ActualFolder implements IFolder{

    @Override
    public void folderOperation() {
        System.out.println("performing operation on actual folder" );
    }
}


// this class provides an extra layer of access validation before invoking method on actual object
class ProxyFolder implements IFolder{

    ActualFolder folder;
    User usr;

    public ProxyFolder(User usr) {
        this.usr = usr;
    }

    @Override
    public void folderOperation() {
        if( (usr.getUsername().equals("dev")) && usr.getPassword().equals("dev")){
            folder = new ActualFolder();
            folder.folderOperation();
        }
        else
            System.out.println("no access to actual folder" );
    }
}
