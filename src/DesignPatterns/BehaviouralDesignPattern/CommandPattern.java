package DesignPatterns.BehaviouralDesignPattern;

public class CommandPattern {

    public static void main(String[] args) {
        ChangeChannel cc = new ChangeChannel(new Channel());
        Button b = new Button(cc);
        b.operation1();

        ControlVolume cv = new ControlVolume(new Volume());
        b.setRemoteCommand(cv);
        b.operation2();
    }
}

// command interface provides a common method
interface RemoteCommand{
    public void operation1();
    public void operation2();
}

// concrete Channel related command object using receiver object as Channel by object composition
class ChangeChannel implements RemoteCommand{

    private Channel c;

    public ChangeChannel(Channel c) {
        this.c = c;
    }

    @Override
    public void operation1() {
        c.changeChannel();
    }

    @Override
    public void operation2() {
        c.playChannel();
    }
}

// concrete Volume related command object using receiver object as Volume by object composition
class ControlVolume implements RemoteCommand{

    private Volume v;

    public ControlVolume(Volume v) {
        this.v = v;
    }


    @Override
    public void operation1() {
        v.increaseVolume();
    }

    @Override
    public void operation2() {
        v.decreaseVolume();
    }
}

// receiver Channel object which has its own set of actions
class Channel{
    public void playChannel(){
        System.out.println("playing channel " );
    }
    public void changeChannel(){
        System.out.println("changing channel " );
    }
}

//reciver Volume object which has its own set of actions
class Volume{
    public void increaseVolume(){
        System.out.println("increasing volume");
    }
    public void decreaseVolume(){
        System.out.println("decreasing volume");
    }
}

//the actual invoker object which uses the Concrete command object tied to it.
// also has method to change the Concrete command object tied to it.
class Button{
   private RemoteCommand rc;

    public Button(RemoteCommand c) {
        this.rc = c;
    }

    public void operation1(){
        this.rc.operation1();
    }

    public void operation2(){
        this.rc.operation2();
    }

    public void setRemoteCommand(RemoteCommand rc){
        this.rc = rc;
    }
}


