package serviceA;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import publishera.ServicePublish;

public class ServiceAActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
//		ServiceAActivator.context = bundleContext;
		System.out.println("Service subscriber A is started to follow....");
		serviceReference = bundleContext.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) bundleContext.getService(serviceReference);
		System.out.println(servicePublish.publishService());
	}

	public void stop(BundleContext bundleContext) throws Exception {
//		ServiceAActivator.context = null;
		System.out.println("Service subscriber A is stopped following....");
		bundleContext.ungetService(serviceReference);
	}

}
