package com.sample.framework.odt;

public abstract class ODTRunner {
    protected boolean passedState = true;
    public abstract void run() throws Exception;
    public void beforeRun() throws Exception {

    }
    public void afterRun() throws Exception {

    }
    public void onError(Throwable e) throws Exception {

    }

    public boolean isPassedState() {
        return passedState;
    }

    public void setPassedState(boolean passedState) {
        this.passedState = passedState;
    }
}
