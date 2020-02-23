package serviceC;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import publishera.ServicePublish;

public class ServiceCActivator implements BundleActivator {

	ServiceReference serviceReference;
	
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext serviceCContext) throws Exception {
//		ServiceCActivator.context = bundleContext;
		System.out.println("Service subscriber C is started to folllow publisher");
		serviceReference = serviceCContext.getServiceReference(ServicePublish.class.getName());
		ServicePublish servicePublish = (ServicePublish) serviceCContext.getService(serviceReference);
		System.out.println(servicePublish.publishService());
	}

	public void stop(BundleContext serviceCContext) throws Exception {
//		ServiceCActivator.context = null;
		System.out.println("Service subscriber C is stopped folllowing publisher");
		serviceCContext.ungetService(serviceReference);
	}

}
