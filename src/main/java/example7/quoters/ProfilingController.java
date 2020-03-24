package example7.quoters;

/**
 * @author Alexey Druzik on 3/23/2020
 */
public class ProfilingController implements ProfilingControllerMBean {

    private boolean enabled=true;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
