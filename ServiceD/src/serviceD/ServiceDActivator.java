package serviceD;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import publishera.ServicePublish;

public class ServiceDActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext serviceDContext) throws Exception {
//		ServiceDActivator.context = bundleContext;
		System.out.println("Service Subscriber D is started to follow the publisher....");
		serviceReference = serviceDContext.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) serviceDContext.getService(serviceReference);
		System.out.println(servicePublish.publishService());
	}

	public void stop(BundleContext serviceDContext) throws Exception {
//		ServiceDActivator.context = null;
		System.out.println("Service Subscriber D is started to follow the publisher....");
		serviceDContext.ungetService(serviceReference);
	}

}
