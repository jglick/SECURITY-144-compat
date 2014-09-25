package jenkins.security;

import hudson.remoting.Callable;
import org.jenkinsci.remoting.RoleChecker;
import org.jenkinsci.remoting.RoleSensitive;

/**
 * Convenient {@link Callable} meant to be run on slave.
 *
 * @author Kohsuke Kawaguchi
 * @since 1.THU
 */
public abstract class MasterToSlaveCallable<V, T extends Throwable> implements Callable<V,T> {
    public void checkRoles(RoleChecker checker) throws SecurityException {
        // no check actually happens when this class definition is used, so this code will never run
        checker.check((RoleSensitive)this,Roles.SLAVE);
    }

    private static final long serialVersionUID = 1L;
}