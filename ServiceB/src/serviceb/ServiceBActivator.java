package serviceb;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import publishera.ServicePublish;

public class ServiceBActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext serviceBContext) throws Exception {
//		ServiceBActivator.context = bundleContext;
		System.out.println("Service Subscriber B is started to follow....!!!!");
		serviceReference = serviceBContext.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) serviceBContext.getService(serviceReference);
		System.out.println(servicePublish.publishService());
	}

	public void stop(BundleContext serviceBContext) throws Exception {
//		ServiceBActivator.context = null;
		System.out.println("Service Subscriber B is stopped following....!!!!");
		serviceBContext.ungetService(serviceReference);
	}

}
