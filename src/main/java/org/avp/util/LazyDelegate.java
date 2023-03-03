package org.avp.util;

/**
 * Delays object initialization until the object is actually needed.
 * 
 * @author Boston Vanseghi
 *
 */
public class LazyDelegate<T extends Object> {
	
	public interface LazyDelegateFactoryFunction<T> {
		T run();
	}
	
	private LazyDelegateFactoryFunction<T> func;
	private T instance;
	
	public LazyDelegate(LazyDelegateFactoryFunction<T> func) {
		this.func = func;
	}
	
	public T get() {
		if (instance == null) {
			instance = func.run();
		}
		
		return instance;
	}
}
