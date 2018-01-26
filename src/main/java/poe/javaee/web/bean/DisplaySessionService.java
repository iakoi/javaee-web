package poe.javaee.web.bean;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@Stateful
public class DisplaySessionService {

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
