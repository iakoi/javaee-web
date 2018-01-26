package poe.javaee.web.bean;

import javax.ejb.Stateless;

@Stateless
public class DisplayService {

    private int callCount;

    public String say(String something) {
        return "i want to say " + something + " for the " + callCount++ + " times";
    }


    public void add() {
        callCount++;
    }

    public int getCallCount() {
        return callCount;
    }

    public void setCallCount(int callCount) {
        this.callCount = callCount;
    }
}
