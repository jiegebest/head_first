package demo;

import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;

public class Test {

	public static void main(String[] args) {
		System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "/Users/wangjie/Documents");
		DemoImpl demo = new DemoImpl();

		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(demo.getClass());
		enhancer.setCallback(new MyMethodInterceptor());
		DemoImpl proxy = (DemoImpl)enhancer.create();

		proxy.test();
	}
}
